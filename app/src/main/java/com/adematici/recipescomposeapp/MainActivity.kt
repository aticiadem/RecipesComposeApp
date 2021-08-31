package com.adematici.recipescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.adematici.recipescomposeapp.ui.theme.RecipesComposeAppTheme
import com.adematici.recipescomposeapp.view.FoodDetailScreen
import com.adematici.recipescomposeapp.view.RecipesScreen

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipesComposeAppTheme {
                NavigationScreen()
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun NavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "recipes_screen") {
        composable("recipes_screen") { RecipesScreen(navController) }
        composable(
            "food_detail_screen/{name}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType }
            )
        ) { navStackBackStackEntry ->
            FoodDetailScreen(
                navStackBackStackEntry.arguments?.getString("name")!!
            )
        }
    }

}