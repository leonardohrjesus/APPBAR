package org.business.lhrjesus.feature.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import org.business.lhrjesus.GoogleMapScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  MapsScreen(
    onBackPressed: () -> Unit,
    navigateToFilterScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

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
                                    IconButton(onClick = { navigateToHomeScreen.invoke() }) {
                                        Icon(
                                            Icons.Filled.DateRange,
                                            contentDescription = "Listar Eventos",
                                        )
                                    }
                                    Text(text = "Eventos" )
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = {  }) {
                                        Icon(
                                            Icons.Filled.Place,
                                            contentDescription = "Mapa",
                                            tint = Color.Black)
                                    }
                                    Text(text = "Mapa",color = Color.Black)
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
                )
    )

    {
        GoogleMapScreen(nome = "Bar Vila 567", endereco = "Rua Aspicuelta , 567")
        }

}


