package uk.co.flat14.ftaa.data.models

import com.google.gson.annotations.SerializedName

class CountryListReponse(val links: Links)

class Links(val children: List<Children>)

class Children(
        val country: Country,
        @SerializedName("web_url")
        val webUrl: String
)

class Country(val name:String)