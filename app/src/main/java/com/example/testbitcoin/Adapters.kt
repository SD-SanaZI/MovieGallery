package com.example.testbitcoin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Добавить шаблонизацию

class FilmAdapter(var filmData:List<FilmData>, var context:Context):RecyclerView.Adapter<FilmViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int  = filmData.size

    fun getItem(position: Int): FilmData = filmData[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(inflater.inflate(R.layout.view_holder_movie, parent, false),context)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ActorAdapter(var ActorData:List<ActorData>, var context:Context):RecyclerView.Adapter<ActorViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int  = ActorData.size

    fun getItem(position: Int): ActorData = ActorData[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(inflater.inflate(R.layout.view_holder_details, parent, false),context)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
