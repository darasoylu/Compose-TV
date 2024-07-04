package com.darasoylu.newtvui.model

sealed class Contents {

    data class Movie(
        val name: String,
        val image: String
    ): Contents()

    data class Series(
        val title: String,
        val image: String
    ) : Contents()

    data class Live(
        val label: String,
        val image: String
    ) : Contents()

    data class Carousel(
        val label: String,
        val image: String
    ) : Contents()

}

val liveList = listOf(
    Contents.Live("S Sport", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/s-sport-tr.png"),
    Contents.Live("Kanal D", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/kanal-d-tr.png"),
    Contents.Live("Now", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/now-tr.png"),
    Contents.Live("Star", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/star-tv-tr.png"),
    Contents.Live("Show", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/show-tr.png"),
    Contents.Live("Atv", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/atv-tr.png"),
    Contents.Live("Cnn Turk", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/cnn-turk-tr.png"),
    Contents.Live("Bein Sports Haber", "https://raw.githubusercontent.com/tv-logo/tv-logos/main/countries/turkey/bein-sports-haber-tr.png"),
)

val carouselList = listOf(
    Contents.Carousel("Stranger Things", "https://image.tmdb.org/t/p/original/2MaumbgBlW1NoPo3ZJO38A6v7OS.jpg"),
    Contents.Carousel("Dune: Part Two", "https://image.tmdb.org/t/p/original/xOMo8BRK7PfcJv9JCnx7s5hj0PX.jpg"),
    Contents.Carousel("The Garfield Movie", "https://image.tmdb.org/t/p/original/2mtxXjkQOLYPOhTKoCaWVVjKlfW.jpg"),
    Contents.Carousel("How I Met Your Mother", "https://image.tmdb.org/t/p/original/mIrYAz0s8PMVPPcXaz6pKoopfrT.jpg"),
    Contents.Carousel("The Office", "https://image.tmdb.org/t/p/original/mLyW3UTgi2lsMdtueYODcfAB9Ku.jpg"),
)

val recommendedMovieList = listOf(
    Contents.Movie("Inside Out 2", "https://image.tmdb.org/t/p/original/xg27NrXi7VXCGUr7MG75UqLl6Vg.jpg"),
    Contents.Movie("Furiosa: A Mad Max Saga", "https://image.tmdb.org/t/p/original/wNAhuOZ3Zf84jCIlrcI6JhgmY5q.jpg"),
    Contents.Movie("Despicable Me 4", "https://image.tmdb.org/t/p/original/fDmci71SMkfZM8RnCuXJVDPaSdE.jpg"),
    Contents.Movie("Kung Fu Panda 4", "https://image.tmdb.org/t/p/original/1XDDXPXGiI8id7MrUxK36ke7gkX.jpg"),
    Contents.Movie("IF", "https://image.tmdb.org/t/p/original/nxxCPRGTzxUH8SFMrIsvMmdxHti.jpg"),
    Contents.Movie("The Watchers", "https://image.tmdb.org/t/p/original/whnFKx0Y54Ktg6o2TiwbnQfXdZf.jpg")
)

val topMovieList = listOf(
    Contents.Movie("The Shawshank Redemption", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"),
    Contents.Movie("The Godfather", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3bhkrj58Vtu7enYsRolD1fZdja1.jpg"),
    Contents.Movie("Spirited Away", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/39wmItIWsg5sZMyRUHLkWBcuVCM.jpg"),
    Contents.Movie("The Dark Knight", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qJ2tW6WMUDux911r6m7haRef0WH.jpg"),
    Contents.Movie("Parasite", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg"),
    Contents.Movie("Pulp Fiction", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg"),
    Contents.Movie("The Lord of the Rings: The Return of the King", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg"),
    Contents.Movie("Forrest Gump", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg"),
    Contents.Movie("The Good, the Bad and the Ugly", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bX2xnavhMYjWDoZp1VM6VnU1xwe.jpg"),
    Contents.Movie("Fight Club", "https://image.tmdb.org/t/p/w600_and_h900_bestv2/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg")
)

val recommendedSeriesList = listOf(
    Contents.Series("The Boys", "https://image.tmdb.org/t/p/original/7cqKGQMnNabzOpi7qaIgZvQ7NGV.jpg"),
    Contents.Series("House of the Dragon", "https://image.tmdb.org/t/p/original/8jjTPo8j2dG6eDBYZOxgEpzSGAB.jpg"),
    Contents.Series("Vikings: Valhalla", "https://image.tmdb.org/t/p/original/xjD0FJijUAM6q8WTvX0jGyO9DxW.jpg"),
    Contents.Series("Suits", "https://image.tmdb.org/t/p/original/edsotmSdhkWZazcljC1K2Lrkg5Y.jpg")
)

