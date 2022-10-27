package com.example.testbitcoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        val list = view.findViewById<RecyclerView>(R.id.RecyclerActor)
        val data = Datas().getDataActor()
        val adapter = ActorAdapter(data, view.context)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        return view
    }
}