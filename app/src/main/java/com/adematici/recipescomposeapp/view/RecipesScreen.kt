package com.adematici.recipescomposeapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun RecipesScreen(navController: NavController){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {
        Button(onClick = {
            navController.navigate("food_detail_screen")
        }) {
            Text(text = "Adem Atici")
        }
    }
}