package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()

    }

    private fun initAdapter(){
        var mainRv = findViewById<RecyclerView>(R.id.Main_rv_recyclerview)
        itemAdapter = ItemAdapter(this)

        val layoutManager = LinearLayoutManager(this)
        mainRv.layoutManager = layoutManager
        mainRv.adapter = itemAdapter
    }
}