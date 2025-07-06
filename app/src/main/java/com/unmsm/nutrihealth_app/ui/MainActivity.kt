package com.unmsm.nutrihealth_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.unmsm.nutrihealth_app.ui.navigation.NutriHealthNavGraph
import com.unmsm.nutrihealth_app.ui.setup.SetupComposite
import com.unmsm.nutrihealth_app.ui.theme.NutriHealthAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { NutriHealthAppTheme { NutriHealthNavGraph() } }
    }
}