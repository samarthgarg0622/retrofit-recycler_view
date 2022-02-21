package com.example.retrofit

import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=?

const val BASE_URL = "https://newsapi.org"
const val API_KEY = "5e9a7c0f4b524ccd85040654898dea48"

interface NewsInterface{
    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String,@Query("page")page:Int):Call<News>
}

object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)

    }

}