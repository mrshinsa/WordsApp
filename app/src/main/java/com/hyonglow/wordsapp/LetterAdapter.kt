package com.hyonglow.wordsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter(val context: Context) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        adapterLayout.accessibilityDelegate = WordAdapter
        return LetterViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()

        holder.button.setOnClickListener {
            // Create an intent with a destination of DetailActivity
            val intent = Intent(context, DetailActivity::class.java)
            // Add the selected letter to the intent as extra data
            // The text of Buttons are [CharSequence], a list of characters,
            // so it must be explicitly converted into a [String].
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            // Start an activity using the data and destination from the Intent.
            context.startActivity(intent)
        }
    }

}