package com.example.testbitcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

interface FragmentClickListener{
    fun openMovieDetailsClicked()
}

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.main_conteiner, FragmentMovieList())
                .commit()
        }
    }

    override fun openMovieDetailsClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_conteiner, FragmentMoviesDetails())
            .commit()
    }
}