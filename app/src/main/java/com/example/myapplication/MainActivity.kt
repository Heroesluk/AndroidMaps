package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.numbers
import com.example.myapplication.model.Entry

private val defaultSpacerSize = 16.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayPlace()
        }
    }
}

@Composable
fun generateEntry(entry: Entry) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(text = entry.name, fontSize = 18.sp)
            Text(
                text = entry.place.coordinates,
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            Text(text = entry.description, fontSize = 8.sp)
//            Text(text = entry.date)
//            Text(text = entry.score.toString())
        }
        Image(
            painter = painterResource(entry.imageId),
            contentDescription = "Image"
        )

    }

}


@Preview(showBackground = true)
@Composable
fun DisplayPlace() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AddPlace()
    }

}

@Composable
fun DisplayPlaces(){
    Column {
        numbers.forEach { entry ->
            generateEntry(entry)
        }
    }

}