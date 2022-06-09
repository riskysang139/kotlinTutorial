package com.example.kotlintutorial.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kotlintutorial.R
import com.example.kotlintutorial.home.HomeFragment

class HomeFragment : Fragment() {

    companion object {
        val instance: HomeFragment
            get() {
                val args = Bundle()
                val homeFragment = HomeFragment()
                homeFragment.arguments = args
                return homeFragment
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}