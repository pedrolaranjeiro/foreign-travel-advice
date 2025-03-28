package uk.co.flat14.ftaa.data.country

import kotlinx.coroutines.flow.flow

class RemoteCountryDataStore {
    
    fun getCountries() = flow {
        val response = countryApi.getCountries().execute()
        if(response.isSuccessful){
            emit(response.body())
        }
        else{
            throw Exception("Error: ${response.code()}")
        }

    }

}
