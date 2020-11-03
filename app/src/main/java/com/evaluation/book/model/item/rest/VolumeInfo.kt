package com.evaluation.book.model.item.rest

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 03.11.2020
 */
data class VolumeInfo(
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks
)