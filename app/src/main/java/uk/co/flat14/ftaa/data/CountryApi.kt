package uk.co.flat14.ftaa.data

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import uk.co.flat14.ftaa.data.models.CountryListReponse

interface CountryApi {

    @GET("content/foreign-travel-advice")
    fun getCountries(): Single<CountryListReponse>
}


private const val BASE_URL = "https://www.gov.uk/api/"

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

val countryApi = retrofit.create(CountryApi::class.java)
