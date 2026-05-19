package com.example.nammanala1

import java.util.UUID

data class Issue(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String,
    var status: String = "Open"
)



