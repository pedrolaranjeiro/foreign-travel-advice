package uk.co.flat14.ftaa.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import uk.co.flat14.ftaa.domain.model.CountryInformation
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListState
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListViewModel


// Stateful version
@Composable
fun CountryListScreen(
    viewModel: CountryListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    viewModel.getCountries()
    CountryListScreen(uiState = uiState)
}

//Stateless function
@Composable
fun CountryListScreen(
    uiState: CountryListState
) {
    when (uiState) {
        CountryListState.Loading -> {
            Text(text = "Loading")
        }

        is CountryListState.Success -> CountryList(countryInformationList = uiState.countryInformationList)
    }

}

@Composable
fun CountryList(countryInformationList: List<CountryInformation>) {
    LazyColumn {
        items(countryInformationList) {
            CountryItem(countryInformation = it)
        }
    }
}


@Composable
fun CountryItem(countryInformation: CountryInformation) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(75.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                textAlign = TextAlign.Center,

                text = countryInformation.name,
                modifier = Modifier
                    .padding(all = 8.dp)

            )
        }
    }
}

@Preview
@Composable
fun PreviewCountryList() {
    CountryList(
        listOf(
            CountryInformation("United Kingdon", "This is safe", "www"),
            CountryInformation("Australia", "This is safe but be careful with the spiders", "")
        )
    )
}
