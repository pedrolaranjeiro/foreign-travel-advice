package uk.co.flat14.ftaa.presentation

import uk.co.flat14.ftaa.domain.model.Country

interface CountryListView {

    fun showProgress()

    fun hideProgress()

    fun setCountries(countryList: List<Country>)

    fun showError(resId: Int)
}
