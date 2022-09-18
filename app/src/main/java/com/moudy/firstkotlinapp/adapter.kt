package com.moudy.firstkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moudy.firstkotlinapp.data.Comment

class adapter(private val commentlist: List<Comment>)  : RecyclerView.Adapter<adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val comment = commentlist[position]
        holder.username.text=comment.username
        holder.comment.text=comment.comment
        holder.date_of_comment.text=comment.comment_date

    }

    override fun getItemCount(): Int {
        return commentlist.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val username: TextView =itemView.findViewById(R.id.username)
        val comment: TextView =itemView.findViewById(R.id.comment_content)
        val date_of_comment: TextView =itemView.findViewById(R.id.comment_date)
        val stars: ImageView =itemView.findViewById(R.id.rate)

    }
}


