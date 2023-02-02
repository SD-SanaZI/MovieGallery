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
    var hasLike:Boolean,
    val story:String,
    val actorIdList:List<Int>
)
data class ActorData(
    val id:Int,
    val name:String,
    val image:Int,
)


class Datas {
    private val filmsOnPage = 4
    private val filmData: List<FilmData> = listOf(
        FilmData(
            0,"Мстители: Война бесконечности", "16+", "фантастика, боевик, приключения",
            R.drawable.avengers_endgame_main, 125, 149, false,
            "Титан Танос вынашивает страшный план — угрозу всей Вселенной. Предпоследний фильм о суперкоманде Marvel",
            listOf(0,1,2,3,4,5,41,57,49)
        ),
        FilmData(
            1,"Железный человек", "12+", "фантастика, боевик, приключения",
            R.drawable.iron_man, 110, 121, true,
            "Попав в плен, Тони Старк изобретает суперкостюм и спасает мир. Блокбастер, запустивший киновселенную Marvel",
            listOf(0,6,7,8,9,10)
        ),
        FilmData(
            2,"Железный человек 2", "12+", "фантастика, боевик, приключения",
            R.drawable.iron_man2, 79, 119, true,
            "Тони Старк противостоит политикам, конкурентам и инженеру из России. Микки Рурк в роли суперзлодея Ивана Ванко",
            listOf(0,11,7,12,4,10)
        ),
        FilmData(
            3,"Тор", "12+", "фантастика, боевик, фэнтези, приключения",
            R.drawable.thor, 23, 110, true,
            "Гордый воин Асгарда адаптируется к земной жизни. Крис Хемсворт в дебютном сольном фильме о супергерое Marvel",
            listOf(3,10,13,14,15,16)
        ),
        FilmData(
            4,"Первый мститель", "12+", "фантастика, боевик, приключения, военный",
            R.drawable.captain_america, 110, 119, true,
            "Щуплому солдату вводят сыворотку, которая дает ему сверхспособности. Начало непростого пути Капитана Америка",
            listOf(1,17,18,19,20,21)
        ),
        FilmData(
            5,"Мстители", "12+", "фантастика, боевик, фэнтези, приключения",
            R.drawable.the_avengers, 110, 137, true,
            "Команда супергероев дает отпор скандинавскому богу Локи. Начало фантастической саги в киновселенной Marvel",
            listOf(0,1,2,3,4,5)
        ),
        FilmData(
            6,"Железный человек 3", "12+", "фантастика, боевик, приключения",
            R.drawable.iron_man2, 110, 125, true,
            "Тони Старк борется с террористами и внутренними демонами. Финал сольной трилогии о миллиардере-супергерое",
            listOf(0,7,12,22,23,9)
        ),
        FilmData(
            7,"Тор 2: Царство тьмы", "12+", "фэнтези, боевик, приключения",
            R.drawable.thor2, 110, 108, true,
            "Бог грома и его хитрый брат объединяются ради спасения вселенной. Приключения героев после событий «Мстителей»",
            listOf(3,13,14,15,24,25)
        ),
        FilmData(
            8,"Первый мститель: Другая война", "12+", "фантастика, боевик, триллер, приключения",
            R.drawable.captain_america2, 110, 136, true,
            "Капитан Америка и Черная вдова против террористов «Гидры». Скарлетт Йоханссон в сиквеле истории Стива Роджерса",
            listOf(1,4,26,20,27,28)
        ),
        FilmData(
            9,"Стражи Галактики", "12+", "фантастика, боевик, приключения, комедия",
            R.drawable.guardians_of_the_galaxy, 110, 121, true,
            "Питер Квилл и горстка неземных лузеров спасают артефакт. Крис Пратт в фильме Джеймса Ганна по комиксу Marvel",
            listOf(29,30,31,32,46,33,34)
        ),
        FilmData(
            10,"Мстители: Эра Альтрона", "12+", "фантастика, боевик, приключения",
            R.drawable.the_avengers2, 110, 141, true,
            "Рассорившиеся супергерои сражаются с искусственным интеллектом. Сиквел, в котором экшен превращается в притчу",
            listOf(0,1,2,3,4,5)
        ),
        FilmData(
            11,"Человек-муравей", "12+", "фантастика, боевик, комедия, приключения",
            R.drawable.ant_man, 110, 117, true,
            "Из добропорядочного вора — в крошечные супергерои. Ироничный взгляд снизу на вселенную Marvel с Полом Раддом",
            listOf(35,36,37,38,39,40)
        ),
        FilmData(
            12,"Первый мститель: Противостояние", "16+", "фантастика, боевик, приключения",
            R.drawable.captain_america3, 110, 142, true,
            "В команде Мстителей раскол из-за спора Капитана Америки и Железного Человека. Зрелищный боевик братьев Руссо",
            listOf(0,1,4,5,20,26,12)
        ),
        FilmData(
            13,"Доктор Стрэндж", "16+", "фантастика, фэнтези, боевик, приключения",
            R.drawable.doctor_strange, 110, 115, true,
            "После автокатастрофы хирург становится верховным защитником Земли. В роли супергероя — Бенедикт Камбербэтч",
            listOf(41,42,43,44,45)
        ),
        FilmData(
            14,"Стражи Галактики. Часть 2", "16+", "фантастика, боевик, приключения, комедия",
            R.drawable.guardians_of_the_galaxy2, 110, 136, true,
            "Звездный Лорд узнает, кто его настоящий отец. Спасение Вселенной, органичный юмор и многочисленные пасхалки",
            listOf(29,30,31,32,46,33,34,47,48)
        ),
        FilmData(
            15,"Человек-паук: Возвращение домой", "16+", "фантастика, боевик, приключения",
            R.drawable.spider_man, 110, 133, true,
            "Homework can wait. The city can't",
            listOf(49,0,50,9,51,52,53)
        ),
        FilmData(
            16,"Тор: Рагнарёк", "16+", "фантастика, фэнтези, боевик, комедия, приключения",
            R.drawable.thor3, 110, 130, true,
            "Сын Одина возвращает свой молот, чтобы остановить гибель мира. Третий фильм о богах Асгарда от Тайки Вайтити",
            listOf(3,14,54,25,55,56,2,15,41)
        ),
        FilmData(
            17,"Чёрная Пантера", "16+", "фантастика, боевик, приключения",
            R.drawable.black_panther, 110, 134, true,
            "Король Ваканды ведет борьбу с угнетателями. Первый блокбастер Marvel с номинацией на «Оскар» за лучший фильм",
            listOf(57,58,59,60,61,62)
        )
    )

    private val actorData: List<ActorData> = listOf(
        ActorData(
            0,"Роберт Дауни Мл.", R.drawable.robert_downey_jr_),
        ActorData(
            1,"Крис Эванс", R.drawable.chrisevans),
        ActorData(
            2,"Марк Руффало", R.drawable.mark_ruffalo),
        ActorData(
            3,"Крис Хэмсворф", R.drawable.chris_hemsworth),
        ActorData(
            4,"Скарлетт Йоханссон", R.drawable.scarlett_johansson),
        ActorData(
            5,"Джереми Реннер", R.drawable.jeremy_renner),
        ActorData(
            6,"Джефф Бриджес", R.drawable.jeff_bridges),
        ActorData(
            7,"Гвинет Пэлтроу", R.drawable.gwyneth_paltrow),
        ActorData(
            8,"Терренс Ховард", R.drawable.terrence_howard),
        ActorData(
            9,"Джон Фавро", R.drawable.jon_favreau),
        ActorData(
            10,"Кларк Грегг", R.drawable.clark_gregg),
        ActorData(
            11,"Микки Рурк", R.drawable.mickey_rourke),
        ActorData(
            12,"Дон Чидл", R.drawable.don_cheadle),
        ActorData(
            13,"Натали Портман", R.drawable.natalie_portman),
        ActorData(
            14,"Том Хиддлстон", R.drawable.tom_hiddleston),
        ActorData(
            15,"Энтони Хопкинс", R.drawable.anthony_hopkins),
        ActorData(
            16,"Стеллан Скарсгард", R.drawable.stellan_skarsgard),
        ActorData(
            17,"Хейли Этвелл", R.drawable.hayley_atwell),
        ActorData(
            18,"Томми Ли Джонс", R.drawable.tommy_lee_jones),
        ActorData(
            19,"Хьюго Уивинг", R.drawable.hugo_weaving),
        ActorData(
            20,"Себастиан Стэн", R.drawable.sebastian_stan),
        ActorData(
            21,"Тоби Джонс", R.drawable.toby_jones),
        ActorData(
            22,"Гай Пирс", R.drawable.guy_pearce),
        ActorData(
            23,"Ребекка Холл", R.drawable.rebecca_hall),
        ActorData(
            24,"Джейми Александер", R.drawable.jaimie_alexander),
        ActorData(
            25,"Идрис Эльба", R.drawable.idris_elba),
        ActorData(
            26,"Энтони Маки", R.drawable.anthony_mackie),
        ActorData(
            27,"Сэмюэл Л. Джексон", R.drawable.samuel_l_jackson),
        ActorData(
            28,"Эмили ВанКэмп", R.drawable.emily_vancamp),
        ActorData(
            29,"Крис Пратт", R.drawable.chris_pratt),
        ActorData(
            30,"Зои Салдана", R.drawable.zoe_saldana),
        ActorData(
            31,"Дэйв Батиста", R.drawable.dave_bautista),
        ActorData(
            32,"Вин Дизель", R.drawable.vin_diesel),
        ActorData(
            33,"Майкл Рукер", R.drawable.michael_rooker),
        ActorData(
            34,"Карен Гиллан", R.drawable.karen_gillan),
        ActorData(
            35,"Пол Радд", R.drawable.paul_rudd),
        ActorData(
            36,"Майкл Дуглас", R.drawable.michael_douglas),
        ActorData(
            37,"Эванджелин Лилли", R.drawable.evangeline_lilly),
        ActorData(
            38,"Майкл Пенья", R.drawable.michael_pena),
        ActorData(
            39,"Кори Столл", R.drawable.corey_stoll),
        ActorData(
            40,"Эбби Райдер Фортсон", R.drawable.abby_ryder_fortson),
        ActorData(
            41,"Бенедикт Камбербэтч", R.drawable.benedict_cumberbatch),
        ActorData(
            42,"Тильда Суинтон", R.drawable.tilda_swinton),
        ActorData(
            43,"Мадс Миккельсен", R.drawable.mads_mikkelsen),
        ActorData(
            44,"Чиветель Эджиофор", R.drawable.chiwetel_ejiofor),
        ActorData(
            45,"Бенедикт Вонг", R.drawable.benedict_wong),
        ActorData(
            46,"Брэдли Купер", R.drawable.bradley_cooper),
        ActorData(
            47,"Пом Клементьефф", R.drawable.pom_klementieff),
        ActorData(
            48,"Курт Рассел", R.drawable.kurt_russell),
        ActorData(
            49,"Том Холланд", R.drawable.tom_holland),
        ActorData(
            50,"Майкл Китон", R.drawable.michael_keaton),
        ActorData(
            51,"Мариса Томей", R.drawable.marisa_tomei),
        ActorData(
            52,"Джейкоб Баталон", R.drawable.jacob_batalon),
        ActorData(
            53,"Зендея", R.drawable.zendaya),
        ActorData(
            54,"Кейт Бланшетт", R.drawable.cate_blanchett),
        ActorData(
            55,"Тесса Томпсон", R.drawable.tessa_thompson),
        ActorData(
            56,"Джефф Голдблюм", R.drawable.jeff_goldblum),
        ActorData(
            57,"Чедвик Боузман", R.drawable.chadwick_boseman),
        ActorData(
            58,"Майкл Б. Джордан", R.drawable.michael_b_jordan),
        ActorData(
            59,"Данай Гурира", R.drawable.danai_gurira),
        ActorData(
            60,"Мартин Фриман", R.drawable.martin_freeman),
        ActorData(
            61,"Летишиа Райт", R.drawable.letitia_wright),
        ActorData(
            62,"Уинстон Дьюк", R.drawable.winston_duke),
    )

    fun a():List<ActorData>{
        return actorData
    }

    fun f():List<FilmData>{
        return filmData
    }
}