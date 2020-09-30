package com.myanmaritc.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmaritc.recyclerview.adapter.FlowerAdapter
import com.myanmaritc.recyclerview.model.Flower
import kotlinx.android.synthetic.main.fragment_flower.*


class FlowerFragment : Fragment(),FlowerAdapter.ClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var flowerList = ArrayList<Flower>()
        flowerList.add(Flower("Daisy", 32.0, R.drawable.daisy))
        flowerList.add(Flower("Rose", 32.0, R.drawable.rose))
        flowerList.add(Flower("Daisy", 32.0, R.drawable.daisy))
        flowerList.add(Flower("Rose", 32.0, R.drawable.rose))
        flowerList.add(Flower("Daisy", 32.0, R.drawable.daisy))
        flowerList.add(Flower("Rose", 32.0, R.drawable.rose))
        var flowerAdapter = FlowerAdapter(flowerList)
        flowerRecycler.layoutManager = LinearLayoutManager(context)
        flowerRecycler.adapter = flowerAdapter
        flowerAdapter.setOnClickListener(this)
    }

    override fun onClick(flower: Flower) {
//        findNavController().navigate(R.id.action_flowerFragment_to_detailsFragment)
        var flowername = flower.name
        var flowerImage = flower.image
        var action =  FlowerFragmentDirections.actionFlowerFragmentToDetailsFragment(flowername,flowerImage)
        findNavController().navigate(action)
    }
}