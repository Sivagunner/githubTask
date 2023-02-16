package com.example.retrofitcalling

import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://simplifiedcoding.net/demos/"

//private val gson = Gson.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()

interface ApiService{

    @GET("marvel")
    fun getAllData(): Call<List<Property>>

}

object Api {
    val retrofitService: ApiService by lazy{retrofit.create(ApiService::class.java)}
}