package com.example.novelnest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        find the textview
        val Signuptxt =findViewById<TextView>(R.id.txtSignin)
        Signuptxt.setOnClickListener {
            val newpage = Intent(applicationContext, SigninActivity::class.java)
            startActivity(newpage)
        }

//        find the button edit by the use of id
        val emailEditText=findViewById<EditText>(R.id.email)
        val passwordEditText=findViewById<EditText>(R.id.password)
        val usernameEditText=findViewById<EditText>(R.id.username)
        val phoneEditText=findViewById<EditText>(R.id.phone)
        val signinBtn =findViewById<Button>(R.id.buttonsignin)

//specify what happens when the button is clicked.
        signinBtn.setOnClickListener {
            //set the API endpoint
            val api = "https://adhiambo.alwaysdata.net/api/signup"

            //create requestparams that acts as an envelop to hold your data
            val data = RequestParams()

            //extract the data from the edit text and add the same to the RequestParams
            data.put("email", emailEditText.text.toString().trim())
            data.put("password", passwordEditText.text.toString())
            data.put("username",usernameEditText.text.toString().trim())
            data.put("phone",phoneEditText.text.toString())

            //import the APi helper class
            val helper = ApiHelper(applicationContext)

            //access the method post_login in the helper class
            helper.post(api, data )
        }



    }
}