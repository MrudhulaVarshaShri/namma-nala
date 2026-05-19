package com.example.nammanala1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nammanala1.databinding.ActivityIssueListBinding

class IssueListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIssueListBinding
    private lateinit var adapter: IssueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIssueListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = IssueAdapter(mutableListOf()) { issue ->
            // On Mark Closed clicked
            val issues = IssueStorage.loadIssues(this)
            val index = issues.indexOfFirst { it.id == issue.id }
            if (index != -1) {
                issues[index].status = "Closed"
                IssueStorage.saveIssues(this, issues)
                loadData()
            }
        }

        binding.rvIssues.layoutManager = LinearLayoutManager(this)
        binding.rvIssues.adapter = adapter

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, AddIssueActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val issues = IssueStorage.loadIssues(this)
        adapter.updateData(issues)
    }
}
