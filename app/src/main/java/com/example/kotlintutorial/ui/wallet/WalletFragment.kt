package com.example.kotlintutorial.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlintutorial.R

class WalletFragment : Fragment() {

    companion object {
        val instance: WalletFragment
            get() {
                val args = Bundle()
                val homeFragment = WalletFragment()
                homeFragment.arguments = args
                return homeFragment
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}