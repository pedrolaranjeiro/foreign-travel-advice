package uk.co.flat14.ftaa.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import uk.co.flat14.ftaa.domain.countries.CountryInformation
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListState
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListViewModel
import uk.co.flat14.ftaa.presentation.viewmodels.PictureListState
import uk.co.flat14.ftaa.presentation.viewmodels.PictureViewModel


// Stateful version
@Composable
fun CountryListScreen(
    viewModel: CountryListViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CountryListScreen(uiState = uiState)
}

//Stateless function
@Composable
fun CountryListScreen(
    uiState: CountryListState
) {
    when (uiState) {
        is CountryListState.Loading -> {}
        is CountryListState.Success -> CountryList(countryInformationList = uiState.countryInformationList)
    }

}

@Composable
fun CountryList(countryInformationList: List<CountryInformation>) {
    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = lazyListState,
        flingBehavior = snapBehavior
    ) {
        itemsIndexed(countryInformationList) { index, item ->
            CountryItem(countryInformation = item)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CountryItem(
    countryInformation: CountryInformation,
) {
    val configuration = LocalConfiguration.current
    val viewModel = koinInject<PictureViewModel>()
    viewModel.getPictures(countryInformation.name)

    var imageUrl = ""

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when(uiState){
        is PictureListState.Loading -> {}
        is PictureListState.Success -> {
            imageUrl = (uiState as PictureListState.Success).countryPictures.picturesLinks.random()
        }
    }

    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .fillMaxHeight()
            .width(configuration.screenWidthDp.dp)

    ) {

        GlideImage(
            model = imageUrl,
            contentDescription = countryInformation.details,
            contentScale = ContentScale.FillHeight
        )

        Column(
            modifier = Modifier
                .background(color = Color.Black.copy(alpha = 0.5f))
                .padding(all = 16.dp)

        ) {
            Text(
                text = countryInformation.name,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                modifier = Modifier
                    .padding(all = 8.dp)


            )
            Text(
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                text = countryInformation.details,
                modifier = Modifier
                    .padding(all = 8.dp)

            )

        }


    }

}

