package com.unmsm.nutrihealth_app.ui.shard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Composable
fun ScreenTracker(
    current: Int,
    max: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Paso ${current + 1} de $max")
        Spacer(Modifier.height(4.dp))
        Row(modifier = Modifier.height(5.dp)) {
            repeat(max - 1) {
                Column(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color = if (it <= current) Color.Green else Color.Gray))
                {}
                Spacer(Modifier.width(4.dp))
            }

            Column(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = if (current == max - 1) Color.Green else Color.Gray))
            {}
        }
    }
}

@Composable
fun LabeledProgressBar(
    title: String,
    value: Float,
    modifier: Modifier = Modifier,
    maxValue: Float = 1f,
    evaluation: (Float) -> String = { "${(it * 100).toInt()}%" }
) {
    val proportion = value / maxValue
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title)
            Text(text = evaluation(proportion))
        }
        LinearProgressIndicator({ proportion }, modifier = Modifier.fillMaxWidth().height(8.dp))
    }
}