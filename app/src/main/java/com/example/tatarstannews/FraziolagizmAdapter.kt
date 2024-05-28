package com.example.tatarstannews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FraziolagizmAdapter(private val context: Context, private val dataList: List<Fraziolagizm>) :
    RecyclerView.Adapter<FraziolagizmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fraz_test, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.fraziolagizmTextView.text = item.fraziolagizm
        holder.translationTextView.text = item.translation
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fraziolagizmTextView: TextView = itemView.findViewById(R.id.fraziolagizmTextView)
        val translationTextView: TextView = itemView.findViewById(R.id.translationTextView)
    }
}
