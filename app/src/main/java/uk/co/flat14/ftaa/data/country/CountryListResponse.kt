package uk.co.flat14.ftaa.data.country

import com.google.gson.annotations.SerializedName

class CountryListResponse(
        val links: Links
)

class Links(val children: List<Children>)

class Children(
        val title: String,
        val details: Details,
        @SerializedName("web_url")
        val webUrl: String
)

class Details(
        @SerializedName("change_description")
        val latestDescription: String,
        val country: Country

)
class Country(val name:String)

