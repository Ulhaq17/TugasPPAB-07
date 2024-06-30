package com.l0122095.ulhaq.tugasppab07.book

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.l0122095.ulhaq.tugasppab07.databinding.ItemCardBinding

class ListBookAdapter(private val listBook: ArrayList<Book>): RecyclerView.Adapter<ListBookAdapter.FilmViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListBookAdapter.FilmViewHolder  {
        return FilmViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListBookAdapter.FilmViewHolder, position: Int) {
        val book = listBook[position]
        holder.binding.imgCover.setImageResource(book.cover)
        holder.binding.titleCover.text = book.title
        holder.binding.authorCover.text = book.author

        //Untuk limit kata dalam sinopsis
        val synopsysText = if (book.synopsys.length > 300) {
            book.synopsys.substring(0, 300) + "..."
        } else {
            book.synopsys
        }
        holder.binding.synopsysCover.text = synopsysText
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    class FilmViewHolder(val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root)
}