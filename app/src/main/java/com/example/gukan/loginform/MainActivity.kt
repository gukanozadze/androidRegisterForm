package com.example.gukan.loginform

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextUtils
import android.view.View


class MainActivity : AppCompatActivity() {

    fun isEmailValid(email: String?): Boolean {
        return !(email == null || TextUtils.isEmpty(email)) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun alert(string: String){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerButton.setOnClickListener{

            if (formUsername.text.toString().isEmpty() || formEmail.text.toString().isEmpty() || formPassword.text.toString().isEmpty() || formPasswordReenter.text.toString().isEmpty()){
                alert("Please Fill in All Fields")
                afterRegisterText.setVisibility(View.GONE)

            }else if(!isEmailValid(formEmail.text.toString())){
                alert("Email is incorrect")
                afterRegisterText.setVisibility(View.GONE)

            }else if(!formPassword.text.toString().equals(formPasswordReenter.text.toString())){
                alert("Passwords Don't Match!")
                afterRegisterText.setVisibility(View.GONE)

            }else{

                alert("Successfully Registered")
                afterRegisterText.setText("Successfully Registered!\nUsername: " + formUsername.text.toString() + "\nEmail: " + formEmail.text.toString())
                afterRegisterText.setVisibility(View.VISIBLE)
            }
        }
    }
}
