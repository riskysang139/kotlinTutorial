package com.example.kotlintutorial.base

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlintutorial.R
import com.example.kotlintutorial.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupStatusBar()
        setupView()
    }

    private fun setupView() {
        adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter;
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigation.menu.findItem(R.id.navigation_home)
                    1 -> binding.bottomNavigation.menu.findItem(R.id.navigation_wallet)
                    2 -> binding.bottomNavigation.menu.findItem(R.id.navigation_my_ticket)
                }
            }
        })
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    binding.viewPager.currentItem = 0
                }
                R.id.navigation_wallet -> {
                    binding.viewPager.currentItem = 1
                }
                R.id.navigation_my_ticket -> {
                    binding.viewPager.currentItem = 2
                }
                else -> {
                    binding.viewPager.currentItem = 0
                }
            }
            return@setOnItemSelectedListener true
        }
    }


    @SuppressLint("ObsoleteSdkInt")
    private fun setupStatusBar() {
        if (Build.VERSION.SDK_INT in 19..20) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
        val win = activity.window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}