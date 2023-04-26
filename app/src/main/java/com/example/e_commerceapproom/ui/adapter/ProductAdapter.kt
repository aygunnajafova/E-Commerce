package com.example.e_commerceapproom.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapproom.R
import com.example.e_commerceapproom.data.entity.Product
import com.example.e_commerceapproom.databinding.CardDesignBinding
import com.example.e_commerceapproom.ui.fragment.HomeFragmentDirections

class ProductAdapter(private val mContext: Context, var productsList: List<Product>) : RecyclerView.Adapter<ProductAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val product = productsList.get(position)
        val b = holder.binding

        b.imageViewProduct.setImageResource(
            mContext.resources.getIdentifier(product.image,"drawable",mContext.packageName))
        b.textViewProductName.text = "${product.name}"
        b.textViewProductPrice.text = "Rs. ${product.price}"


        b.cardViewProduct.setOnClickListener {
            val transition = HomeFragmentDirections.homeToDetail(product = product)
            Navigation.findNavController(it).navigate(transition)
        }
    }

}