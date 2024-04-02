package com.cs4520.assignment1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductListScreen(productsState: State<List<Product>>) {
    val products = productsState.value
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Product List") })
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(products) { product ->
                ProductItem(product)
                Divider()
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(modifier = Modifier.padding(16.dp)) {

        Text("Name: ${product.name}", style = MaterialTheme.typography.h6)
        Text("Price: ${product.price}", style = MaterialTheme.typography.body1)
        product.expiryDate?.let { Text("Expiry Date: $it", style = MaterialTheme.typography.body2) }
    }
}
