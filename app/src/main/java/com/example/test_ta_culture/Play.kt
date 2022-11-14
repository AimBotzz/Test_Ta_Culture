package com.example.test_ta_culture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Play : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play2)
        auth = Firebase.auth
         db = Firebase.firestore
        val scoreData = hashMapOf(
            "Score" to 25
        )

        db.collection("DataGame")
            .document(auth.currentUser!!.uid).set(scoreData)
            .addOnSuccessListener { documentReference ->
                Log.d("Play", "DocumentSnapshot added with ID: ${documentReference}")
            }
            .addOnFailureListener { e ->
                Log.w("Play", "Error adding document", e)
            }

    }
    public override fun onResume() {
        super.onResume()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val z = Intent(this, MainActivity::class.java)
            startActivity(z)
        }
    }
}
