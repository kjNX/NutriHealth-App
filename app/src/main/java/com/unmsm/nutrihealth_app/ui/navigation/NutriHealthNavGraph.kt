package com.unmsm.nutrihealth_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.unmsm.nutrihealth_app.ui.auth.AuthExport
import com.unmsm.nutrihealth_app.ui.main.MainExport
import com.unmsm.nutrihealth_app.ui.onboarding.OnboardingComposite
import com.unmsm.nutrihealth_app.ui.profile.ProfileExport
import com.unmsm.nutrihealth_app.ui.settings.SettingsExport
import com.unmsm.nutrihealth_app.ui.setup.SetupComposite

enum class NutriHealthNavGraph {
    Onboarding,
    Auth,
    Setup,
    Main,
    Dashboard,
    Profile,
    FoodHistory,
    ActivityHistory,
    Messaging,
    Scan,
    Settings
}

@Composable
fun NutriHealthNavGraph(modifier: Modifier = Modifier) {
    var navController = rememberNavController()

    val goto = { route: String -> navController.navigate(route) }

    val uid = Firebase.auth.currentUser

    val starting =
        if(uid == null) NutriHealthNavGraph.Onboarding.name
        else NutriHealthNavGraph.Main.name

    NavHost(
        navController = navController,
        startDestination = starting,
        modifier = modifier
    ) {
        composable(NutriHealthNavGraph.Onboarding.name) {
            OnboardingComposite(onExit = { goto(NutriHealthNavGraph.Auth.name) })
        }
        composable(NutriHealthNavGraph.Auth.name) {
            AuthExport(onSuccessfulAuth = { goto(NutriHealthNavGraph.Main.name) })
        }
        composable(NutriHealthNavGraph.Setup.name) {
            SetupComposite(onSetupFinish = { goto(NutriHealthNavGraph.Main.name) })
        }
        composable(NutriHealthNavGraph.Main.name) {
            MainExport()
        }
        composable(NutriHealthNavGraph.Dashboard.name) {
            TODO()
        }
        composable(NutriHealthNavGraph.Profile.name) {
            ProfileExport()
        }
        composable(NutriHealthNavGraph.FoodHistory.name) {
            TODO()
        }
        composable(NutriHealthNavGraph.ActivityHistory.name) {
            TODO()
        }
        composable(NutriHealthNavGraph.Messaging.name) {
            TODO()
        }
        composable(NutriHealthNavGraph.Settings.name) {
            SettingsExport()
        }
    }
}