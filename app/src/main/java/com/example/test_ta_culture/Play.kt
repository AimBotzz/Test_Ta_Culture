package com.example.test_ta_culture

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
class Play : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play2)

        auth = Firebase.auth
        db = Firebase.firestore
        var questionCount = 0
        var questionSuivante = findViewById<TextView>(R.id.nextQuestion)
        var question = findViewById<TextView>(R.id.question)
        var reponse1 = findViewById<Button>(R.id.reponse1)
        var reponse2 = findViewById<Button>(R.id.reponse2)
        var reponse3 = findViewById<Button>(R.id.reponse3)
        var reponse4 = findViewById<Button>(R.id.reponse4)
        var score = findViewById<TextView>(R.id.score)
        var image = findViewById<ImageView>(R.id.answer)
        db.collection("DataQuizz")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Play", "${document.id} => ${document.data}")


                    var q0 = (document.get("questions") as ArrayList<HashMap<String, String>>)[0]
                    var q1 = (document.get("questions") as ArrayList<HashMap<String, String>>)[1]
                    var q2 = (document.get("questions") as ArrayList<HashMap<String, String>>)[2]



                    this.mediaPlayer = MediaPlayer.create(applicationContext, R.raw.a7xnightmare)
                    reponse1.text = q0["bonneRep"] as String
                    reponse2.text = q0["mauvaiseRep"] as String
                    reponse3.text = q0["mauvaiseRep2"] as String
                    reponse4.text = q0["mauvaiseRep3"] as String
                    question.text = q0["question"] as String
                    reponse1.setOnClickListener {
                        image.setImageResource(R.drawable.yes)
                        questionCount++
                        val compteScore = Integer.parseInt(score.text as String) + 1
                        score.text = compteScore.toString()
                        questionSuivante.visibility = View.VISIBLE
                        reponse1.isClickable = false
                        reponse2.isClickable = false
                        reponse3.isClickable = false
                        reponse4.isClickable = false
                    }






                    reponse2.setOnClickListener {
                        image.setImageResource(R.drawable.croixrouge)
                        questionSuivante.visibility = View.VISIBLE
                        reponse1.isClickable = false
                        reponse2.isClickable = false
                        reponse3.isClickable = false
                        reponse4.isClickable = false
                        questionCount++
                    }


                    reponse3.setOnClickListener {
                        image.setImageResource(R.drawable.croixrouge)
                        questionSuivante.visibility = View.VISIBLE
                        reponse1.isClickable = false
                        reponse2.isClickable = false
                        reponse3.isClickable = false
                        reponse4.isClickable = false
                        questionCount++
                    }

                    reponse4.setOnClickListener {
                        image.setImageResource(R.drawable.croixrouge)
                        questionSuivante.visibility = View.VISIBLE
                        reponse1.isClickable = false
                        reponse2.isClickable = false
                        reponse3.isClickable = false
                        reponse4.isClickable = false
                        questionCount++

                    }
                    questionSuivante.setOnClickListener {
                        if (questionCount == 1) {
                            this.mediaPlayer = MediaPlayer.create(applicationContext, R.raw.playgod)
                            questionSuivante.visibility = View.INVISIBLE
                            image.visibility = View.INVISIBLE
                            reponse1.isClickable = true
                            reponse2.isClickable = true
                            reponse3.isClickable = true
                            reponse4.isClickable = true
                            reponse1.text = q1["mauvaiseRep"] as String
                            reponse2.text = q1["mauvaiseRep2"] as String
                            reponse3.text = q1["bonneRep"] as String
                            reponse4.text = q1["mauvaiseRep3"] as String
                            question.text = q1["question"] as String
                            reponse1.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                image.visibility = View.VISIBLE
                                questionSuivante.visibility = View.VISIBLE
                                questionCount++
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                            reponse2.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                questionCount++
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false


                            }
                            reponse3.setOnClickListener {
                                image.setImageResource(R.drawable.yes)
                                val compteScore = Integer.parseInt(score.text as String) + 1
                                score.text = compteScore.toString()
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                questionCount++
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                            reponse4.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                questionCount++
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                        }
                        if (questionCount == 2) {
                            this.mediaPlayer = MediaPlayer.create(applicationContext, R.raw.blacksabbath)
                            questionSuivante.visibility = View.INVISIBLE
                            image.visibility = View.INVISIBLE
                            reponse1.isClickable = true
                            reponse2.isClickable = true
                            reponse3.isClickable = true
                            reponse4.isClickable = true
                            reponse1.text = q2["mauvaiseRep"] as String
                            reponse2.text = q2["mauvaiseRep2"] as String
                            reponse3.text = q2["mauvaiseRep3"] as String
                            reponse4.text = q2["bonneRep"] as String
                            question.text = q2["question"] as String
                            reponse1.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                image.visibility = View.VISIBLE
                                questionSuivante.visibility = View.VISIBLE
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                            reponse2.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false


                            }
                            reponse3.setOnClickListener {
                                image.setImageResource(R.drawable.croixrouge)
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                            reponse4.setOnClickListener {
                                image.setImageResource(R.drawable.yes)
                                val compteScore = Integer.parseInt(score.text as String) + 1
                                score.text = compteScore.toString()
                                questionSuivante.visibility = View.VISIBLE
                                image.visibility = View.VISIBLE
                                reponse1.isClickable = false
                                reponse2.isClickable = false
                                reponse3.isClickable = false
                                reponse4.isClickable = false
                            }
                        }

                    }
                }
            }


            .addOnFailureListener { exception ->
                Log.w("Play", "Error getting documents.", exception)
            }


        val scoreData = hashMapOf(
            "Score" to 10
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

    fun playSound(view: View) {
        mediaPlayer.start()
    }
}