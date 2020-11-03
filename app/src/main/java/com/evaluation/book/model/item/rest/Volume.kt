package com.evaluation.book.model.item.rest

import com.google.gson.annotations.SerializedName

/**
 * @author Vladyslav Havrylenko
 * @since 07.10.2020
 */
data class Volume(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)