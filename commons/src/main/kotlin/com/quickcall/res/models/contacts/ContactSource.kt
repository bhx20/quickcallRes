package com.quickcall.res.models.contacts

import com.quickcall.res.helpers.SMT_PRIVATE

data class ContactSource(var name: String, var type: String, var publicName: String, var count: Int = 0) {
    fun getFullIdentifier(): String {
        return if (type == SMT_PRIVATE) {
            type
        } else {
            "$name:$type"
        }
    }
}
