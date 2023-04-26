package com.example.e_commerceapproom.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerceapproom.R
import com.example.e_commerceapproom.data.entity.CartProduct
import com.example.e_commerceapproom.data.entity.Product
import com.example.e_commerceapproom.databinding.FragmentCartBinding
import com.example.e_commerceapproom.ui.adapter.CartAdapter

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())

        val cartProductList = ArrayList<CartProduct>()
        val cp1 = CartProduct(1,"nike1","Nike",156.2, 5)
        val cp2 = CartProduct(2,"nike2","Converse",196.2, 3)
        val cp3 = CartProduct(3,"nike3","Nike",159.2,1)
        val cp4 = CartProduct(4,"nike4","Nike",258.3,2)

        cartProductList.add(cp1)
        cartProductList.add(cp2)
        cartProductList.add(cp3)
        cartProductList.add(cp4)

        val adapter = CartAdapter(requireContext(),cartProductList)
        binding.rvCart.adapter = adapter

        binding.textViewTotalPrice.text = "Rs. " + totalPrice(cartProductList).toString()
        return binding.root
    }

    fun totalPrice(list: List<CartProduct>) : Double {
        var sum = 0.0
        for(i in list) {
            sum+= i.price
        }

        return sum
    }
}