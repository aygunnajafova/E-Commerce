package com.example.e_commerceapproom.data.entity

import java.io.Serializable

data class CartProduct(val id: Int,
                       var image: String,
                       var name: String,
                       var price: Double,
                       var count: Int) : Serializable {
}