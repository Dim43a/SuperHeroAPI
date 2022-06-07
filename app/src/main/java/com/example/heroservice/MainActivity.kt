package com.example.heroservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.apijokes.R

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val lvResult = findViewById<ListView>(R.id.lvView)
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val idInput = findViewById<EditText>(R.id.idInput)

        val textViewId = findViewById<TextView>(R.id.texViewId)

        val btnGetHeroID = findViewById<Button>(R.id.btnHeroID)
        btnGetHeroID.setOnClickListener {
           HeroService().getHeroID(nameInput.text.toString(), this@MainActivity, textViewId)
            textViewId.text = nameInput.text.toString()
        }

        val btnGetInfoByID = findViewById<Button>(R.id.btnGetPowerStats)
        btnGetInfoByID.setOnClickListener {
            HeroService().getPowerStatsByID(idInput.text.toString(),this@MainActivity, lvResult)
            imageView.setImageResource(android.R.color.transparent)
        }

        val btnGetImageByID = findViewById<Button>(R.id.btnImage)
        btnGetImageByID.setOnClickListener {
            HeroService().getHeroImage(idInput.text.toString(), this@MainActivity, imageView)
        }

        val btnGetBiography = findViewById<Button>(R.id.btnGetBiography)
        btnGetBiography.setOnClickListener {
            HeroService().getHeroBiography(idInput.text.toString(), this@MainActivity, lvResult)
            imageView.setImageResource(android.R.color.transparent)
        }

        val btnGetWork = findViewById<Button>( R.id.btnGetWork)
        btnGetWork.setOnClickListener {
            HeroService().getHeroWork(idInput.text.toString(), this@MainActivity, lvResult)
            imageView.setImageResource(android.R.color.transparent)
        }

        val btnGetConnections = findViewById<Button>(R.id.btnGetConnections)
        btnGetConnections.setOnClickListener{
            HeroService().getHeroConnections(idInput.text.toString(), this@MainActivity, lvResult)
            imageView.setImageResource(android.R.color.transparent)
        }
    }
}