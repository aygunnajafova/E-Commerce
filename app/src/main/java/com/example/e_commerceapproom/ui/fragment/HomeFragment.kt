package com.example.e_commerceapproom.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_commerceapproom.R
import com.example.e_commerceapproom.data.entity.Product
import com.example.e_commerceapproom.databinding.FragmentHomeBinding
import com.example.e_commerceapproom.ui.adapter.ProductAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val personsList = ArrayList<Product>()
        val p1 = Product(1,"nike1","Nike","New Collection",156.2)
        val p2 = Product(2,"nike2","Converse","Best Seller",196.2)
        val p3 = Product(3,"nike3","Nike","New Collection",159.2)
        val p4 = Product(4,"nike4","Nike","New Collection",258.3)
        val p5 = Product(1,"nike1","Nike","New Collection",156.2)
        val p6 = Product(2,"nike2","Converse","Best Seller",196.2)
        val p7 = Product(3,"nike3","Nike","New Collection",159.2)
        val p8 = Product(4,"nike4","Nike","New Collection",258.3)
        personsList.add(p1)
        personsList.add(p2)
        personsList.add(p3)
        personsList.add(p4)
        personsList.add(p5)
        personsList.add(p6)
        personsList.add(p7)
        personsList.add(p8)

        val adapter = ProductAdapter(requireContext(),personsList)
        binding.rv.adapter = adapter

        return binding.root
    }
}