package com.example.gmailpratice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val index = it + 1
            items.add(ItemModel(
            "\u2709\ufe0f From Nasa ",
                "In this episode of Houston We Have a Podcast, the CHAPEA crew give an update in their third month of a one-year stay in a simulated Mars habitat.",
                "11:21 AM",
                resources.getIdentifier("avtcute", "drawable", packageName)
            ))
        }

        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }


}