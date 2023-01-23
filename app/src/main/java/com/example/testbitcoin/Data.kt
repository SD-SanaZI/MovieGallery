package com.example.testbitcoin

import android.util.Log

data class FilmData(
    val id:Int,
    val name:String,
    val age_limit:String,
    val tag:String,
    val image:Int,
    val countReviews:Int,
    val time:Int,
    val hasLike:Boolean,
    val story:String
)
data class ActorData(
    val name:String,
    val image:Int,
)


class Datas {
    val filmsOnPage = 4
    val filmData: List<FilmData> = listOf(
        FilmData(
            0,"Avengers: End Game", "13+", "Action, Adventure, Fantasy",
            R.drawable.avengers_endgame_main, 125, 137, false,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
        ),
        FilmData(
            1,"Avengers: End Game", "14+", "Action, Adventure, Fantasy",
            R.drawable.avengers_endgame_main, 110, 90, true,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
        ),
        FilmData(
            2,"Avengers: End Game", "15+", "Action, Adventure, Fantasy",
            R.drawable.avengers_endgame_main, 110, 90, true,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
        ),
        FilmData(
            3,"Avengers: End Game", "16+", "Action, Adventure, Fantasy",
            R.drawable.avengers_endgame_main, 110, 90, true,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
        ),
        FilmData(
            4,"Avengers: End Game", "17+", "Action, Adventure, Fantasy",
            R.drawable.avengers_endgame_main, 110, 90, true,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
        )
    )

    fun getDataFilmById(id: Int): FilmData{
        if(id in 0..filmData.size)
            return filmData[id]
        Log.wtf("getDataFilmById", "id not in range")
        return filmData[0]
    }

    fun getDataFilmPage(page: Int): List<FilmData>{
        //проверка на попадание в ренж
        if(page in 1..filmData.size/filmsOnPage + 1) //проверка на последнюю(короткую) страницу
            if(page * filmsOnPage > filmData.size)
                return filmData.subList((page-1)*4,filmData.size)
            return filmData.subList((page-1)*4,(page-1)*4+4)
        Log.wtf("getDataFilmById", "page not in range")
        return listOf(filmData[0])
    }

    fun getLastPageNumber(): Int{
        return filmData.size/filmsOnPage + 1
    }

    fun getDataFilm(): List<FilmData> {
        return filmData
    }

    fun getDataActor(): List<ActorData> {
        return listOf(
            ActorData(
                "Robert Downey Jr.", R.drawable.robert_downey_jr_),
            ActorData(
                "Chris Evans", R.drawable.chrisevans),
            ActorData(
                "Mark Ruffalo", R.drawable.mark_ruffalo),
            ActorData(
                "Chris Hemsworth", R.drawable.chris_hemsworth),
        )
    }
}