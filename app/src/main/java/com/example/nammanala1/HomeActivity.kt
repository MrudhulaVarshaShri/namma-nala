package com.example.nammanala1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nammanala1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddIssue.setOnClickListener {
            startActivity(Intent(this, AddIssueActivity::class.java))
        }

        binding.btnViewIssues.setOnClickListener {
            startActivity(Intent(this, IssueListActivity::class.java))
        }
    }
}
