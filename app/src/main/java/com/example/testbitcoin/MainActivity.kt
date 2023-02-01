package com.example.testbitcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

interface FragmentClickListener{
    fun openMovieDetailsClicked(id: Int)
    fun openFilmsListPage(page: Int)
    fun like(id: Int)
}

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.main_conteiner, FragmentMovieList.newInstanse(1))
                .commit()
        }
    }

    override fun openMovieDetailsClicked(id: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_conteiner, FragmentMoviesDetails.newInstanse(id))
            .commit()
    }

    override fun openFilmsListPage(page: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_conteiner, FragmentMovieList.newInstanse(page))
            .commit()
    }

    override fun like(id: Int) {
        DbHelper(this,null).likeFilm(id)
    }
}