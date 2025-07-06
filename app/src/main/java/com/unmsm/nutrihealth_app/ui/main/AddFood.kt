package com.unmsm.nutrihealth_app.ui.screen.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddFood(onExit: () -> Unit, modifier: Modifier = Modifier) {
    AlertDialog(
        onDismissRequest = onExit,
        confirmButton = {

        },
        dismissButton = {

        },
        title = { Text(text = "Agregar comida") },
        text = {
            Column {
                TextField(value = "", onValueChange = { }, label = { Text("Nombre") })
                TextField(value = "", onValueChange = { }, label = { Text("Calorías") })
                TextField(value = "", onValueChange = { }, label = { Text("Proteínas") })
                TextField(value = "", onValueChange = { }, label = { Text("Carbohidratos") })
                TextField(value = "", onValueChange = { }, label = { Text("Grasas") })
            }
        }
    )
}