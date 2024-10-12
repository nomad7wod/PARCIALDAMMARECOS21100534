package com.example.repaso_parcial

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title = "Sign In"
        val emailSuccess: String = "admin@travelapp.com"
        val passwordSuccess: String = "admin123"

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email: String = etEmail.text.trim().toString()
            val password: String = etPassword.text.trim().toString()


            if(email == emailSuccess && password == passwordSuccess){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            val rootView: View = findViewById(android.R.id.content)
            Snackbar.make(rootView,"Credenciales Invalidas", Snackbar.LENGTH_LONG).show()
        }


    }
}