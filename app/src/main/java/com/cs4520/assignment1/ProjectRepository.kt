package com.cs4520.assignment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProductRepository {
    private val productService = RetrofitInstance.productService

    suspend fun fetchProducts(): List<Product> {
        return productService.getProducts()
    }
}
