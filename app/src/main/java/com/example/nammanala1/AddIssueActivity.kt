package com.example.nammanala1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddIssueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_issue)

        val title = findViewById<EditText>(R.id.etTitle)
        val desc = findViewById<EditText>(R.id.etDesc)
        val btn = findViewById<Button>(R.id.btnSave)

        btn.setOnClickListener {

            val t = title.text.toString()
            val d = desc.text.toString()

            if (t.isNotEmpty() && d.isNotEmpty()) {

                val list = IssueStorage.load(this)
                list.add(Issue(t, d))
                IssueStorage.save(this, list)

                finish()
            }
        }
    }
}







