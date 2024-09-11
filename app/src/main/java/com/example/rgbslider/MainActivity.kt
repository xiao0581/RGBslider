package com.example.rgbslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rgbslider.ui.theme.RGBsliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RGBsliderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SliderSample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun regnerv2() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(



    ) { innerPadding ->
        SliderSample(modifier = Modifier.padding(innerPadding))
    }

}
@Composable
fun SliderSample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var sliderPosition by remember { mutableFloatStateOf(0f) }
        var sliderPosition2 by remember { mutableFloatStateOf(0f) }
        var sliderPosition3 by remember { mutableFloatStateOf(0f) }
        val color = Color(
            red = sliderPosition.toInt() ,
            green = sliderPosition2.toInt() ,
            blue = sliderPosition3.toInt()
        )
        Text(text = "RED")
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it} ,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),

            valueRange = 0f..255f
        )
        Text(text = "green")
        Slider(
            value = sliderPosition2,
            onValueChange = { sliderPosition2 = it} ,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),

            valueRange = 0f..255f
        )
        Text(text = "blue")
        Slider(
            value = sliderPosition3,
            onValueChange = { sliderPosition3 = it} ,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 2,
            valueRange = 0f..255f
        )
        Text(
            text = "RGB",
            modifier = Modifier
                .background(color)
                .padding(50.dp)
                .wrapContentHeight(),

        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderSamplePreview() {
    SliderSample()
}
