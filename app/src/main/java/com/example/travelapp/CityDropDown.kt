package com.example.travelapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CityDropDown(selectionCity: (String) -> Unit) {
    var sourceDropDown by remember { mutableStateOf(false) }
    var destinationDropDown by remember { mutableStateOf(false) }
    var indexSource by remember { mutableIntStateOf(0) }
    var indexDestination by remember { mutableIntStateOf(0) }
    var newIndex by remember { mutableStateOf(0) }
    val citySource = listOf(
        "SELECT CITY",
        "MAJLIS PARK",
        "AZADPUR",
        "SHALIMAR BAGH",
        "NETAJI SUBHASH PLACE",
        "SHAKURPUR",
        "PUNJABI BAGH WEST",
        "ESI-BASAIDARPUR",
        "RAJOURI GARDEN",
        "MAYAPURI",
        "NARAINA VIHAR",
        "DELHI CANTT.",
        "DURGABAI DESHMUKH SOUTH CAMPUS",
        "SIR M. VISHWESHWARAIAH MOTI BAGH",
        "BHIKAJI CAMA PLACE",
        "SAROJINI NAGAR",
        "DILLI HAAT - INA",
        "SOUTH EXTENSION",
        "LAJPAT NAGAR",
        "VINOBAPURI",
        "ASHRAM",
        "SARAI KALE KHAN - NIZAMUDDIN",
        "MAYUR VIHAR - 1"
    )
    val cityDestination = listOf(
        "DESTINATION",
        "MAJLIS PARK",
        "AZADPUR",
        "SHALIMAR BAGH",
        "NETAJI SUBHASH PLACE",
        "SHAKURPUR",
        "PUNJABI BAGH WEST",
        "ESI-BASAIDARPUR",
        "RAJOURI GARDEN",
        "MAYAPURI",
        "NARAINA VIHAR",
        "DELHI CANTT.",
        "DURGABAI DESHMUKH SOUTH CAMPUS",
        "SIR M. VISHWESHWARAIAH MOTI BAGH",
        "BHIKAJI CAMA PLACE",
        "SAROJINI NAGAR",
        "DILLI HAAT - INA",
        "SOUTH EXTENSION",
        "LAJPAT NAGAR",
        "VINOBAPURI",
        "ASHRAM",
        "SARAI KALE KHAN - NIZAMUDDIN",
        "MAYUR VIHAR - 1"
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Implementation of source city
        Card(
            modifier = Modifier.padding(15.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp)
                    .clickable {
                        sourceDropDown = true
                    }
            ) {
                Text(
                    text = citySource[indexSource],
                    //style = MaterialTheme.typography.body1
                )

            }
            DropdownMenu(expanded = sourceDropDown, onDismissRequest = { sourceDropDown = false },
                modifier = Modifier.requiredSizeIn(maxHeight = 200.dp)) {
                citySource.forEachIndexed { index,city ->
                    DropdownMenuItem(
                        text = { Text(text = city )},
                        onClick = {
                            sourceDropDown = false
                            indexSource = index
                            newIndex = 0
                            selectionCity(
                                citySource[indexSource]
                                //cityDestination[indexSource]
                            )

                        }
                    )
                }
            }
        }


//        Card(
//            modifier = Modifier.padding(15.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .padding(5.dp)
//                    .clickable {
//                        destinationDropDown = true
//                    }
//            ) {
//                Text(
//                    text = cityDestination[indexDestination],
//                    //style = MaterialTheme.typography.body1
//                )
//
//            }
//            DropdownMenu(expanded = destinationDropDown, onDismissRequest = { destinationDropDown = false },
//                modifier = Modifier.requiredSizeIn(maxHeight = 200.dp)) {
//                citySource.forEachIndexed { index,city ->
//                    DropdownMenuItem(
//                        text = {},
//                        onClick = {
//                            destinationDropDown = false
//                            indexDestination = index
//                            newIndex = 0
//                            selectionCity(
//                                citySource[indexSource],
//                                cityDestination[indexDestination]
//                            )
//
//                        }
//                    )
//                }
//            }
//        }

    }
}
