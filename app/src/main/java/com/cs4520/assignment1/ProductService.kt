package com.cs4520.assignment1

import retrofit2.http.GET

interface ProductService {
    @GET("random")
    suspend fun getProducts(): List<Product>
}
