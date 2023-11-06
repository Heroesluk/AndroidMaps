package com.example.myapplication

//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.UI_logic.PlaceEvent
import com.example.myapplication.UI_logic.MainViewModel
import com.example.myapplication.data.MockRepository
import com.example.myapplication.data.numbers
import com.example.myapplication.model.Place

private val defaultSpacerSize = 16.dp


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    var dataRepository: MockRepository = MockRepository(numbers)


    override fun onCreate(savedInstanceState: Bundle?) {
        println("tak")


        super.onCreate(savedInstanceState)

        setContent {
//            mainDisplay()
            navigation(viewModel)
//            DisplayPlaces()
        }
    }
}


//@Composable
//fun mainDisplay() {
//    var navController = rememberNavController()
//    var modifier = Modifier
//    var startDestination: String = "place"
//
//
//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable("place") {
//            AddPlace(
//                onNavigateToHome = { navController.navigate("home") },
//                )
//        }
//        composable("home") {
//            DisplayPlaces()
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun generateEntry(entry: Place) {

    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(
                text = entry.name, fontSize = 18.sp,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = entry.location.coordinates,
                fontSize = 10.sp,
                style = MaterialTheme.typography.bodyLarge,
                textDecoration = TextDecoration.Underline
            )
            Text(text = entry.description, fontSize = 8.sp)
//            Text(text = entry.date)
//            Text(text = entry.score.toString())
        }
        Image(
            painter = painterResource(entry.imageId),
            contentDescription = "Image",
            modifier = Modifier.size(150.dp)
        )

    }

}

@Composable
fun DisplayPlaces(navController: NavController, model: MainViewModel) {

    val state = model.state


    Column {
        state.value.places.forEach { place ->
            generateEntry(place)
        }

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(56.dp),
            onClick = { navController.navigate(Screen.AddPlace.route) },
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = stringResource(id = R.string.add_new_place),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(56.dp),
            onClick = { model.onEvent(PlaceEvent.RemovePlacePlaceEvent) },
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = stringResource(id = R.string.remove_place),
                style = MaterialTheme.typography.bodyLarge
            )
        }


    }

}


