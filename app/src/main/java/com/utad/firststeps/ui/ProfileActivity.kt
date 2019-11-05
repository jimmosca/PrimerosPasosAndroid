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
        intent.putExtra("name", "Jose Mateo")
        intent.putExtra("birth_date", "19/07/1996")
        intent.putExtra("city", "Madrid")
        intent.putExtra("image", R.drawable.pepe)
        intent.putExtra("description", "Lorem ipsum dolor sit amet consectetur adipiscing elit torquent aliquam nam augue varius libero, interdum pellentesque viverra inceptos congue conubia sollicitudin in gravida ridiculus curae. Primis aliquam porttitor quam dapibus magnis habitant nostra condimentum laoreet, maecenas praesent per non posuere himenaeos auctor parturient vel tempus, class inceptos platea augue feugiat convallis sodales ullamcorper. Inceptos volutpat lectus proin integer posuere egestas interdum, libero nec penatibus habitasse magna molestie cubilia feugiat, fringilla aliquet etiam mollis tortor senectus.\n" +
                "\n" +
                "Vestibulum conubia inceptos nec sollicitudin nostra curabitur ut morbi quis habitant proin, erat mauris hendrerit curae dapibus facilisi potenti vitae natoque. Bibendum magna varius per maecenas elementum quam suscipit, nulla ac nisl quis nam iaculis, fusce accumsan inceptos lectus vulputate ridiculus. Luctus quisque praesent proin purus aliquet nibh, inceptos litora arcu fusce est feugiat venenatis, magna id vivamus mus nulla.")

        //Setting the component with the intent values

       /* imgProfile.setImageResource(image!!)
        txtNameProfile.text = name!!
        txtBirthDate.text = birthDate!!
        txtCity.text = city!!
        txtDescription.text = description!!*/



    }
}
