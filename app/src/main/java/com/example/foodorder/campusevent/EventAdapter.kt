package com.example.foodorder.campusevent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class EventAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivEventImage: ImageView = view.findViewById(R.id.ivEventImage)
        val tvEventTitle: TextView = view.findViewById(R.id.tvEventTitle)
        val tvEventDate: TextView = view.findViewById(R.id.tvEventDate)
        val btnDetail: MaterialButton = view.findViewById(R.id.btnDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.tvEventTitle.text = event.title
        holder.tvEventDate.text = event.date
        holder.ivEventImage.setImageResource(event.imageResId)
        
        holder.btnDetail.setOnClickListener {
            // Logic to view detail can be added here
        }
    }

    override fun getItemCount() = events.size
}