package com.cs4520.assignment1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private var productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    fun updateData(newProducts: List<Product>) {
        productList = newProducts
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val productName = itemView.findViewById<TextView>(R.id.product_name)
            val productPrice = itemView.findViewById<TextView>(R.id.product_price)
            val productExpiry = itemView.findViewById<TextView>(R.id.product_expiry)
            val productImage = itemView.findViewById<ImageView>(R.id.product_image)

            productName.text = product.name
            productPrice.text = String.format(itemView.context.getString(R.string.product_price), product.price)

            when (product.type) {
                "Equipment" -> {
                    itemView.setBackgroundColor(Color.parseColor("#E06666"))
                    productImage.setImageResource(R.drawable.equipment)
                }
                "Food" -> {
                    itemView.setBackgroundColor(Color.parseColor("#FFD965"))
                    productImage.setImageResource(R.drawable.food)
                    product.expiryDate?.let {
                        productExpiry.visibility = View.VISIBLE
                        productExpiry.text = itemView.context.getString(R.string.product_expiry, it)
                    } ?: run { productExpiry.visibility = View.GONE }
                }
            }
        }
    }
}
