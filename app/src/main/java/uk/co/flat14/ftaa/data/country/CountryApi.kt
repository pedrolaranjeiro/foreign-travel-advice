package uk.co.flat14.ftaa.data.country

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryApi {

    @GET("content/foreign-travel-advice")
    fun getCountries(): Call<CountryListResponse>
}


private const val BASE_URL = "https://www.gov.uk/api/"

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

val countryApi: CountryApi = retrofit.create(CountryApi::class.java)
