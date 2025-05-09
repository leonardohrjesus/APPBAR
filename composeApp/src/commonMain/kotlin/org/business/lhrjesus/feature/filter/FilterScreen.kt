package org.business.lhrjesus.feature.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(
    onBackPressed: () -> Unit,
    navigateToHomeScreen: () -> Unit,
    navigateToMapsScreen: () -> Unit
){
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
                                            contentDescription = "Listar Eventos"
                                        )
                                    }
                                    Text(text = "Eventos")
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = { navigateToMapsScreen.invoke() }) {
                                        Icon(
                                            Icons.Filled.Place,
                                            contentDescription = "Mapa",
                                           )
                                    }
                                    Text(text = "Mapa")
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    IconButton(onClick = {  }) {
                                        Icon(
                                            Icons.Filled.ShoppingCart,
                                            contentDescription = "Compra",
                                            tint = Color.Black)
                                    }
                                    Text(text = "Ingresso",color = Color.Black )
                                }
                            }
                        }
                    )
                }
                )

    ) { innerPadding ->
      Box(contentAlignment = Alignment.Center,
          modifier = Modifier.padding(50.dp)
            ){
          AboutComponent("Leonardo", "MONSTRO",onBackPressed)
      }
    }

}

@Composable
private fun AboutComponent(
    title: String,
    subTitle: String,
    onBackPressed: () -> Unit,
){
    Column( modifier =  Modifier.padding(16.dp)){
        Text(
            text = title,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = subTitle,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            onClick = {
                onBackPressed.invoke()
            }
        ){
            Text("Voltar")
        }

    }
    HorizontalDivider()

}

private fun makeItems():List<Pair<String,String>>{
    return listOf(
        Pair("Sistema operacional","TESTE"),
        Pair("Dispositivo", "TESTE DISPOSITIVO")
    )
}