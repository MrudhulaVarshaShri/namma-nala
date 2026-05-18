package com.example.nammanala1

import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class IssueListActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var list: MutableList<Issue>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_list)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        listView = findViewById(R.id.listView)

        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddIssueActivity::class.java))
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val issue = list[position]

            val options = arrayOf("Mark Closed", "Delete")

            AlertDialog.Builder(this)
                .setTitle(issue.title)
                .setItems(options) { _, which ->

                    when (which) {
                        0 -> issue.status = "Closed"
                        1 -> list.removeAt(position)
                    }

                    IssueStorage.save(this, list)
                    loadData()
                }
                .show()
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        list = IssueStorage.load(this)

        val display = list.map {
            "${it.title} - ${it.status}"
        }

        listView.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            display
        )
    }
}






