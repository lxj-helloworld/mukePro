package com.example.mukepro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.open_log_page).setOnClickListener {
            startActivity(Intent(this,LogActivity::class.java))
        }

        findViewById<Button>(R.id.open_bottom_tab_page).setOnClickListener {
            startActivity(Intent(this,BottomTabActivity::class.java))
        }

        findViewById<Button>(R.id.open_top_tab_page).setOnClickListener {
            startActivity(Intent(this,TopTabActivity::class.java))
        }
    }

}