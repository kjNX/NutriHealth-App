package com.unmsm.nutrihealth_app.ui.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.unmsm.nutrihealth_app.R

@Composable
fun OnboardingComposite(onExit: () -> Unit, modifier: Modifier = Modifier) {
    val onboardingList = listOf(
        OnboardingData(
            title = "Bienvenido a NutriHealth",
            description = "Tu asistente personal para alcanzar tus objetivos de salud y fitness",
            image = R.drawable.logo_nutrihealth
        ),
        OnboardingData(
            title = "Seguimiento completo",
            description = "Registra tu alimentación, actividad física y progreso en un solo lugar",
            image = R.drawable.logo_nutrihealth
        ),
        OnboardingData(
            title = "Personalizado para ti",
            description = "Recibe recomendaciones adaptadas a tus objetivos y preferencias",
            image = R.drawable.logo_nutrihealth,
            onClick = onExit
        )
    )
    val pagerState = rememberPagerState { onboardingList.size }

    HorizontalPager(modifier = modifier, state = pagerState) { page ->
        onboardingList[page].Page(modifier = Modifier.fillMaxSize())
    }
}
