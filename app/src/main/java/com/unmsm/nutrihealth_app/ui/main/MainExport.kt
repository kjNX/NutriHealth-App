package com.unmsm.nutrihealth_app.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unmsm.nutrihealth_app.R
import com.unmsm.nutrihealth_app.ui.shard.IconButton
import com.unmsm.nutrihealth_app.util.icon.Analytics
import com.unmsm.nutrihealth_app.util.icon.History
import com.unmsm.nutrihealth_app.util.icon.Scan
import kotlinx.coroutines.launch

val nbiIcons = listOf(Icons.Default.Home, Icons.Default.Email, Icons.Default.LocationOn)
val nbiLabels = listOf("Inicio", "Mensajería", "Caminatas")

// EXCEPCIÓN: Dado que main tiene un topbar distinto, lo definimos en export.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 20.sp) },
        navigationIcon = {
            Image(
                painter = painterResource(R.drawable.logo_nutrihealth),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        },
        actions = {
            Row {
                IconButton(icon = Analytics, contentDescription = "Ajustes", onClick = {})
                IconButton(icon = History, contentDescription = "Ajustes", onClick = {})
                IconButton(icon = Icons.Default.Settings, contentDescription = "Ajustes", onClick = {})
            }
        }
    )
}

@Composable
fun FAB() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        SmallFloatingActionButton({}) {
            Icon(imageVector = Icons.Default.Create, contentDescription = "Registrar comida")
        }
        FloatingActionButton({}) {
            Icon(imageVector = Scan, contentDescription = "Escanear comida")
        }
    }
}

@Composable
fun NavBar(currentPage: Int, onClick: (Int) -> Unit) {
    NavigationBar {
        for(i in 0..<3) {
            NavigationBarItem(
                selected = i == currentPage,
                onClick = { onClick(i) },
                icon = { Icon(imageVector = nbiIcons[i], contentDescription = null) },
                label = { Text(text = nbiLabels[i]) }
            )
        }
    }
}

@Composable
fun MainExport(modifier: Modifier = Modifier) {
    var pagerState = rememberPagerState { 3 }
    var coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MainTopBar() },
        floatingActionButton = { FAB() },
        bottomBar = { NavBar(
            currentPage = pagerState.currentPage,
            onClick = { coroutineScope.launch { pagerState.animateScrollToPage(it) } }) }
    ) { innerPadding ->
        MainComposite(pagerState = pagerState, modifier = modifier.padding(innerPadding))
    }
}

@Preview
@Composable
private fun Preview() {
    MainExport()
}