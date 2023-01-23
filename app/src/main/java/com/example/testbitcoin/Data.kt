package com.example.testbitcoin

data class FilmData(
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
    fun getDataFilm(): List<FilmData> {
        return listOf(
            FilmData(
                "Avengers: End Game", "13+", "Action, Adventure, Fantasy",
                R.drawable.avengers_endgame_main, 125, 137, false,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
            ),
            FilmData(
                "Avengers: End Game", "16+", "Action, Adventure, Fantasy",
                R.drawable.avengers_endgame_main, 110, 90, true,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos actions and restore balance to the universe."
            )
        )
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