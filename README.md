# G.L.E.A. (Gotta *List* 'Em All)


GLEA is a demo Pokedex application which lists (😏) and shows Pokemon details, such as type and stats, whenever the user selects one. The app has been designed using **Clean Architecture** and **MVI**.

GLEA uses the [PokeAPI](https://pokeapi.co/) for retrieving pokemon details that are updated in the database, allowing offline use once the database has been populated

<p align="center">
<img src="/screengrabs/glea.gif" align="left" width="250"/>
<img src="/screengrabs/list.jpg" align="center" width="250"/>
<img src="/screengrabs/detail_low.jpg" align="right" width="250"/>
</p>

<p align="center">
<img src="/screengrabs/detail_expanded_fire.jpg" align="center" width="250"/>
<img src="/screengrabs/detail_expanded.jpg" align="center" width="250"/>
</p>

# Next steps
- [ ] Filtered list by type
- [ ] Advanced search by name and range of stats
- [ ] Save single pokemon or category in a User Preferences app section


# Tech details
- Minimum SDK level 21
- MVI Architecture 
- Repository pattern
- [Kotlin](https://kotlinlang.org/), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) to collect data.
- Koin for dependency injection.
- JetPack
  - [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) with Remote Mediator to implement paging via layered (network + db)       source
  - [ViewModel] (https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Room] (https://developer.android.com/training/data-storage/room) - database
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - to build the REST APIs and load data from network.
- [Moshi](https://github.com/square/moshi/) - JSON parsing library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide)
- [Material-Components](https://github.com/material-components/material-components-android) - to implement BottomSheet for Pokemon detail section
