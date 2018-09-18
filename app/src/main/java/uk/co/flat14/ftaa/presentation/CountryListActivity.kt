package uk.co.flat14.ftaa.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.flat14.ftaa.R
import uk.co.flat14.ftaa.domain.model.Country
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration

class CountryListActivity : AppCompatActivity(), CountryListView, CountryListAdapter.Callback {

    private val presenter = CountryListPresenter(this)
    private var countryList = ArrayList<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryListRecyclerView.layoutManager = LinearLayoutManager(this)
        countryListRecyclerView.adapter = CountryListAdapter(countryList, this)
        countryListRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        countryListRecyclerView.setHasFixedSize(true)
        countryListRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    override fun onResume() {
        super.onResume()
        presenter.getCountries()
    }

    override fun showProgress() {
        loading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        loading.visibility = View.GONE
    }

    override fun setCountries(countryList: List<Country>) {
        this.countryList.addAll(countryList)
    }

    override fun showError(resId: Int) {
        Snackbar.make(rootView, resId, Snackbar.LENGTH_LONG).show()

    }

    override fun onItemClick(countryName: String, url: String) {
        val intent = Intent(this, CountryDetailActivity::class.java)
        intent.putExtra(CountryDetailActivity.KEY_URL, url)
        intent.putExtra(CountryDetailActivity.KEY_COUNTRY_NAME, countryName)
        startActivity(intent)
    }

}
