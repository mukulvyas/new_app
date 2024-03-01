package com.example.travelapp.MainScreen


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelapp.CityDropDown
import com.example.travelapp.R
import com.example.travelapp.navigation.mainScreen

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun cityScreen(navController: NavController){

    var selectSource by remember { mutableStateOf("") }
    var selectDestination by remember { mutableStateOf("") }
    val sourceStore = remember { mutableStateOf("") }
    val destinationStore = remember { mutableStateOf("") }
    val scrollingState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row(horizontalArrangement = Arrangement.Start) {

                    Spacer(modifier = Modifier.width(50.dp))
                    Text(text = "Travel Calculator App",
                        textAlign = TextAlign.Center)
                }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray),

            )
        }
    ) { innerPadding ->
        Box {

            Spacer(modifier = Modifier
                .matchParentSize()
                .background(Color.Gray)
            )

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(scrollingState),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )

            {
                // Heading

                ContentMain(navController = navController)


            }

        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun ContentMain(navController: NavController){

    var selectSource by remember { mutableStateOf("") }
    var selectDestination by remember { mutableStateOf("") }
    val sourceStore = remember { mutableStateOf("") }
    val destinationStore = remember { mutableStateOf("") }
    val scrollingState = rememberScrollState()
    val context = LocalContext.current
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {

            Text(
                text = "Welcome to Distance Calculator",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )



                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                    ,
                    shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {

                    CityDropDown { source ->
                        selectSource = source
                    }

                    CityDropDown { destination ->
                        selectDestination = destination
                    }

                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = {

                            Log.d(
                                "TAG",
                                "sourceStore: ${selectSource}, destinationStore: ${selectDestination}"
                            )
                            if (selectSource == selectDestination) {
                                Log.d("TAG", "Hello")
                                Toast.makeText(
                                    context,
                                    "Please try again. Source and destination are the same.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                sourceStore.value = selectSource
                                destinationStore.value = selectDestination
                                navController.navigate(route = mainScreen.ContentScreen.name + "/$selectSource/$selectDestination")
                            }
                        },
                        modifier = Modifier
                            .size(150.dp, 50.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Submit")
                    }


                    Spacer(modifier = Modifier.size(50.dp))


//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    OutlinedTextField(
//                        value = sourceStore.value,
//                        onValueChange = {  },
//                        label = { Text("Source") },
//                        readOnly = true
//                    )
//
//                    OutlinedTextField(
//                        value = destinationStore.value,
//                        onValueChange = {  },
//                        label = { Text("Destination") },
//                        readOnly = true
//                    )
//                }
                }

        }
    }

