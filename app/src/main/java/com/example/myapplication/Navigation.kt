package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DisplayPlaces.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)


        }

        composable(route = Screen.DisplayPlaces.route) {
            DisplayPlaces(navController)

        }

        composable(route = Screen.AddPlace.route) {
            AddPlace(navController)

        }

//        composable(route = Screen.DetailScreen.route + "/{name}",
//            arguments = listOf(
//            navArgument("name") {
//                type = NavType.StringType
//                defaultValue = "Male"
//                nullable = true
//            }
//        )) { entry ->
//            DetailScreen(name = entry.arguments?.getString("name"))
//        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")

    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            })

        Spacer(modifier = Modifier.height(8.dp))

    }

    Button(
        onClick = {
            navController.navigate(Screen.DisplayPlaces.route)

        }
    ) {
        Text(text = "clickMe")
    }
}


@Composable
fun DetailScreen(name: String?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "hello, $name")
    }


}