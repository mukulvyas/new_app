package com.example.travelapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.travelapp.ContentScreen.contentScreen
import com.example.travelapp.MainActivity
import com.example.travelapp.MainScreen.cityScreen

@Composable
fun cityNavigate(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = mainScreen.cityScreen.name){
        composable(mainScreen.cityScreen.name){
            cityScreen(navController = navController)
        }
        composable(
            mainScreen.ContentScreen.name + "/{src}/{dst}",
            arguments = listOf(  navArgument(name = "src") {type = NavType.StringType},
                navArgument(name = "dst") {type = NavType.StringType}
                )
        ) { backStackEntry ->

            val src = backStackEntry.arguments?.getString("src")
            val dst = backStackEntry.arguments?.getString("dst")


            if (src != null) {
                if (dst != null) {
                    contentScreen(navController ,src ,dst)
                }
            }
        }

    }

}

