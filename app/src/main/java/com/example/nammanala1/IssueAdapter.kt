package com.example.nammanala1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nammanala1.databinding.ItemIssueBinding

class IssueAdapter(
    private var issues: MutableList<Issue>,
    private val onActionClick: (Issue) -> Unit
) : RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {

    inner class IssueViewHolder(private val binding: ItemIssueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(issue: Issue) {
            binding.tvTitle.text = issue.title
            binding.tvDesc.text = issue.description
            binding.tvStatus.text = issue.status

            if (issue.status == "Closed") {
                binding.tvStatus.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, android.R.color.darker_gray)
                )
                binding.btnAction.isEnabled = false
                binding.btnAction.text = "Resolved"
            } else {
                binding.tvStatus.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context, android.R.color.holo_blue_light)
                )
                binding.btnAction.isEnabled = true
                binding.btnAction.text = "Mark Closed"
            }

            binding.btnAction.setOnClickListener {
                onActionClick(issue)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val binding = ItemIssueBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IssueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(issues[position])
    }

    override fun getItemCount(): Int = issues.size

    fun updateData(newIssues: List<Issue>) {
        issues.clear()
        issues.addAll(newIssues)
        notifyDataSetChanged()
    }
}
