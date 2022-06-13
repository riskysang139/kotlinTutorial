package com.example.kotlintutorial.ui.myticket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kotlintutorial.R
import com.example.kotlintutorial.ui.myticket.MyTicketFragment

class MyTicketFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        val instance: MyTicketFragment
            get() {
                val args = Bundle()
                val homeFragment = MyTicketFragment()
                homeFragment.arguments = args
                return homeFragment
            }
    }
}