package uk.co.flat14.ftaa.presentation.old

import uk.co.flat14.ftaa.domain.countries.CountryInformation

interface CountryListView {

    fun showProgress()

    fun hideProgress()

    fun setCountries(countryInformationList: List<CountryInformation>)

    fun showError(resId: Int)
}
