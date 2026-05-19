package com.example.nammanala1

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object IssueStorage {
    private const val PREFS_NAME = "namma_nala_prefs"
    private const val KEY_ISSUES = "issues_list"
    private val gson = Gson()

    fun saveIssues(context: Context, issues: List<Issue>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = gson.toJson(issues)
        prefs.edit().putString(KEY_ISSUES, json).apply()
    }

    fun loadIssues(context: Context): MutableList<Issue> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_ISSUES, null) ?: return mutableListOf()
        return try {
            val type = object : TypeToken<MutableList<Issue>>() {}.type
            gson.fromJson(json, type) ?: mutableListOf()
        } catch (e: Exception) {
            mutableListOf()
        }
    }
}
