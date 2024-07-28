package ir.erfansn.composepagereffects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.erfansn.composepagereffects.ui.theme.ComposePagerEffectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePagerEffectsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PagersScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PagersScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PlainHorizontalPager()
        }
        item {
            ScaledHorizontalPager()
        }
        item {
            ClosingTranslationHorizontalPager()
        }
        item {
            DirectiveRotationStackHorizontalPager()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PagersScreenPreview() {
    ComposePagerEffectsTheme {
        PagersScreen()
    }
}