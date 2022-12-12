package com.rakesh.cvbuilderapplication

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    val REQUEST_ID_MULTIPLE_PERMISSIONS = 400

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkAndRequestPermissions()
    }

    private fun onSelectedTelegram() {
        shareResume(getString(R.string.share_information), "org.telegram.messenger")
    }

    private fun onSelectedLinkedIn() {
        shareResume(getString(R.string.share_information), "com.linkedin.android")
    }

    private fun onSelectedWhatsApp() {
        shareResume(getString(R.string.share_information), "com.whatsapp")
    }

    private fun onSelectedGmail() {
        shareResume(getString(R.string.share_information), "com.google.android.gm")
    }

    private fun shareResume(msg: String, appName: String) {
        val isAppInstalled: Boolean = isAppAvailable(appName)
        if (isAppInstalled) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"
            myIntent.setPackage(appName)
            myIntent.putExtra(Intent.EXTRA_TEXT, msg) //
            startActivity(Intent.createChooser(myIntent, "Share with"))
        } else {
            Toast.makeText(this, "App not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAppAvailable(appName: String?): Boolean {
        return try {
            packageManager.getPackageInfo(appName!!, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.telegram_menu -> {
                onSelectedTelegram()
                true
            }

            R.id.linked_in_menu -> {
                onSelectedLinkedIn()
                true
            }

            R.id.whats_app_menu -> {
                onSelectedWhatsApp()
                true
            }

            R.id.gmail_menu -> {
                onSelectedGmail()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    fun checkAndRequestPermissions(): Boolean {
        val call = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CALL_PHONE)
        val listPermissionsNeeded = ArrayList<String>()
        if (call != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE)
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this@MainActivity, listPermissionsNeeded.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                // Initialize the map with both permissions
                perms[Manifest.permission.CALL_PHONE] = PackageManager.PERMISSION_GRANTED
                // Fill with actual results from user
                if (grantResults.size > 0) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]

                    if (perms[Manifest.permission.CALL_PHONE] == PackageManager.PERMISSION_GRANTED
                    ) {
                        print("Storage permissions are required")

                    } else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            showDialogOK("Call  permission is required for this app",
                                DialogInterface.OnClickListener { dialog, which ->
                                    when (which) {
                                        DialogInterface.BUTTON_POSITIVE -> checkAndRequestPermissions()
                                        DialogInterface.BUTTON_NEGATIVE -> {
                                        }
                                    }
                                })
                        } else {
                            Toast.makeText(this@MainActivity, "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                .show()

                        }
                    }
                }
            }
        }

    }

    fun showDialogOK(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this@MainActivity)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", okListener)
            .create()
            .show()
    }
    
}