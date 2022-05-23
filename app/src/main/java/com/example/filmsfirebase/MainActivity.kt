package com.example.filmsfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("Films").child("1").setValue(Film("Avatar", "2009", "fl497", "film", "https://www.ebay.com/itm/AVATAR-MOVIE-POSTER-FILM-A4-A3-ART-PRINT-CINEMA-/232067405950?_ul=PE", "USA", "Acción/Ciencia Ficción"))
        myRef.child("Films").child("2").setValue(Film("Alice in Wonderland", "2010", "fl285", "film", "https://www.cinemascomics.com/primer-poster-oficial-alicia-pais-las-maravillas-tim-burton/", "USA", "Acción/Ciencia Ficción"))
        myRef.child("Films").child("3").setValue(Film("The Walking Dead","2011","fl279","serie","https://www.sensacine.com/series/serie-7330/","USA","Terror/Suspenso/Ciencia Ficción"))

        myRef.child("Films").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
    }
}