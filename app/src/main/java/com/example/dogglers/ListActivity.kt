package com.example.dogglers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.adapter.DogCardAdapter
import com.example.dogglers.const.Layout

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val typeDisplay = intent!!.getIntExtra(Layout.TYPE_DISPLAY, Layout.VERTICAL)
        val adapter = DogCardAdapter(this, typeDisplay)
        recyclerView.adapter = adapter
        val layoutManager = when (typeDisplay) {
            Layout.VERTICAL -> LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            Layout.HORIZONTAL -> LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            else -> GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this);
                true;
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}