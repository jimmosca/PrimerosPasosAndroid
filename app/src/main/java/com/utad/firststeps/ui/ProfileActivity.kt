package com.utad.firststeps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.utad.firststeps.R

class ProfileActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var txtNameProfile: TextView
    private lateinit var txtBirthDate: TextView
    private lateinit var txtCity: TextView
    private lateinit var txtDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Initialization of UI components
        imgProfile = findViewById(R.id.imgProfile)
        txtNameProfile = findViewById(R.id.txtNameProfile)
        txtBirthDate = findViewById(R.id.txtBirthDate)
        txtCity = findViewById(R.id.txtCity)
        txtDescription = findViewById(R.id.txtDescription)

        //Getting the intent values
        val image = intent.extras?.getInt("image")
        val name = intent.extras?.getString("name")
        val birthDate = intent.extras?.getString("birth_date")
        val city = intent.extras?.getString("city")
        val description = intent.extras?.getString("description")

        //Setting the component with the intent values

        imgProfile.setImageResource(image!!)
        txtNameProfile.text = name!!
        txtBirthDate.text = birthDate!!
        txtCity.text = city!!
        txtDescription.text = description!!



    }
}
