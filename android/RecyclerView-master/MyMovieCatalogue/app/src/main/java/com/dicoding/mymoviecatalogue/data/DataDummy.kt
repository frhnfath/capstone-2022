package com.dicoding.mymoviecatalogue.data

import com.dicoding.mymoviecatalogue.R

object DataDummy {
    fun getSeries(): ArrayList<MovieEntity> {
        return arrayListOf(
            MovieEntity(
                "ser1",
                "Lovestruck in the City",
                "A passionate architect loses his heart to a free-spirited woman and sets out to reunite with her on the streets of Seoul.",
                "40m",
                "Romance",
                R.drawable.litc
            ),
            MovieEntity(
                "ser2",
                "Attack on Titan",
                "When man-eating Titans first appeared 100 years ago, humans found safety behind massive walls that stopped the giants in their tracks.",
                "25m",
                "Anime",
                R.drawable.aot
            ),
            MovieEntity(
                "ser3",
                "Breaking Bad",
                "Walter White, a chemistry teacher, discovers that he has cancer and decides to get into the meth-making business to repay his medical debts.",
                "60m",
                "Crime",
                R.drawable.breaking_bad
            ),
            MovieEntity(
                "ser4",
                "Friends",
                "Follow the lives of six reckless adults living in Manhattan, as they indulge in adventures which make their lives both troublesome and happening.",
                "22m",
                "Comedy",
                R.drawable.friends
            ),
            MovieEntity(
                "ser5",
                "Hundred",
                "A nuclear conflict has decimated civilisation. A century later, a spaceship accommodating humanity's lone survivors dispatch 100 juvenile delinquents back to the Earth to determine its habitability.",
                "42m",
                "Sci-fi",
                R.drawable.hundred
            ),
            MovieEntity(
                "ser6",
                "13 Reasons Why",
                "Newcomer Katherine Langford plays the role of Hannah, a young woman who takes her own life.",
                "52m",
                "Drama",
                R.drawable.reasonswhy
            ),
            MovieEntity(
                "ser7",
                "Sherlock",
                "Dr Watson, a former army doctor, finds himself sharing a flat with Sherlock Holmes, an eccentric individual with a knack for solving crimes.",
                "1h 30m",
                "Mystery",
                R.drawable.sherlock
            ),
            MovieEntity(
                "ser8",
                "Stranger Things",
                "In 1980s Indiana, a group of young friends witness supernatural forces and secret government exploits.",
                "50m",
                "Sci-fi",
                R.drawable.stranger_things
            ),
            MovieEntity(
                "ser9",
                "The Walking Dead",
                "In the wake of a zombie apocalypse, various survivors struggle to stay alive.",
                "1h 7m",
                "Horror",
                R.drawable.walking_dead
            ),
            MovieEntity(
                "ser10",
                "The X-Files",
                "Conspiracy theorist Fox Mulder and realist Dana Scully pull out all the stops as FBI special agents to investigate and get to the bottom of inexplicable paranormal cases.",
                "45m",
                "Sci-fi",
                R.drawable.xfiles
            )
        )
    }

    fun getMovies(): ArrayList<MovieEntity> {
        return arrayListOf(
            MovieEntity(
                "mov1",
                "Avengers Endgame",
                "Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers.",
                "3h 2m",
                "Action",
                R.drawable.avengers_endgame
            ),
            MovieEntity(
                "mov2",
                "Avengers: Infinity War",
                "Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos.",
                "2h 40m",
                "Action",
                R.drawable.avengers_iw
            ),
            MovieEntity(
                "mov3",
                "Black Widow",
                "At birth the Black Widow (aka Natasha Romanova) is given to the KGB, which grooms her to become its ultimate operative.",
                "2h 14m",
                "Action",
                R.drawable.black_widow
            ),
            MovieEntity(
                "mov4",
                "Fast and Furious 9",
                "Dom Toretto is living the quiet life off the grid with Letty and his son, but they know that danger always lurks just over the peaceful horizon.",
                "2h 25m",
                "Action",
                R.drawable.ff9
            ),
            MovieEntity(
                "mov5",
                "Ford Vs Ferrari",
                "Carroll Shelby, an automotive designer, and Ken Miles, a race car driver, join hands to build a trailblazing vehicle and compete against the Ferrari race cars.",
                "2h 32m",
                "Drama",
                R.drawable.ford_ferrari
            ),
            MovieEntity(
                "mov6",
                "Inception",
                "Cobb steals information from his targets by entering their dreams. ",
                "2h 42m",
                "Sci-fi",
                R.drawable.inception
            ),
            MovieEntity(
                "mov7",
                "Independence Day",
                "An alien race destroys major cities of the world with their advanced weaponry.",
                "2h 34m",
                "Sci-fi",
                R.drawable.independence_day
            ),
            MovieEntity(
                "mov8",
                "James Bond: No Time To Die",
                "Recruited to rescue a kidnapped scientist, globe-trotting spy James Bond finds himself hot on the trail of a mysterious villain.",
                "2h 43m",
                "Action",
                R.drawable.jb_notimetodie
            ),
            MovieEntity(
                "mov9",
                "Joker",
                "Arthur Fleck, a party clown, leads an impoverished life with his ailing mother. However, when society shuns him and brands him as a freak",
                "2h 2m",
                "Action",
                R.drawable.joker
            ),
            MovieEntity(
                "mov10",
                "Minions",
                "Minions Kevin, Stuart and Bob decide to find a new master. They embark on a global trip and meet Scarlett Overkill.",
                "1h 31m",
                "Family",
                R.drawable.minions
            )
        )
    }
}