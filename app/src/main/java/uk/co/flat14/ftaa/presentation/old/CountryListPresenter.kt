package uk.co.flat14.ftaa.presentation.old

class CountryListPresenter (val view: CountryListView){

 /*   var countriesUseCase: GetCountriesUseCase = UseCaseFactory().getCountriesUseCase()

    fun getCountries(){
        view.showProgress()
        countriesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    view.hideProgress()
                }
                .subscribe({
                    view.setCountries(it)
                }, { exception ->
                    if(exception is UnknownHostException){
                        view.showError(R.string.noConnection)
                    }else{
                        view.showError(R.string.genericError)
                    }
                })
    }*/


}
