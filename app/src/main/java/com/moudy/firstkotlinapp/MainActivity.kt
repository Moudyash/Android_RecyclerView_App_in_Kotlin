package com.moudy.firstkotlinapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.moudy.firstkotlinapp.data.Comment
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val formatted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")

            current.format(formatter)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        println("Current Date and Time is: $formatted")

        initViews(formatted)

    }

    fun initViews(formatted: String) {

        val send = findViewById<Button>(R.id.send)
        val comment = findViewById<TextInputEditText>(R.id.comment_edittext)
        val username = findViewById<TextInputEditText>(R.id.username_edittext)
        val ratingbar = findViewById<RatingBar>(R.id.rate)

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val data = ArrayList<Comment>()
        recyclerview.layoutManager = LinearLayoutManager(this)
        val rating: Int = ratingbar.rating.toInt()
        val stars:Int
        when (rating) {
            0 -> stars = R.drawable.ic_empty_stars
            1 -> stars = R.drawable.ic_one_star
            2 -> stars = R.drawable.ic_two_stars
            3 -> stars = R.drawable.ic_three_stars
            4 -> stars = R.drawable.ic_four_stars
            5 -> stars = R.drawable.ic_five_stars


        }
        val adapter = adapter(data)

        recyclerview.adapter = adapter
        send.setOnClickListener {

            data.add(
                Comment(
                    username.text.toString(),
                    comment.text.toString(),
                    formatted
                )
            )
            adapter.notifyDataSetChanged()
        }
    }
}