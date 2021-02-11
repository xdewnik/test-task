package com.coolya.testapp.data.dto

sealed class CourseItem

data class PrivatCourse(
    val ccy: String,
    val base_ccy: String,
    val buy: String,
    val sale: String
) : CourseItem()


data class Header(val title: String): CourseItem()

data class CryptoCourse(val id: String,
                        val rank: Long,
                        val symbol: String,
                        val name: String,
                        val priceUsd: String
): CourseItem()


data class CryptoResponse(val data: List<CryptoCourse>)
