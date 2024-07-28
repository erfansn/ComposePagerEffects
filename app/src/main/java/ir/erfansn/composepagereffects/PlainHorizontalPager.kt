package ir.erfansn.composepagereffects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.erfansn.composepagereffects.ui.theme.ComposePagerEffectsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlainHorizontalPager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(initialPage = 1) { 10 }
    PaddingAroundHorizontalPagerWithTitle(
        title = "Plain",
        pagerState = pagerState,
        modifier = modifier,
    ) {
        PlainPage(
            pageIndex = it,
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PlainHorizontalPagerPreview() {
    ComposePagerEffectsTheme {
        PlainHorizontalPager()
    }
}
