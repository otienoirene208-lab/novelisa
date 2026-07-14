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

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        find the textview by use of its id
        val signuptxt =findViewById<TextView>(R.id.txtSignup)

        signuptxt.setOnClickListener {
            val newpage = Intent(applicationContext, SignupActivity::class.java)
            startActivity(newpage)
        }
//        find the button edit by the use of id
        val emailEditText=findViewById<EditText>(R.id.email)
        val passwordEditText=findViewById<EditText>(R.id.password)
        val signinBtn =findViewById<Button>(R.id.buttonsignin)

//specify what happens when the button is clicked.
        signinBtn.setOnClickListener {
            //set the API endpoint
            val api = "https://adhiambo.alwaysdata.net/api/signin"

            //create requestparams that acts as an envelop to hold your data
            val data = RequestParams()

            //extract the data from the edit text and add the same to the RequestParams
            data.put("email", emailEditText.text.toString().trim())
            data.put("password", passwordEditText.text.toString())

            //import the APi helper class
            val helper = ApiHelper(applicationContext)

            //access the method post_login in the helper class
            helper.post_login(api, data )
        }


    }
}