package uk.co.flat14.ftaa.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_list_row.view.*
import uk.co.flat14.ftaa.R
import uk.co.flat14.ftaa.domain.model.Country


class CountryListAdapter (private var countryList: ArrayList<Country>, private val callback: Callback): RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countryList[position]
        holder.itemView.countryName.text = country.name
        holder.itemView.setOnClickListener {
            callback.onItemClick(country.name, country.webUrl)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface Callback{
        fun onItemClick(countryName:String, url:String)
    }

}

