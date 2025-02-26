package com.quickcall.res.models.contacts

import kotlinx.serialization.Serializable

@Serializable
data class Event(var value: String, var type: Int)
