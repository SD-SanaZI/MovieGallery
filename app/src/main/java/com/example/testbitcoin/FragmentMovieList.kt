package com.example.testbitcoin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMovieList(val page:Int) : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        val list = view.findViewById<RecyclerView>(R.id.FilmList)
        val data = Datas().getDataFilmPage(page)
        val adapter = FilmAdapter(data, view.context)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(view.context)

        val previousPage = view.findViewById<ImageView>(R.id.PreviousPage)
        val nextPage = view.findViewById<ImageView>(R.id.NextPage)
        view.findViewById<TextView>(R.id.CurrentPageView).text = page.toString()
        previousPage.setOnClickListener {
            fragmentClickListener?.openFilmsListPage(page-1)
        }
        nextPage.setOnClickListener {
            fragmentClickListener?.openFilmsListPage(page+1)
        }
        if(page == 1)
            previousPage.setVisibility(View.INVISIBLE)
        if(page == Datas().getLastPageNumber())
            nextPage.setVisibility(View.INVISIBLE)

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