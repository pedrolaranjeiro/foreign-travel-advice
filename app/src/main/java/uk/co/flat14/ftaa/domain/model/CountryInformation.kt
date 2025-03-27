package uk.co.flat14.ftaa.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryInformation(
        val name: String,
        val details: String,
        val webUrl: String
)
