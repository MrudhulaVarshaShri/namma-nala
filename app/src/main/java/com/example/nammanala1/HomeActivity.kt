package com.example.nammanala1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Safe padding handling
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnAddIssue = findViewById<Button>(R.id.btnAddIssue)
        val btnViewIssues = findViewById<Button>(R.id.btnViewIssues)

        // ➕ Add Issue
        btnAddIssue.setOnClickListener {
            try {
                val intent = Intent(this, AddIssueActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "AddIssueActivity not found", Toast.LENGTH_SHORT).show()
            }
        }

        // 📋 View Issues
        btnViewIssues.setOnClickListener {
            try {
                val intent = Intent(this, IssueListActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "IssueListActivity not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}