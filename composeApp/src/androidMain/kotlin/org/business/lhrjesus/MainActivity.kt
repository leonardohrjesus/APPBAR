package org.business.lhrjesus

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap
import org.business.lhrjesus.main.App
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            )
        )




        setContent {
            App()

        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}


@SuppressLint("UnrememberedMutableState")
@Composable
actual fun GoogleMapScreen(modifier: Modifier) {
    val saoPaulo = LatLng(-23.55800716129896, -46.690647939636925)
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(saoPaulo, 12f)
    }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = saoPaulo),
            title = "Rua Aspicuelta , 567 ",
            snippet = "Bar Vila 567!"
        )
    }
}





