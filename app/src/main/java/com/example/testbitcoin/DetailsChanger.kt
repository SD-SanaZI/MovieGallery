package com.example.testbitcoin

import android.content.Context
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.ImageViewCompat

class DetailsChanger(view: View, private val context: Context) {
    private val name: TextView = view.findViewById(R.id.FilmNameTxtView)
    private val tag: TextView = view.findViewById(R.id.FilmTagTxtView)
    private val ageLimit: TextView = view.findViewById(R.id.AgeLimitTxtView)
    private val image: ImageView = view.findViewById(R.id.MaskImgView)
    private val countReview: TextView = view.findViewById(R.id.CountReviewTxtView)
    private val story: TextView = view.findViewById(R.id.StorulineTextTxtView)
    private var fragmentClickListener: FragmentClickListener? = null
    init {
        if(context is FragmentClickListener)
            fragmentClickListener = context
    }

    fun bind(film: FilmData){
        name.text = film.name
        tag.text = film.tag
        ageLimit.text = film.age_limit
        image.setImageResource(film.image)
        countReview.text = film.countReviews.toString() + " reviews"
        story.text = film.story
    }
}