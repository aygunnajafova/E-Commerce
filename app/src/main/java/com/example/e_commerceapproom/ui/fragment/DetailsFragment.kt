package com.example.e_commerceapproom.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.e_commerceapproom.MainActivity
import com.example.e_commerceapproom.R
import com.example.e_commerceapproom.databinding.FragmentDetailsBinding
import com.google.android.material.snackbar.Snackbar

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val bundle: DetailsFragmentArgs by navArgs()
        val resultProduct = bundle.product

        binding.imageViewDetailProduct.setImageResource(
            requireContext().resources.getIdentifier(resultProduct.image,"drawable",requireContext().packageName))
        binding.textViewDetailsName.setText(resultProduct.name)
        binding.textViewDetailsPrice.setText("Rs. ${resultProduct.price.toString()}")
        binding.textViewDetailDescription.text = resultProduct.description

        binding.fabPrevious.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.detailsToHome)
        }

        binding.btnAddToCart.setOnClickListener {
            addToCart(resultProduct.id)
            Snackbar.make(it,"Added to the Cart!",Snackbar.LENGTH_SHORT).show()
        }


        return binding.root
    }

    fun addToCart(id:Int) {
        Log.e("msg","Added to the cart")
    }
}


//b.imageViewProduct.setImageResource(
//            mContext.resources.getIdentifier(product.image,"drawable",mContext.packageName))
//