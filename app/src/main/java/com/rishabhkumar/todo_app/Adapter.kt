package com.rishabhkumar.todo_app

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_view.view.*

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.txtTaskTitle
        var priority = itemView.txtTaskPriority
        var layout = itemView.myLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        //setting the color of item according to their priority
        when (data[position].priority.toLowerCase()) {
            "high" -> holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
            "medium" -> holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
            else -> holder.layout.setBackgroundColor(Color.parseColor("#"))

        }

        //setting the data of each row
        holder.title.text = data[position].title
        holder.priority.text = data[position].priority

        //setting up the when item got clicked for updation
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateTaskDetails::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}