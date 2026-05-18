package com.example.nammanala1

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object IssueStorage {

    private const val PREF_NAME = "issue_prefs"
    private const val KEY = "issue_list"

    fun save(context: Context, list: MutableList<Issue>) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = Gson().toJson(list)
        prefs.edit().putString(KEY, json).apply()
    }

    fun load(context: Context): MutableList<Issue> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY, null)

        return if (json != null) {
            val type = object : TypeToken<MutableList<Issue>>() {}.type
            Gson().fromJson(json, type)
        } else {
            mutableListOf()
        }
    }
}



