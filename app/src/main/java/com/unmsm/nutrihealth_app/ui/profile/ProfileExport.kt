package com.unmsm.nutrihealth_app.ui.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileExport(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        ProfileComposite(modifier = modifier.padding(innerPadding))
    }
}