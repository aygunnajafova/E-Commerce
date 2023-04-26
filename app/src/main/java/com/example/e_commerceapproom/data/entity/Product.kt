package com.example.e_commerceapproom.data.entity

import java.io.Serializable

data class Product(val id: Int,
                   var image: String,
                   var name: String,
                   var description: String,
                   var price: Double) : Serializable {
}