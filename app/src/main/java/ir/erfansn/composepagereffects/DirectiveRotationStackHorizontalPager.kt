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
import androidx.compose.ui.zIndex
import ir.erfansn.composepagereffects.ui.theme.ComposePagerEffectsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DirectiveRotationStackHorizontalPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 1) { 10 }
    PaddingAroundHorizontalPagerWithTitle(
        title = "Directive Rotation Stack",
        pagerState = pagerState,
        modifier = modifier
    ) {
        PlainPage(
            pageIndex = it,
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Blue)
                .graphicsLayer {
                    val rotationZEffectValue = pagerState.rotationEffectValue(it)
                    rotationZ = rotationZEffectValue
                    rotationY = rotationZEffectValue
                }
                .zIndex(pagerState.pageCount - it.toFloat())
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun PagerState.rotationEffectValue(page: Int) =
    15f * getOffsetFractionForPage(page)

@Preview(showBackground = true)
@Composable
private fun DirectiveRotationStackHorizontalPagerPreview() {
    ComposePagerEffectsTheme {
        DirectiveRotationStackHorizontalPager()
    }
}
