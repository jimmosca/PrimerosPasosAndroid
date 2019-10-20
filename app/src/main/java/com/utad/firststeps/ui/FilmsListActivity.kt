package com.utad.firststeps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.firststeps.R
import kotlinx.android.synthetic.main.activity_films_list.*;

class FilmsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films_list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter =
    }
}
