package com.unmsm.nutrihealth_app.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unmsm.nutrihealth_app.model.live.Actor
import com.unmsm.nutrihealth_app.util.trick.randomColor

private val contactList = listOf(
    Actor("Entrenador", "Entrenador personal", ""),
    Actor("Asistente", "Asistente médico", "")
)

@Composable
fun NonPicturedIcon(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(64.dp)
            .background(
                color = randomColor(),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name.first().toString(), fontSize = 32.sp)
    }
}

@Composable
fun ContactItem(actor: Actor, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NonPicturedIcon(actor.name)
        Column {
            Text(text = actor.name, style = MaterialTheme.typography.titleMedium)
            Text(text = actor.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun MessagingPage(actorList: List<Actor>, onSelect: (Int) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(actorList) { ContactItem(it, modifier) }
    }
}
