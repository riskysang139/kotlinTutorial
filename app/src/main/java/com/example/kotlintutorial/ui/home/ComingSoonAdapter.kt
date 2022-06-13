package com.example.kotlintutorial.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ItemComingFilmBinding

class ComingSoonAdapter(private var listFilm: List<ResultsFilm>) :
    RecyclerView.Adapter<ComingSoonAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setFilmList(listFilm: List<ResultsFilm>) {
        this.listFilm = listFilm
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_coming_film,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = listFilm[position]
    }

    override fun getItemCount(): Int = listFilm.size

    inner class ViewHolder(val binding: ItemComingFilmBinding) :
        RecyclerView.ViewHolder(binding.root)
}