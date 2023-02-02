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
import android.util.Log

class FragmentMovieList() : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null
    private var filmsOnPage = 4

    companion object{
        fun newInstanse(page:Int): FragmentMovieList{
            val args = Bundle()
            args.putInt("page", page)
            val fragment = FragmentMovieList()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val page = arguments?.getInt("page") ?: 1
        val db = DbHelper(view.context,null)
        val filmNumber = db.filmSize()

        if(filmNumber == 0) {
            val a = Datas().a()
            val f = Datas().f()
            a.forEach {
                db.addActor(it.id, it.name, it.image)
            }
            f.forEach { fi ->
                db.addFilm(
                    fi.id,
                    fi.name,
                    fi.age_limit,
                    fi.tag,
                    fi.image,
                    fi.countReviews,
                    fi.time,
                    fi.hasLike,
                    fi.story
                )
                fi.actorIdList.forEach {
                    db.addRelationship(fi.id, it)
                }
            }
        }

        val list = view.findViewById<RecyclerView>(R.id.FilmList)
        val lastPage = filmNumber/filmsOnPage + 1
        val lastFilmOnPage = if(page == lastPage) filmNumber - 1 else (page-1)*4+3
        var data = listOf<FilmData>()
        for(i in (page-1)*4..lastFilmOnPage)
            data += db.getDataFilmById(i)

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
        if(page == lastPage)
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
        fragmentClickListener = null
    }
}