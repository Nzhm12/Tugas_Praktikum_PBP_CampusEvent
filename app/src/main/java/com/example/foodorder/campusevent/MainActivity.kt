package com.example.foodorder.campusevent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvEvents: RecyclerView
    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvEvents = findViewById(R.id.rvEvents)
        
        val dummyEvents = listOf(
            Event("Seminar Nasional AI & Masa Depan", "12 April 2026", R.drawable.img_1),
            Event("Workshop UI/UX Design untuk Pemula", "15 April 2026", R.drawable.img_2),
            Event("Lomba Inovasi Teknologi Kampus", "20 April 2026", R.drawable.img_3),
            Event("Talkshow Karir di Industri Kreatif", "25 April 2026", R.drawable.img_4)
        )

        eventAdapter = EventAdapter(dummyEvents)
        rvEvents.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = eventAdapter
        }
    }
}