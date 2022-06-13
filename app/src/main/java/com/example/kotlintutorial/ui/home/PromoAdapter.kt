package com.example.kotlintutorial.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ItemNowPlayingBinding
import com.example.kotlintutorial.databinding.ItemPromoBinding

class PromoAdapter(
    private val listPromo: List<Promo>
) : RecyclerView.Adapter<PromoAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemPromoBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoAdapter.ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_promo,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PromoAdapter.ViewHolder, position: Int) {
        holder.binding.promo = listPromo[position]
    }

    override fun getItemCount(): Int = listPromo.size
}