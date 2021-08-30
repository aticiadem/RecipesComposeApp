package com.adematici.recipescomposeapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.adematici.recipescomposeapp.model.FoodModel
import com.adematici.recipescomposeapp.repository.FoodRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FoodViewModel(private val repository: FoodRepository = FoodRepository()) : ViewModel() {

    private val recipesJob = Job()

    init {
        val scope = CoroutineScope(recipesJob + Dispatchers.IO)
        scope.launch {
            val recipes = getRecipes()
            recipesState.value = recipes
        }
    }

    val recipesState: MutableState<List<FoodModel>> = mutableStateOf(emptyList())

    private suspend fun getRecipes(): List<FoodModel> {
        return repository.getRecipes()
    }

    override fun onCleared() {
        super.onCleared()
        recipesJob.cancel()
    }

}