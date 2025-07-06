package com.unmsm.nutrihealth_app.ui.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.unmsm.nutrihealth_app.model.ItemLog

/*

README OBLIGATORIO

Este Screen define el framework para un historial.
El cual utiliza el composable definido para una implementación de la interfaz ItemLog

SE DEBE IMPLEMENTAR LA INTERFAZ ITEMLOG PARA PODER UTILIZAR ESTE HISTORIAL

 */

@Composable
fun<T: ItemLog> HistoryScreen(itemLogs: List<T>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(itemLogs) { it.GetItemRow() }
    }
}