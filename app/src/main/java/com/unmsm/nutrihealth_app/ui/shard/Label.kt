package com.unmsm.nutrihealth_app.ui.shard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconLabel(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    icon: ImageVector? = null
) {
    val textLabel = if(subtitle.isEmpty()) @Composable { modifier: Modifier ->
        Text(text = title, style = MaterialTheme.typography.titleMedium)
    } else @Composable { modifier: Modifier -> Column {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        Text(text = subtitle, style = MaterialTheme.typography.labelMedium)
    } }

    if(icon == null) textLabel(modifier)
    else Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null)
        textLabel(Modifier)
    }
}

@Composable
fun KeyDefinitions(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    icon: ImageVector? = null,
    extra: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconLabel(title = title, subtitle = subtitle, icon = icon)
        extra()
    }
}

@Composable
fun KeyIndicator(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconLabel(title = title, icon = icon)
        Text(text = value)
    }
}

@Composable
fun IndexLabel(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    KeyDefinitions(
        title = title,
        subtitle = subtitle,
        modifier = modifier,
        extra = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Go"
                )
            }
        }
    )
}