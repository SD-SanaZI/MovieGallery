package com.example.testbitcoin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails(val filmId: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        val films = DetailsChanger(view,view.context)// проверить двойное вью
        films.bind(Datas().getDataFilmById(filmId))
        val list = view.findViewById<RecyclerView>(R.id.RecyclerActor)
        val actorIdList = Datas().getDataFilmById(filmId).actorIdList
        val data = Datas().getActorListByIdList(actorIdList)
        val adapter = ActorAdapter(data, view.context)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        return view
    }
}