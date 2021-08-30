package com.adematici.recipescomposeapp.service

import com.adematici.recipescomposeapp.model.FoodModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class FoodAPI {

    private val api: FoodApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(FoodApi::class.java)
    }

    suspend fun getRecipes(): List<FoodModel> {
        return api.getRecipes()
    }

    interface FoodApi {
        @GET("aticiadem/YemekKitabiJSONVeriSeti/main/yemekler.json")
        suspend fun getRecipes(): List<FoodModel>
    }

}