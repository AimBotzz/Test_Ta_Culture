package com.example.test_ta_culture

import android.content.ContentValues.TAG
import com.google.firebase.ktx.Firebase


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth

class NewAccount : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    //FirebaseFirestore firestore;
    //private lateinit var auth: FirebaseAuth
// ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

        auth = Firebase.auth
        val i = Intent(this, MainActivity::class.java)
        findViewById<Button>(R.id.SignUp).setOnClickListener {
            var username = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            var password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            if (username.isNullOrBlank() && password.isNullOrBlank()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            auth.signOut()
                            startActivity(i)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }

    }


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {

        }
    }
}

