package com.cs4520.assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment1.databinding.FragmentProductListBinding
import kotlinx.coroutines.*

class ProductListFragment : Fragment() {
    private var binding: FragmentProductListBinding? = null
    private var adapter: ProductAdapter? = null
    private var currentPage: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding?.root

        adapter = ProductAdapter(emptyList())
        binding?.productListRecyclerview?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ProductListFragment.adapter
        }

        fetchProducts()

        return view
    }

    private fun fetchProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val productList = RetrofitInstance.productService.getProducts()
                withContext(Dispatchers.Main) {
                    if (productList.isEmpty()) {
                        binding?.productListRecyclerview?.visibility = View.GONE
                        binding?.noProductsTextView?.visibility = View.VISIBLE
                    } else {
                        adapter?.updateData(productList)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
