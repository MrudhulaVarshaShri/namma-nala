package com.example.nammanala1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nammanala1.databinding.ActivityAddIssueBinding

class AddIssueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddIssueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddIssueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val desc = binding.etDesc.text.toString().trim()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val issues = IssueStorage.loadIssues(this)
            issues.add(Issue(title = title, description = desc))
            IssueStorage.saveIssues(this, issues)

            Toast.makeText(this, "Issue Reported Successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
