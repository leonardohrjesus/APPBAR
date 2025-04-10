@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SelectableChipElevation
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(navigateToFilterScreen: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
      //  modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Top Bar ",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {  navigateToFilterScreen.invoke() },
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.List,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },



        bottomBar = (
                {
                    BottomAppBar (
                        containerColor = MaterialTheme.colorScheme.primary,
                        actions = {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = { navigateToFilterScreen.invoke() }) {
                                        Icon(
                                            Icons.Filled.DateRange,
                                            contentDescription = "Abrir calendário",
                                            tint = Color.Black
                                        )
                                    }
                                    Text(text = "Eventos" , color = Color.Black)
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = { /* abrir mapa */ }) {
                                        Icon(Icons.Filled.Place, contentDescription = "Mapa")
                                    }
                                    Text(text = "Mapa")
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = { navigateToFilterScreen.invoke() }) {
                                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Compra")
                                    }
                                    Text(text = "Ingresso")
                                }
                            }
                        }
                    )
                }
                ),


    ) { innerPadding ->
        val chipOptions = listOf("Pagode", "Funk", "Sertanejo", "MPB", "Rock", "Eletronica","Todos")
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            AssistChipCarousel(chips = chipOptions) { clickedChip ->
                // Handle the clicked chip here
                println("Clicked chip: $clickedChip")
            }
            ScrollContent(PaddingValues(0.dp))
        }
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val range = 1..100
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(range.count()) { index ->
            ElevatedCardExample(index)
        }

    }
}

@Composable
fun ElevatedCardExample(index: Int) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp)
    ) {
        Column {
            MyImage()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(
                        text = "Bar 567 ${index + 1}",
                        fontSize = 14.sp
                    )
                }

                Row(
                   verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Ícone de localização",
                        tint = Color.Black,

                    )
                    Text(
                        text = "R. Aspicuelta, 567 - Vila Madalena ${index + 1}",
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 12.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Ícone de Data",
                        tint = Color.Black,

                        )
                    Text(
                        text = "Sab, 16  de Abril - 18:30",
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 12.sp
                    )
                }

            }
        }
    }

}


@Composable
fun MyImage() {

    AsyncImage(
        model = "https://lh3.googleusercontent.com/p/AF1QipOdntTx9QXDxQtZ5tXJVOC4lCEPT5LSsV24aaE2=s1360-w1360-h1020",
        contentDescription = "imagem",
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        contentScale = ContentScale.FillBounds // ou ContentScale.FillWidth se quiser mostrar tudo
    )
}

@Composable
fun AssistChipCarousel(
    chips: List<String>,
    onChipClicked: (String) -> Unit
) {
    var selectedChip by remember { mutableStateOf<String?>(null) }
    val listState = rememberLazyListState()

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(chips) { chip ->
            val isSelected = selectedChip == chip
            AssistChip(
                onClick = {
                    selectedChip = chip
                    onChipClicked(chip)
                },
                label = { Text(chip) },
                modifier = Modifier.padding(4.dp),
                colors = if (isSelected) {
                    AssistChipDefaults.assistChipColors(
                        containerColor = Color.Black,
                        labelColor = Color.White
                    )
                } else {
                    AssistChipDefaults.assistChipColors()
                }
            )
        }
    }
}
