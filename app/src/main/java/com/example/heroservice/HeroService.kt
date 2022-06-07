package com.example.heroservice

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.heroservice.data.HeroBiography
import com.example.heroservice.data.HeroConnections
import com.example.heroservice.data.HeroPowerStats
import com.example.heroservice.data.HeroWork

private const val accessToken = 506001017976265


class HeroService {
    fun getPowerStatsByID(string: String, context: Context, lv: ListView){
        val url = "https://superheroapi.com/api/$accessToken/$string/powerstats"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try  {
                    val arr = mutableListOf<HeroPowerStats>()
                    arr.add(HeroPowerStats(
                        name = response.getString("name"),
                        intelligence = response.getString("intelligence"),
                        strength = response.getString("strength"),
                        speed = response.getString("speed"),
                        durability = response.getString("durability"),
                        power = response.getString("power"),
                        combat = response.getString("combat")
                    ))
                    val arrayAdapter = ArrayAdapter(context, R.layout.simple_list_item_1, arr)

                    lv.adapter = arrayAdapter
                } catch(e: Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->

                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }

    @SuppressLint("SetTextI18n")
    fun getHeroID(string: String, context: Context, text: TextView){
        val url = "https://superheroapi.com/api/$accessToken/search/$string"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val results = response.getJSONArray("results").getJSONObject(0)
                    val id = results.getString("id")

                    text.text = "$string ID: $id"
                } catch(e: java.lang.Exception) {
                    Toast.makeText(context, "No found ID's for $string", Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }

    fun getHeroImage(string: String, context: Context, imageView: ImageView){
        val url = "https://superheroapi.com/api/$accessToken/$string/image"
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val test = response.getString("url")
                    val image: Bitmap?
                    val `in` = java.net.URL(test).openStream()
                    image = BitmapFactory.decodeStream(`in`)

                    imageView.setImageBitmap(image)
                } catch(e: java.lang.Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }

    fun getHeroBiography(string: String, context: Context, lv: ListView){
        val url = "https://superheroapi.com/api/$accessToken/$string/biography"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val arr = mutableListOf<HeroBiography>()
                    arr.add(HeroBiography(
                        fullName = response.getString("full-name"),
                        alterEgos = response.getString("alter-egos"),
                        aliases = response.getJSONArray("aliases"),
                        placeOfBirth = response.getString("place-of-birth"),
                        firstAppearance = response.getString("first-appearance"),
                        publisher = response.getString("publisher"),
                        alignment = response.getString("alignment")
                    ))
                    val arrayAdapter = ArrayAdapter(context, R.layout.simple_list_item_1, arr)
                    lv.adapter = arrayAdapter

                } catch(e: java.lang.Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }

    fun getHeroWork(string: String, context: Context, lv: ListView){
        val url = "https://superheroapi.com/api/$accessToken/$string/work"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val arr = mutableListOf<HeroWork>()
                    arr.add(HeroWork(
                        name = response.getString("name"),
                        occupation = response.getString("occupation"),
                        base = response.getString("base"),
                    ))
                    val arrayAdapter = ArrayAdapter(context, R.layout.simple_list_item_1, arr)
                    lv.adapter = arrayAdapter

                } catch(e: java.lang.Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }

    fun getHeroConnections(string: String, context: Context, lv: ListView){
        val url = "https://superheroapi.com/api/$accessToken/$string/connections"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    val arr = mutableListOf<HeroConnections>()
                    arr.add(HeroConnections(
                        name = response.getString("name"),
                        groupAffiliation = response.getString("group-affiliation"),
                        relatives = response.getString("relatives"),
                    ))
                    val arrayAdapter = ArrayAdapter(context, R.layout.simple_list_item_1, arr)
                    lv.adapter = arrayAdapter

                } catch(e: java.lang.Exception) {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        MySingleton.getInstance(context).addToRequestQueue(request)
    }
}