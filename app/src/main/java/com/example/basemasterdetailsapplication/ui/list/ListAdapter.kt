package com.example.basemasterdetailsapplication.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basemasterdetailsapplication.databinding.ListItemBinding
import com.example.basemasterdetailsapplication.domain.Movie

class ListAdapter(val listener: OnClickListener) :
    ListAdapter<Movie, DataViewHolder>(DataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data, listener)

    }
}

class DataViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Movie, listener: OnClickListener) {
        binding.movie = data
        binding.executePendingBindings()

        itemView.setOnClickListener {
            listener.onClick(data)
        }
    }

    companion object {
        fun from(parent: ViewGroup): DataViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ListItemBinding.inflate(layoutInflater, parent, false)
            return DataViewHolder(binding)
        }
    }
}

class DataDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

interface OnClickListener {
    fun onClick(data: Movie)
}


