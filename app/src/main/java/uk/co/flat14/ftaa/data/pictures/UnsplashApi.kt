package uk.co.flat14.ftaa.data.pictures

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("search/photos/?client_id=$accessKey")
    fun getCountries(@Query("query") countryName:String): Call<UnsplashPictureListResponse>
}

private const val BASE_URL = "https://api.unsplash.com"
private const val accessKey = "4GuTYVbXmV4qmklbPjFIHc9RvTEW2I-djzX3xHcozZ0"


private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val unsplashApi: UnsplashApi = retrofit.create(UnsplashApi::class.java)
