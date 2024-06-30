package com.l0122095.ulhaq.tugasppab07.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.l0122095.ulhaq.tugasppab07.databinding.ItemCardBinding

class ListFilmAdapter(private val listFilm: ArrayList<Film>) : RecyclerView.Adapter<ListFilmAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        holder.binding.imgCover.setImageResource(film.cover)
        holder.binding.titleCover.text = film.title
        holder.binding.authorCover.text = film.year

        //Untuk limit kata dalam sinopsis
        val synopsysText = if (film.synopsys.length > 300) {
            film.synopsys.substring(0, 300) + "..."
        } else {
            film.synopsys
        }
        holder.binding.synopsysCover.text = synopsysText
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    class FilmViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)
}
