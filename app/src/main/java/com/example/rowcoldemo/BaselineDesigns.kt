package com.example.rowcoldemo

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/** Lecture figure 18: the small first baseline meets the large last baseline. */
@Composable
fun LastBaselineScreen(modifier: Modifier = Modifier) {
    Row(modifier) {
        Text(text = "Large Text\n\nMore Text", modifier = Modifier.alignBy(LastBaseline),
            fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Text(text = "Small Text", modifier = Modifier.alignByBaseline(),
            fontSize = 32.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(name = "26 - LastBaseline", showBackground = true, widthDp = 411)
@Composable
fun LastBaselineScreenPreview() {
    RowColDemoTheme { LastBaselineScreen() }
}

/** Lecture figure 19: both first baselines share the same vertical position. */
@Composable
fun FirstBaselineScreen(modifier: Modifier = Modifier) {
    Row(modifier) {
        Text(text = "Large Text\n\nMore Text", modifier = Modifier.alignBy(FirstBaseline),
            fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Text(text = "Small Text", modifier = Modifier.alignByBaseline(),
            fontSize = 32.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(name = "27 - FirstBaseline", showBackground = true, widthDp = 411)
@Composable
fun FirstBaselineScreenPreview() {
    RowColDemoTheme { FirstBaselineScreen() }
}
