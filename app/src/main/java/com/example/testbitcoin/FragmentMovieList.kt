package com.example.testbitcoin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMovieList : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val list = view.findViewById<RecyclerView>(R.id.FilmList)
        val data = Datas().getDataFilm()
        val adapter = FilmAdapter(data, view.context)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(view.context)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentClickListener)
            fragmentClickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClickListener = null;
    }
}