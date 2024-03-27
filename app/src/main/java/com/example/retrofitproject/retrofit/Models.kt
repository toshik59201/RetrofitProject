package com.example.retrofitproject.retrofit

import com.squareup.Moshi.Json
import com.squareup.Moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rootobj(
    val info : Info,
    @Json(name ="results")
    val characters: Array<Character>)

@JsonClass(generateAdapter = true)
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

@JsonClass(generateAdapter = true)
data class Models(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: Origin,
    var location: Location,
    var image: String,
    var episode: Array<String>,
    var url: String,
    var created: String
)

@JsonClass(generateAdapter = true)
data class Origin(
    val name: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val url: String
)
