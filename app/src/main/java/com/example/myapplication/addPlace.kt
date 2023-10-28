package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


fun getScoreList(): List<Int> {
    return listOf(1, 2, 3, 4, 5)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlace() {

    var placeName by rememberSaveable { mutableStateOf("") }
    var placeDescription by rememberSaveable { mutableStateOf("") }
    var placeLocation by rememberSaveable { mutableStateOf("") }
    var placeScore by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = stringResource(id = R.string.add_place),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = stringResource(id = R.string.place_name),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.padding(2.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = placeName,
            onValueChange = { placeName = it },
            placeholder = { Text(text = "e.g. Eiffel Tower") },
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = stringResource(id = R.string.place_description),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.padding(2.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = placeDescription,
            onValueChange = { placeDescription = it },
            placeholder = { Text(text = "e.g. The smell under tower was really bad, and i got robbed") },
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = stringResource(id = R.string.place_location),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = placeLocation,
            onValueChange = { placeLocation = it },
            placeholder = { Text(text = "e.g. Champ de Mars, 5 Av. Anatole Franc") },
        )

        Spacer(modifier = Modifier.padding(8.dp))


        Text(
            text = stringResource(id = R.string.place_score),
            style = MaterialTheme.typography.bodyLarge
        )

        // TD: change it to enum hover stars / smh
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = placeScore,
            onValueChange = { placeScore = it },
            placeholder = { Text(text = "Range 1-5") },
        )

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = stringResource(id = R.string.place_visit_date),
            style = MaterialTheme.typography.bodyLarge
        )

        Demo_ExposedDropdownMenuBox()


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox() {
    val context = LocalContext.current
    val options = arrayOf(" - ", "Seen", "Plan to see")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(options[0]) }


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedText = item
                        expanded = false
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }

}




