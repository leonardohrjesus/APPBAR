package org.business.lhrjesus.feature.filter

import VideoPlayer
import VideoPlayerScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import appbar.composeapp.generated.resources.Res
import appbar.composeapp.generated.resources.icon_instagram
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.painterResource

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

           EventDetailScreen(navigateToMapsScreen)
            //AboutComponent("Leonardo", "MONSTRO",onBackPressed)

        }
    }

}


@Composable
fun VideoScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Preenche a largura
            .height(200.dp) // Define a altura do Box
            .padding(16.dp), // Adiciona padding ao redor do Box
        contentAlignment = Alignment.Center // Centraliza o conteúdo dentro do Box
    ) {

        VideoPlayer(
            modifier = Modifier,
            url = "https://www.youtube.com/watch?v=n5wxZ_OBUXk&list=RDn5wxZ_OBUXk&start_radio=1",
            autoPlay = false,
            showControls = true,
        )
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


@Composable
fun EventDetailScreen(navigateToMapsScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Banner Image

        AsyncImage(
            model = "https://lh3.googleusercontent.com/p/AF1QipOdntTx9QXDxQtZ5tXJVOC4lCEPT5LSsV24aaE2=s1360-w1360-h1020",
            contentDescription = "imagem",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillBounds // ou ContentScale.FillWidth se quiser mostrar tudo
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Event Information
        Text(
            text = "Pagode do Japa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {

            Row(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "Bar 567 ",
                    fontSize = 14.sp
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        navigateToMapsScreen.invoke()
                    }
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Ícone de localização",
                    tint = Color.Black,
                )
                Text(
                    text = "R. Aspicuelta, 567 - Vila Madalena",
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

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                InstagramIcon()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                VideoScreen()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Lógica de compra */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = "Comprar Ingresso")
                }
            }

        }


        Spacer(modifier = Modifier.height(50.dp))

    }
}

@Composable
fun InstagramIcon() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                // Ação ao clicar no ícone do Instagram
            }
    ) {
        Image(
            painter = painterResource(Res.drawable.icon_instagram),
            contentDescription = "Ícone do Instagram",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Siga-nos no Instagram",
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 12.sp,
            color = Color.Black
        )
    }

}




