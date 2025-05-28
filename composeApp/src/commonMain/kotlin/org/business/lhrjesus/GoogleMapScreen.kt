package org.business.lhrjesus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun GoogleMapScreen(modifier: Modifier = Modifier, nome : String,  endereco:String)