package com.example.testbitcoin

import android.content.Context
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.ImageViewCompat

class DetailsChanger(private  val view: View) {
    private val name: TextView = view.findViewById(R.id.FilmNameTxtView)
    private val tag: TextView = view.findViewById(R.id.FilmTagTxtView)
    private val ageLimit: TextView = view.findViewById(R.id.AgeLimitTxtView)
    private val image: ImageView = view.findViewById(R.id.MaskImgView)
    private val countReview: TextView = view.findViewById(R.id.CountReviewTxtView)
    private val story: TextView = view.findViewById(R.id.StorulineTextTxtView)

    fun bind(film: FilmData){
        name.text = film.name
        tag.text = film.tag
        ageLimit.text = film.age_limit
        image.setImageResource(film.image)
        countReview.text = view.context.getString(R.string.film_count_review, 79)
        story.text = film.story
    }
}