package com.example.testbitcoin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails() : Fragment() {
    companion object{
        fun newInstanse(filmId: Int): FragmentMoviesDetails{
            val args = Bundle()
            args.putInt("filmId", filmId)
            val fragment = FragmentMoviesDetails()
            fragment.arguments = args

            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)

        val filmId = arguments?.getInt("filmId") ?: 0
        val viewChanger = DetailsChanger(view)
        val db = DbHelper(view.context, null)

        val filmData = db.getDataFilmById(filmId)
        viewChanger.bind(filmData)

        val list = view.findViewById<RecyclerView>(R.id.RecyclerActor)
        val actorIdList = filmData.actorIdList
        var data = listOf<ActorData>()
        actorIdList.forEach {
            data += db.getActorById(it)
        }
        val adapter = ActorAdapter(data, view.context)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)

        return view
    }
}