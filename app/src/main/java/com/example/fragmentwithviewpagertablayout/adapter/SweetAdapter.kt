package com.example.fragmentwithviewpagertablayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentwithviewpagertablayout.R
import com.example.fragmentwithviewpagertablayout.SweetFragment
import com.example.fragmentwithviewpagertablayout.databinding.CustomItemBinding
import com.example.fragmentwithviewpagertablayout.databinding.SweetItemBinding
import com.example.fragmentwithviewpagertablayout.model.SweetModel

class SweetAdapter(var context: SweetFragment,var sweetList: MutableList<SweetModel>): RecyclerView.Adapter<SweetAdapter.SweetViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetViewHolder {

     var binding:CustomItemBinding=DataBindingUtil.inflate(LayoutInflater.from(context.requireContext()),
         R.layout.custom_item,parent,false)
        return SweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SweetViewHolder, position: Int) {
       holder.binding.tvName.text=sweetList[position].sweetName
        holder.binding.tvtest.text=sweetList[position].sweetTest
    }

    override fun getItemCount(): Int {
        return sweetList.size
    }
    class SweetViewHolder(var binding: CustomItemBinding): RecyclerView.ViewHolder(binding.root) {

    }
}