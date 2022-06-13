package com.example.kotlintutorial.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ItemCategoryBinding

class CategoryAdapter(
    var listCategory: List<Category>,
    val listener: OnClick
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun onBind(category: Category, position: Int) {
            if (category.type.equals("All")) {
                category.isChoose = true
            } else {
                binding.root.setOnClickListener {
                    category.isChoose = !category.isChoose
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.category = listCategory[position]
        holder.onBind(listCategory[position], position)
    }

    override fun getItemCount(): Int = listCategory.size

    interface OnClick {
        fun onClickItem(category: Category, position: Int)
    }
}