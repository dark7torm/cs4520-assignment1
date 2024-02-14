import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.R

class ProductAdapter(private val productList: List<List<Any?>>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productDetails: List<Any?>) {
            val productName = itemView.findViewById<TextView>(R.id.product_name)
            val productPrice = itemView.findViewById<TextView>(R.id.product_price)
            val productExpiry = itemView.findViewById<TextView>(R.id.product_expiry)
            val productImage = itemView.findViewById<ImageView>(R.id.product_image)

            productName.text = productDetails[0] as? String ?: "Unknown"
            val price = productDetails[3] as? Int ?: 0
            productPrice.text = itemView.context.getString(R.string.product_price, price)


            when (productDetails[1] as? String) {
                "Equipment" -> {
                    itemView.setBackgroundColor(Color.parseColor("#E06666"))
                    productImage.setImageResource(R.drawable.equipment)
                }
                "Food" -> {
                    itemView.setBackgroundColor(Color.parseColor("#FFD965"))
                    productImage.setImageResource(R.drawable.food)
                    productDetails[2]?.let {
                        productExpiry.visibility = View.VISIBLE
                        productExpiry.text = itemView.context.getString(R.string.product_expiry, it as String)
                    } ?: run { productExpiry.visibility = View.GONE }
                }
            }
        }
    }
}
