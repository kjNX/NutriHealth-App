package com.unmsm.nutrihealth_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmsm.nutrihealth_app.ui.screen.page.AccountSettings
import com.unmsm.nutrihealth_app.ui.screen.page.AppliSettings
import kotlinx.coroutines.launch
import kotlinx.serialization.internal.throwMissingFieldException

val tabList = listOf(@Composable { -> AccountSettings() }, @Composable { -> AppliSettings() })
val nameList = listOf("Cuenta", "Aplicación")
val iconList = listOf(Icons.Default.Person, Icons.Default.Info)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var pagerState = rememberPagerState { tabList.size }
    var coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier) {
        PrimaryTabRow(pagerState.currentPage) {
            for (i in 0..<tabList.size)
                Tab(
                    selected = i == pagerState.currentPage,
                    onClick = {
                        if (i == pagerState.currentPage) coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                i
                            )
                        }
                    },
                    text = { Text(text = nameList[i]) },
                    icon = { Icon(imageVector = iconList[i], contentDescription = null) }
                )
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
        ) { tabList[it]() }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SettingsScreen()
}
