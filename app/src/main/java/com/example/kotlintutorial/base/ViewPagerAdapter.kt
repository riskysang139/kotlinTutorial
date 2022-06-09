package com.example.kotlintutorial.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlintutorial.home.HomeFragment
import com.example.kotlintutorial.myticket.MyTicketFragment
import com.example.kotlintutorial.wallet.WalletFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> WalletFragment.instance
            2 -> MyTicketFragment.instance
            else -> HomeFragment.instance
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}