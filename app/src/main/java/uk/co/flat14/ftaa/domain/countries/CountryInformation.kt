package uk.co.flat14.ftaa.domain.countries

import kotlinx.serialization.Serializable

@Serializable
data class CountryInformation(
        val name: String,
        val details: String,
        val webUrl: String
)
