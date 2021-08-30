package com.adematici.recipescomposeapp.repository

import com.adematici.recipescomposeapp.model.FoodModel
import com.adematici.recipescomposeapp.service.FoodAPI

class FoodRepository(private val webService: FoodAPI = FoodAPI()) {
    suspend fun getRecipes(): List<FoodModel> {
        return webService.getRecipes()
    }
}