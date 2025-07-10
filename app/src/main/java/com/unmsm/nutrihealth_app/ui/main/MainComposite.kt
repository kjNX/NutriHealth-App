package com.unmsm.nutrihealth_app.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainComposite(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    HorizontalPager(pagerState) {
        when(it) {
            1 -> { MessagingPage(listOf(), {}) }
            2 -> { MessagingPage(listOf(), {}) }
            3 -> { MessagingPage(listOf(), {}) }
        }
    }
}