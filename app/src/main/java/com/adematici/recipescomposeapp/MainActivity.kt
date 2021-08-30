package com.adematici.recipescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adematici.recipescomposeapp.ui.theme.RecipesComposeAppTheme
import com.adematici.recipescomposeapp.view.FoodDetailScreen
import com.adematici.recipescomposeapp.view.RecipesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipesComposeAppTheme {
                RecipesScreen()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipesScreenPreview(){
    RecipesComposeAppTheme {
        RecipesScreen()
    }
}

@Composable
@Preview(showBackground = true)
fun FoodDetailScreenPreview(){
    RecipesComposeAppTheme {
        FoodDetailScreen()
    }
}