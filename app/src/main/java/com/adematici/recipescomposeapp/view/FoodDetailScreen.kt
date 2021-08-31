package com.adematici.recipescomposeapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.adematici.recipescomposeapp.model.FoodModel
import com.adematici.recipescomposeapp.viewmodel.FoodViewModel

@Composable
fun FoodDetailScreen(
    navController: NavController,
    name: String
) {
    var model: FoodModel
    val viewModel: FoodViewModel = viewModel()
    val recipes = viewModel.recipesState.value
    LazyColumn {
        items(recipes) { recipe ->
            if (recipe.foodName == name) {
                model = recipe
                Column {
                    Text(text = model.foodCook)
                }
            }
        }
    }
}