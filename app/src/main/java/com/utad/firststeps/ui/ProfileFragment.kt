package com.utad.firststeps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.utad.firststeps.R

class ProfileFragment : Fragment() {
    private lateinit var imgProfile: ImageView
    private lateinit var txtNameProfile: TextView
    private lateinit var txtBirthDate: TextView
    private lateinit var txtCity: TextView
    private lateinit var txtDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        //Initialization of UI components
        imgProfile = view.findViewById(R.id.imgProfile)
        txtNameProfile = view.findViewById(R.id.txtNameProfile)
        txtBirthDate = view.findViewById(R.id.txtBirthDate)
        txtCity = view.findViewById(R.id.txtCity)
        txtDescription = view.findViewById(R.id.txtDescription)

        //Setting the component with the intent values

        imgProfile.setImageResource(R.drawable.pepe)
        txtNameProfile.text = "Jose Mateo"
        txtBirthDate.text = "19/07/1996"
        txtCity.text = "Madrid"
        txtDescription.text = "Vestibulum conubia inceptos nec sollicitudin nostra curabitur ut morbi quis habitant proin, erat mauris hendrerit curae dapibus facilisi potenti vitae natoque. Bibendum magna varius per maecenas elementum quam suscipit, nulla ac nisl quis nam iaculis, fusce accumsan inceptos lectus vulputate ridiculus. Luctus quisque praesent proin purus aliquet nibh, inceptos litora arcu fusce est feugiat venenatis, magna id vivamus mus nulla."


        return view
    }
}
