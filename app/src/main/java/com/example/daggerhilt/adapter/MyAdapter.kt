package com.example.daggerhilt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.databinding.ItemBinding
import com.example.daggerhilt.model.Data

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemBinding.bind(view)
    }

    private val myDiffer = object: DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val myAsync = AsyncListDiffer(this, myDiffer)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myPosition = myAsync.currentList[position]
        with(holder){
            binding.itemName.text = myPosition.name
            binding.itemContact.text = myPosition.contact
            binding.itemEmail.text = myPosition.email
        }
    }

    override fun getItemCount(): Int = myAsync.currentList.size

}