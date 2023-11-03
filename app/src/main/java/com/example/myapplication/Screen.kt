package com.example.myapplication

sealed class Screen(val route: String){
    object MainScreen: Screen("mainScreen")
    object DetailScreen: Screen("detailScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
