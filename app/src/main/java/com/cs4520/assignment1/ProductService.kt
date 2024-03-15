package com.cs4520.assignment1

import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("prod")
    suspend fun getProducts(@Query("page") page: Int? = null): List<Product>
}
