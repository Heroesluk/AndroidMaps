package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Location
import com.example.myapplication.model.Place


val entry1 =
    Place(
        0,
        "Ato Ramen",
        "I visited ramen, and there an amazing bla bla bla bla bla blakfdjsakdjsa",
        "20-10-2023",
        1,
        Location(1, "Place"),
        R.drawable.ramen
    )
val numbers: MutableList<Place> = mutableListOf(
    Place(
        0,
        "Tower",
        "High tower, High towerHigh towerHigh tower, sadsaldkasdjsak sdajksdsajlkdsajdlksajdlkaj,High tower, High towerHigh towerHigh tower, sadsaldkasdjsak sdajksdsajlkdsajdlksajdlkaj",
        "21-10-2023",
        1,
        Location(0, "Street 10"),
        R.drawable.ramen
    ),
    Place(
        1,
        "Castle",
        "High tower, High towerHigh towerHigh tower, sadsaldkasdjsak sdajksdsajlkdsajdlksajdlkaj,High tower, High towerHigh towerHigh tower, sadsaldkasdjsak sdajksdsajlkdsajdlksajdlkaj",
        "21-11-2023",
        5,
        Location(1, "10,10"),
        R.drawable.ramen
    ),
    Place(
        2,
        "Restaurant",
        "Good food",
        "Plan to visit",
        4,
        Location(2, "Poland"),
        R.drawable.ramen
    ),
    Place(
        3,
        "Lake",
        "Smell bad",
        "Past",
        2,
        Location(3, "France"),
        R.drawable.ramen
    ),

    )

