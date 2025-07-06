package com.unmsm.nutrihealth_app.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.unmsm.nutrihealth_app.R

// EXCEPCIÓN: Dado que main tiene un topbar distinto, lo definimos en export.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        navigationIcon = {
            Image(
                painter = painterResource(R.drawable.logo_nutrihealth),
                contentDescription = null
            )
        },
        modifier = modifier
    )
}

@Composable
fun MainExport(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { MainTopBar() }
    ) { innerPadding ->
        MainComposite(modifier = modifier.padding(innerPadding))
    }
}