package uk.co.flat14.ftaa.presentation.old//package uk.co.flat14.ftaa.presentation
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import uk.co.flat14.ftaa.databinding.ActivityCountryDetailBinding
//
//private lateinit var binding: ActivityCountryDetailBinding
//
//
//class CountryDetailActivity: AppCompatActivity(){
//
//    companion object {
//        val KEY_URL =   CountryDetailActivity::class.java.simpleName+".KeyUrl"
//        val KEY_COUNTRY_NAME =   CountryDetailActivity::class.java.simpleName+".KeyCountryName"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
//        title = intent.getStringExtra(KEY_COUNTRY_NAME)
//        intent.getStringExtra(KEY_URL)?.let { binding.webView.loadUrl(it) }
//    }
//}
