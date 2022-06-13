package com.example.kotlintutorial.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ItemComingFilmBinding
import com.example.kotlintutorial.databinding.ItemNowPlayingBinding


class NowPlayingFilmAdapter(private var film: List<ResultsFilm>) :
    RecyclerView.Adapter<NowPlayingFilmAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setFilmList(listFilm: List<ResultsFilm>) {
        this.film = listFilm
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_now_playing,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = film[position]

    }

    override fun getItemCount() = film.size

    inner class ViewHolder(val binding: ItemNowPlayingBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    @SuppressLint("NotifyDataSetChanged")
    private val runnable = Runnable {
        film.toMutableList().addAll(film)
        notifyDataSetChanged()
    }
}