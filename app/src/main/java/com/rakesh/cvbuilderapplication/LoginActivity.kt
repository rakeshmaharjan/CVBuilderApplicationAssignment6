package com.rakesh.cvbuilderapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.rakesh.cvbuilderapplication.constants.AppConstants
import com.rakesh.cvbuilderapplication.constants.AppConstants.IS_LOGGED_IN
import com.rakesh.cvbuilderapplication.constants.AppConstants.PREFERRED_NAME
import com.rakesh.cvbuilderapplication.constants.AppConstants.EMAIL
import com.rakesh.cvbuilderapplication.constants.AppConstants.USERNAME
import com.rakesh.cvbuilderapplication.constants.AppConstants.PASSWORD

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //init shared preference operations
        val sharedPref = getSharedPreferences(AppConstants.PREFERRED_NAME,0)
        if (sharedPref.getBoolean(IS_LOGGED_IN, false)) {
            openMainActivity()
        }else {
            initializeSharedData()
        }

        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener(this)

    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initializeSharedData() {
        val sharedData = getSharedPreferences(AppConstants.PREFERRED_NAME, 0)
        val data = sharedData.edit()
        data.putString(EMAIL, "rakeshmaharjan@miu.edu")
        data.putString(PASSWORD, "rakesh")
        data.putString(USERNAME, "Rakesh Maharjan")
        data.putBoolean(IS_LOGGED_IN, false)
        data.apply()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.login_button -> {
                if (validateFields()) {
                    if (checkAuthorization()) {

                        //set login as true
                        val sharedPref = getSharedPreferences(AppConstants.PREFERRED_NAME, 0)
                        val editor = sharedPref.edit()
                        editor.putBoolean(IS_LOGGED_IN, true)
                        editor.apply()

                        openMainActivity()

                    }else {
                        Toast.makeText(this,"Email or Password not match!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkAuthorization(): Boolean {
        val sharedPref = getSharedPreferences(AppConstants.PREFERRED_NAME,0)
        val email = sharedPref.getString(EMAIL,"")
        val password = sharedPref.getString(PASSWORD,"")
        Log.v("LoginActivity", "$email : $password")
        if (emailEditText.text.toString().trim() != email || passwordEditText.text.toString().trim() != password) {
            return false
        }
        return true
    }

    private fun validateFields(): Boolean {
        if (emailEditText.text.isEmpty()) {
            emailEditText.error = "Email can not be empty"
            emailEditText.requestFocus()
            return false
        } else if (passwordEditText.text.isEmpty()) {
            passwordEditText.error = "Password can not be empty"
            passwordEditText.requestFocus()
            return false;
        }

        return true
    }

}