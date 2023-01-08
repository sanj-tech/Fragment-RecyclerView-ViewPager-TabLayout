package com.example.fragmentwithviewpagertablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentwithviewpagertablayout.adapter.SweetAdapter
import com.example.fragmentwithviewpagertablayout.model.SweetModel

class SweetFragment: Fragment() {
    private lateinit var fragmentView: View
    val sweetList = mutableListOf<SweetModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(R.layout.sweet_item, container, false)
        fragmentView = view
        initView()
        return view
    }

    private fun initView() {
        var recyclerView=fragmentView.findViewById<RecyclerView>(R.id.rv)
        sweetList.add(SweetModel("peda","Sweet"))

        val sweetAdapter = SweetAdapter(this,sweetList)
        recyclerView.adapter = sweetAdapter
    }


}