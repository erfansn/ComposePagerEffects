package ir.erfansn.composepagereffects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.erfansn.composepagereffects.ui.theme.ComposePagerEffectsTheme
import kotlin.math.absoluteValue
import kotlin.math.sign

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClosingTranslationHorizontalPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 1) { 10 }
    PaddingAroundHorizontalPagerWithTitle(
        title = "Closing Translation",
        pagerState = pagerState,
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Red)
                .graphicsLayer {
                    val translationXEffectValue = pagerState.translationXEffectValue(it)
                    translationX = translationXEffectValue
                }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Page $it"
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun PagerState.translationXEffectValue(page: Int) =
    (50 * currentPageOffsetFraction.absoluteValue) * getOffsetFractionForPage(page).sign

@Preview(showBackground = true)
@Composable
private fun ClosingTranslationHorizontalPagerPreview() {
    ComposePagerEffectsTheme {
        ClosingTranslationHorizontalPager()
    }
}
