package com.adematici.recipescomposeapp.model

import com.google.gson.annotations.SerializedName

data class FoodModel(
    @SerializedName("isim")
    val foodName: String,
    @SerializedName("malzeme")
    val foodIngredient: String,
    @SerializedName("yapilis")
    val foodCook: String,
    @SerializedName("gorsel")
    val foodImage: String
)