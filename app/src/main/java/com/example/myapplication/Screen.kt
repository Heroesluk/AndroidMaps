package com.example.myapplication

sealed class Screen(val route: String){
    object MainScreen: Screen("mainScreen")
    object DetailScreen: Screen("detailScreen")

}
