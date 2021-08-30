package com.adematici.recipescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adematici.recipescomposeapp.ui.theme.RecipesComposeAppTheme
import com.adematici.recipescomposeapp.view.FoodDetailScreen
import com.adematici.recipescomposeapp.view.RecipesScreen

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

@Composable
fun NavigationScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "recipes_screen") {
        composable("recipes_screen") { RecipesScreen(navController) }
        composable("food_detail_screen") { FoodDetailScreen() }
    }

}