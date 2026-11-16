package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RowColDemoTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = lightColorScheme(), content = content)
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Row(modifier) {
        Text(text = "Large Text\n\nMore Text", modifier = Modifier.alignBy(FirstBaseline), fontSize = 40.sp,
            fontWeight = FontWeight.Bold)
        Text(text = "Small Text", modifier = Modifier.alignByBaseline(),
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {
    val cellModifier = modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)
    Text(text = text, modifier = cellModifier, fontSize = 80.sp,
        fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
}

@Preview(name = "Phone", showBackground = true)
@Preview(name = "Wide 1000 dp", showBackground = true, widthDp = 1000, heightDp = 400)
@Composable
fun MainScreenPreview() {
    RowColDemoTheme { MainScreen() }
}
