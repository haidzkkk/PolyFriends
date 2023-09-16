package com.fpoly.polyfriend.data.model

import javax.inject.Inject

data class User (
    var id: String,
    var name: String,
    var username: String,
    val password: String) {
}