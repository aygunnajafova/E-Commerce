package com.example.e_commerceapproom.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapproom.data.entity.CartProduct
import com.example.e_commerceapproom.databinding.CartCardDesignBinding

class CartAdapter(var mContext: Context, var cartProductsList: List<CartProduct>)
    : RecyclerView.Adapter<CartAdapter.CartCardDesignHolder>() {

    inner class CartCardDesignHolder(val binding: CartCardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCardDesignHolder {
        val binding = CartCardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CartCardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartProductsList.size
    }

    override fun onBindViewHolder(holder: CartCardDesignHolder, position: Int) {
        val cartProduct = cartProductsList.get(position)
        val b = holder.binding

        b.imageViewCart.setImageResource(
            mContext.resources.getIdentifier(cartProduct.image,"drawable",mContext.packageName)
        )
        b.textViewCartName.text = cartProduct.name
        b.textViewCartCount.text = "Qty: ${cartProduct.count.toString()}"
        b.textViewCartPrice.text = "Rs. " + cartProduct.price.toString()
    }


}