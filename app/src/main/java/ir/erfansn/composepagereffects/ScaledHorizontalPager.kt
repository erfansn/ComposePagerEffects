package ir.erfansn.composepagereffects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import ir.erfansn.composepagereffects.ui.theme.ComposePagerEffectsTheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScaledHorizontalPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 1) { 10 }
    PaddingAroundHorizontalPagerWithTitle(
        title = "Scaled",
        pagerState = pagerState,
        modifier = modifier
    ) {
        PlainPage(
            pageIndex = it,
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Blue)
                .graphicsLayer {
                    val scale = pagerState.scaleEffectValue(it)
                    scaleX = scale
                    scaleY = scale
                }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun PagerState.scaleEffectValue(pageIndex: Int) = lerp(
    start = 0.9f,
    stop = 1f,
    fraction = 1f - getOffsetFractionForPage(pageIndex).absoluteValue.coerceIn(0f, 1f)
)

@Preview(showBackground = true)
@Composable
private fun ScaledHorizontalPagerPreview() {
    ComposePagerEffectsTheme {
        ScaledHorizontalPager()
    }
}
