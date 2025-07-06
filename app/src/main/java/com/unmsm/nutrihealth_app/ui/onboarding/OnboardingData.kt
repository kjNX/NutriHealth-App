package com.unmsm.nutrihealth_app.ui.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton

data class OnboardingData(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
    val onClick: (() -> Unit)? = null
) {
    @Composable
    fun Page(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            if(onClick != null) LabeledButton("Comenzar", onClick)
        }
    }
}
