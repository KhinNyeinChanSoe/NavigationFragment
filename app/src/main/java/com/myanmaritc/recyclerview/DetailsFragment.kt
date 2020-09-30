package com.myanmaritc.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var messageArgs = arguments?.let {
            DetailsFragmentArgs.fromBundle(it)
        }
        var name = messageArgs?.name
        var image = messageArgs?.image
        tv_floweDetail.text = name
        image?.let { iv_flowerImage.setImageResource(it) }
    }
}