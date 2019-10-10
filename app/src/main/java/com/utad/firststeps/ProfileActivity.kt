package com.utad.firststeps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var txtNameProfile: TextView
    private lateinit var txtBirthDate: TextView
    private lateinit var txtCity: TextView
    private lateinit var txtDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        imgProfile = findViewById(R.id.imgProfile)
        txtNameProfile = findViewById(R.id.txtNameProfile)
        txtBirthDate = findViewById(R.id.txtBirthDate)
        txtCity = findViewById(R.id.txtCity)
        txtDescription = findViewById(R.id.txtDescription)

        val image = intent.extras?.get("image")
        val name = intent.extras?.get("name")
        val birthDate = intent.extras?.get("birth_date")
        val city = intent.extras?.get("city")
        val description = intent.extras?.get("description")


    }
}
