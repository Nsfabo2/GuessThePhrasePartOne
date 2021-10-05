package com.example.guessthephrasepartone

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(private val results: List<String>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val result = results[position]

        holder.itemView.apply {
            ResultsTV.text = result

            if (result.startsWith("Wrong") || result.startsWith("Game"))
                ResultsTV.setTextColor(Color.RED)
            else if (result.startsWith("Found"))
                ResultsTV.setTextColor(Color.GREEN)
            else
                ResultsTV.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int = results.size
}