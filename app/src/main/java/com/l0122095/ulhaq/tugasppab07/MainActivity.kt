package com.l0122095.ulhaq.tugasppab07

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.l0122095.ulhaq.tugasppab07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        @DrawableRes
        private val TAB_ICONS = intArrayOf(
            R.drawable.movie_icon,
            R.drawable.book_icon
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.statusBarColor = ContextCompat.getColor(this, R.color.pixiv_blue_darker)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPageAdapter = SectionPageAdapter(this)
        binding.viewpager.adapter = sectionPageAdapter

        TabLayoutMediator(binding.mainTab, binding.viewpager) { tab, position ->
            tab.icon = ContextCompat.getDrawable(this, TAB_ICONS[position])
        }.attach()
    }
}
