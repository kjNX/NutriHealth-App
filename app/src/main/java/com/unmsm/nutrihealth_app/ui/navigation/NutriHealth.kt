package com.unmsm.nutrihealth_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class NutriHealth {
    Onboarding,
    Login,
    Setup,
    Main,
    Dashboard,
    Profile,
    FoodHistory,
    ActivityHistory,
    Settings
}

@Composable
fun NutriHealthNav(modifier: Modifier = Modifier) {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = NutriHealth.Onboarding.name) {
        composable() {

        }
    }
}