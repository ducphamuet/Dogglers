package com.example.dogglers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogglers.const.Layout
import com.example.dogglers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.verticalBtn.setOnClickListener { startVerticalListActivity() }
        binding.horizontalBtn.setOnClickListener { startHorizontalListActivity() }
        binding.gridBtn.setOnClickListener { startGridListActivity() }
    }

    private fun startGridListActivity() {
        intent = Intent(this, ListActivity::class.java)
        intent.putExtra(Layout.TYPE_DISPLAY, Layout.GRID)
        startActivity(intent)
    }

    private fun startHorizontalListActivity() {
        intent = Intent(this, ListActivity::class.java)
        intent.putExtra(Layout.TYPE_DISPLAY, Layout.HORIZONTAL)
        startActivity(intent)
    }

    private fun startVerticalListActivity() {
        intent = Intent(this, ListActivity::class.java)
        intent.putExtra(Layout.TYPE_DISPLAY, Layout.VERTICAL)
        startActivity(intent)
    }
}