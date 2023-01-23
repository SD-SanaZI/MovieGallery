package com.example.testbitcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

interface FragmentClickListener{
    fun openMovieDetailsClicked(id: Int)
    fun openFilmsListPage(page: Int)
}

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.main_conteiner, FragmentMovieList(1))
                .commit()
        }
    }

    override fun openMovieDetailsClicked(id: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_conteiner, FragmentMoviesDetails(id))
            .commit()
        Log.i("main", id.toString())
    }

    override fun openFilmsListPage(page: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_conteiner, FragmentMovieList(page))
            .commit()
    }
}