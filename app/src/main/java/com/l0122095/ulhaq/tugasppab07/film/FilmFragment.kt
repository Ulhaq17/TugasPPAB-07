package com.l0122095.ulhaq.tugasppab07.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.l0122095.ulhaq.tugasppab07.R
import com.l0122095.ulhaq.tugasppab07.databinding.FragmentFilmBinding

class FilmFragment : Fragment() {

    private lateinit var binding: FragmentFilmBinding
    private val listFilm = ArrayList<Film>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filmRecyclerView.setHasFixedSize(true)
        listFilm.addAll(getListFilm())
        showFilmRecycler()
    }

    private fun showFilmRecycler() {
        binding.filmRecyclerView.layoutManager = LinearLayoutManager(this.context)
        val filmAdapter = ListFilmAdapter(listFilm)
        binding.filmRecyclerView.adapter = filmAdapter
    }

    private fun getListFilm(): ArrayList<Film> {

        val dataTitle = resources.getStringArray(R.array.filmTitle)
        val dataAuthor = resources.getStringArray(R.array.filmYear)
        val dataSynopsys = resources.getStringArray(R.array.filmSynopsys)
        val dataCover = resources.obtainTypedArray(R.array.filmCover)

        val filmList = ArrayList<Film>()
        for(i in dataTitle.indices) {
            val film = Film(dataTitle[i], dataAuthor[i], dataSynopsys[i], dataCover.getResourceId(i, -1))
            filmList.add(film)
        }

        dataCover.recycle()
        return filmList
    }
}