package uk.co.flat14.ftaa.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_country_detail.*
import uk.co.flat14.ftaa.R

class CountryDetailActivity: AppCompatActivity(){

    companion object {
        val KEY_URL =   CountryDetailActivity::class.java.simpleName+".KeyUrl"
        val KEY_COUNTRY_NAME =   CountryDetailActivity::class.java.simpleName+".KeyCountryName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        title = intent.getStringExtra(KEY_COUNTRY_NAME)
        webView.loadUrl(intent.getStringExtra(KEY_URL))
    }
}
