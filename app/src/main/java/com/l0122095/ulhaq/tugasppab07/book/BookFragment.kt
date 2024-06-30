package com.l0122095.ulhaq.tugasppab07.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.l0122095.ulhaq.tugasppab07.R
import com.l0122095.ulhaq.tugasppab07.databinding.FragmentBookBinding

class BookFragment : Fragment() {

    private lateinit var binding: FragmentBookBinding
    private val listBook = ArrayList<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bookRecyclerView.setHasFixedSize(true)
        listBook.addAll(getListBook())
        showBookRecycler()
    }

    private fun showBookRecycler() {
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this.context)
        val bookAdapter = ListBookAdapter(listBook)
        binding.bookRecyclerView.adapter = bookAdapter
    }

    private fun getListBook(): ArrayList<Book> {

        val dataTitle = resources.getStringArray(R.array.bookTitle)
        val dataAuthor = resources.getStringArray(R.array.bookAuthor)
        val dataSynopsys = resources.getStringArray(R.array.bookSynopsys)
        val dataCover = resources.obtainTypedArray(R.array.bookCover)

        val bookList = ArrayList<Book>()
        for(i in dataTitle.indices) {
            val film = Book(dataTitle[i], dataAuthor[i], dataSynopsys[i], dataCover.getResourceId(i, -1))
            bookList.add(film)
        }

        dataCover.recycle()
        return bookList
    }
}