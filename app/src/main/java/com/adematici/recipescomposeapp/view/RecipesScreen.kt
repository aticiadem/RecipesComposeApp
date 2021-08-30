package com.adematici.recipescomposeapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.adematici.recipescomposeapp.R
import com.adematici.recipescomposeapp.ui.theme.LightGray200
import com.adematici.recipescomposeapp.viewmodel.FoodViewModel

@ExperimentalCoilApi
@Composable
fun RecipesScreen(/*navController: NavController*/) {
    val viewModel: FoodViewModel = viewModel()
    val recipes = viewModel.recipesState.value
    Scaffold(
        topBar = { AppBarTop("Recipes") }
    ) {
        Surface {
            LazyColumn{
                items(recipes){ recipe ->
                    RecipeCard(imageUrl = recipe.foodImage!!, foodName = recipe.foodName!!)
                }
            }
        }
    }
}

@Composable
fun AppBarTop(title: String) {
    TopAppBar(
        contentPadding = PaddingValues(start = 20.dp),
        backgroundColor = Color.DarkGray
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            color = Color.White
        )
    }
}

@ExperimentalCoilApi
@Composable
fun RecipeCard(imageUrl: String, foodName: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(140.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = LightGray200,
        border = BorderStroke(2.dp, Color.Gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp)
        ) {
            CoilImage(imageUrl)
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = foodName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                fontSize = 18.sp
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CoilImage(imageUrl: String) {
    val painter = rememberImagePainter(
        data = imageUrl,
        builder = {
            error(R.drawable.ic_error)
        }
    )
    val painterState = painter.state
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(128.dp),
    )
    if (painterState is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
}

@ExperimentalCoilApi
@Composable
@Preview(showBackground = true)
fun RecipesScreenPreview() {
    RecipesScreen()
}