package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.UI_logic.MainViewModel
import com.example.myapplication.viewmodel.PlaceViewmodel

@Composable
fun navigation(viewModel: MainViewModel, placeViewmodel: PlaceViewmodel, navController: NavHostController) {


    NavHost(navController = navController, startDestination = Screen.AddPlace.route) {

        composable(route = Screen.DisplayPlaces.route) {
            DisplayPlaces(navController = navController, model = viewModel)

        }

        composable(route = Screen.AddPlace.route) {
            AddPlace(navController, placeViewmodel)

        }

    }
}

