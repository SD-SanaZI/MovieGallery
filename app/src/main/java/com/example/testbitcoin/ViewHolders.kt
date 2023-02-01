package com.example.testbitcoin

import android.content.Context
import android.graphics.PorterDuff
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView

//Добавить шаблонизацию

class FilmViewHolder(view: View,private val context: Context):RecyclerView.ViewHolder(view) {
    private val name: TextView = itemView.findViewById(R.id.FilmNameTxt1)
    private val tag: TextView = itemView.findViewById(R.id.FilmTagTxtView)
    private val ageLimit: TextView = itemView.findViewById(R.id.FilmAgeLimitTxt1)
    private val image: ImageView = itemView.findViewById(R.id.FilmImg1)
    private val countReview: TextView = itemView.findViewById(R.id.CountReviewTxtView)
    private val time: TextView = itemView.findViewById(R.id.TimeTxt1)
    private val like: ImageView = itemView.findViewById(R.id.LikeImg1)
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
        image.setOnClickListener {
            fragmentClickListener?.openMovieDetailsClicked(film.id)
        }
        countReview.text = context.getString(R.string.film_count_review, film.countReviews)
        time.text = context.getString(R.string.timefilm1, film.time)
        if(film.hasLike) ImageViewCompat.setImageTintList(like, AppCompatResources.getColorStateList(context, R.color.pink))
        else ImageViewCompat.setImageTintMode(like, PorterDuff.Mode.SRC_IN)
        like.setOnClickListener {
            fragmentClickListener?.like(film.id)
        }
        Log.i("like", "id:" + film.id + " like:" + film.hasLike.toString())
    }
}

class ActorViewHolder(view: View,private val context: Context):RecyclerView.ViewHolder(view) {
    private val name: TextView = itemView.findViewById(R.id.ActorTxtView)
    private val image: ImageView = itemView.findViewById(R.id.ActorImgView)

    fun bind(film: ActorData){
        name.text = film.name
        image.setImageResource(film.image)
    }
}