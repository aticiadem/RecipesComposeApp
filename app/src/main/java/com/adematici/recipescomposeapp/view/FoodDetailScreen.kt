package com.adematici.recipescomposeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.adematici.recipescomposeapp.R
import com.adematici.recipescomposeapp.model.FoodModel
import com.adematici.recipescomposeapp.viewmodel.FoodViewModel

@ExperimentalCoilApi
@Composable
fun FoodDetailScreen(
    name: String
) {
    Scaffold(
        topBar = { AppBarTop(name) }
    ) {
        Surface {
            var model: FoodModel
            val viewModel: FoodViewModel = viewModel()
            val recipes = viewModel.recipesState.value
            LazyColumn {
                items(recipes) { recipe ->
                    if (recipe.foodName == name) {
                        model = recipe
                        DetailScreen(model)
                    }
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun DetailScreen(model: FoodModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        FoodImage(imageUrl = model.foodImage)
        Spacer(modifier = Modifier.height(20.dp))
        FoodText(
            text = "Malzemeler",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(start = 12.dp, bottom = 4.dp)
        )
        FoodText(
            text = model.foodIngredient,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        FoodText(
            text = "Yapılışı",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(start = 12.dp, bottom = 4.dp)
        )
        FoodText(
            text = model.foodCook,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
        )
    }
}

@ExperimentalCoilApi
@Composable
fun FoodImage(imageUrl: String) {
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
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(265.dp, 500.dp)
    )
    if (painterState is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
}

@Composable
fun FoodText(
    text: String,
    fontSize: TextUnit,
    fontStyle: FontStyle = FontStyle.Normal,
    modifier: Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontStyle = fontStyle,
        modifier = modifier
    )
}