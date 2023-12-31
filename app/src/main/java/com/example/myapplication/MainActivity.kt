package com.example.myapplication

//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.UI_logic.PlaceEvent
import com.example.myapplication.UI_logic.MainViewModel
import com.example.myapplication.data.MockRepository
import com.example.myapplication.data.numbers
import com.example.myapplication.model.Place

private val defaultSpacerSize = 16.dp


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        println("tak")


        super.onCreate(savedInstanceState)

        setContent {
//            mainDisplay()
            val navController = rememberNavController()
            viewModel.setNav(navController)
            navigation(viewModel, navController)
//            DisplayPlaces()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun generateEntry(entry: Place, model: MainViewModel, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    //this feels like affects performance hard so i'll leave it for now
//    var dict = mapOf(true to 200.dp, false to 100.dp)


    Row(
        modifier = Modifier
            .clickable {
                expanded = !expanded;
            }
            .fillMaxWidth()
//            .height(dict.get(expanded)!!)
    ) {
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
            if (expanded) {
                Text(
                    text = entry.description,
                    fontSize = 8.sp,
                    modifier = Modifier.fillMaxWidth(0.4f)
                )
            }
//            Text(text = entry.date)
//            Text(text = entry.score.toString())
        }
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(entry.imageId),
            contentDescription = "Image",
            modifier = Modifier.size(80.dp)
        )


    }

    if (expanded) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(56.dp)
                    .fillMaxWidth(0.5f),
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
                    .padding(vertical = 16.dp)
                    .height(56.dp)
                    .fillMaxWidth(0.5f),
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


}

@Composable
fun DisplayPlaces(navController: NavController, model: MainViewModel) {

    val state = model.state


    Column(modifier = Modifier.fillMaxWidth()) {
        state.value.places.forEach { place ->
            generateEntry(place, model, navController)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .height(56.dp)
                .fillMaxWidth(0.2f),
            onClick = { navController.navigate(Screen.AddPlace.route) },
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Text(
                text = stringResource(id = R.string.add_new_place),
                style = MaterialTheme.typography.bodyLarge
            )
        }


    }

}


