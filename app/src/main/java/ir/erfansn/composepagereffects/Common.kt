package ir.erfansn.composepagereffects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaddingAroundHorizontalPagerWithTitle(
    title: String,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    pageContent: @Composable PagerScope.(page: Int) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(4.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .height(240.dp),
            pageSpacing = 12.dp,
            contentPadding = PaddingValues(horizontal = 48.dp),
            pageContent = pageContent
        )
    }
}

@Composable
fun PlainPage(
    pageIndex: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Page $pageIndex"
            )
        }
    }
}
