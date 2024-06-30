package com.l0122095.ulhaq.tugasppab07

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.l0122095.ulhaq.tugasppab07.book.BookFragment
import com.l0122095.ulhaq.tugasppab07.film.FilmFragment

class SectionPageAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FilmFragment()
            1 -> fragment = BookFragment()
        }

        return fragment as Fragment
    }
}