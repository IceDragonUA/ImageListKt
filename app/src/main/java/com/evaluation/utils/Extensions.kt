package com.evaluation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.evaluation.glide.GlideApp


/**
 * @author Vladyslav Havrylenko
 * @since 01.10.2020
 */
fun String?.defIfNull() = this ?: ""
fun Int?.defIfNull(def: Int = 0) = this ?: def

fun ImageView.loadFromUrl(url: String) {
    GlideApp.with(this.context.applicationContext)
        .load(url)
        .into(this)
}

@BindingAdapter("bind:refresher")
fun SwipeRefreshLayout.setRefresher(refreshing: Boolean) {
    this.isRefreshing = refreshing
}

@BindingAdapter("bind:listener")
fun SwipeRefreshLayout.setListener(listener: OnRefreshListener) {
    this.setOnRefreshListener(listener)
}