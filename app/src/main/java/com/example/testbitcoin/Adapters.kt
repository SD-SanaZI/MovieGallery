package com.example.testbitcoin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter(private var filmData:List<FilmData>, private var context:Context):RecyclerView.Adapter<FilmViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int  = filmData.size

    private fun getItem(position: Int): FilmData = filmData[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(inflater.inflate(R.layout.view_holder_movie, parent, false),context)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ActorAdapter(private var ActorData:List<ActorData>, private var context:Context):RecyclerView.Adapter<ActorViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int  = ActorData.size

    private fun getItem(position: Int): ActorData = ActorData[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(inflater.inflate(R.layout.view_holder_details, parent, false),context)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
