package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.based_lib.theme.MyApplicationTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    ProvideWindowInsets {
        Column {
            Scaffold(
                modifier = Modifier.weight(1f),
                topBar = { MyTopAppBar() },
                isFloatingActionButtonDocked = true,
                floatingActionButton = { MyFloatingButton() }
            ) {
                Surface(modifier = Modifier.fillMaxWidth()
                    .background(color = MaterialTheme.colors.background)) {
//                    MainView(Modifier.weight(1f))
                }
            }
            Spacer(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.primaryVariant)
                    .fillMaxWidth()
                    .navigationBarsPadding()
            )
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CardSurface(
                color = MaterialTheme.colors.primary,
                text = "Primary"
            )
            Spacer(modifier = Modifier.size(16.dp))
            CardSurface(
                color = MaterialTheme.colors.primaryVariant,
                text = "Primary Variant"
            )
            Spacer(modifier = Modifier.size(16.dp))
            CardSurface(
                color = MaterialTheme.colors.secondary,
                text = "Secondary"
            )
            Spacer(modifier = Modifier.size(16.dp))
            CardSurface(
                color = MaterialTheme.colors.secondaryVariant,
                text = "Secondary Variant"
            )
            Spacer(modifier = Modifier.size(16.dp))
            CardSurface(
                color = MaterialTheme.colors.error,
                text = "Error"
            )
        }
    }
}

@Composable
fun ColumnScope.CardSurface(color: Color, text: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        color = color
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text)
        }
    }
}

@Composable
fun MyTopAppBar() {
    Column {
        Spacer(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .statusBarsPadding()
        )
        TopAppBar(
            title = { Text("Title", color = MaterialTheme.colors.onPrimary) },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun MyFloatingButton() {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = {
    }) {
        Text("X")
    }
}