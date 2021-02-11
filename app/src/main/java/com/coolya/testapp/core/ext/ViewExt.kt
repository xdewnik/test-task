package com.coolya.testapp.core.ext

import android.view.View

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}