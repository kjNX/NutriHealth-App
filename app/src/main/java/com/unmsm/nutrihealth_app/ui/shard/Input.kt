package com.unmsm.nutrihealth_app.ui.shard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun EnhancedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: ImageVector? = null,
    placeholder: String? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = if(icon == null) null else { -> Icon(imageVector = icon, contentDescription = null) },
        placeholder = if(placeholder == null) null else { -> Text(text = placeholder) },
        visualTransformation = visualTransformation,
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            disabledIndicatorColor = MaterialTheme.colorScheme.outline
        )
    )
}

@Composable
fun LabeledSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    icon: ImageVector? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconLabel(title = title, subtitle = subtitle, icon = icon)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun LabeledButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    Button(onClick = onClick, modifier = modifier) {
        if(icon != null) Icon(imageVector = icon, contentDescription = null)
        Text(text = title)
    }
}

/*@Composable
fun LabeledButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int
) {
    Button(onClick = onClick, modifier = modifier) {
        Icon(painter = painterResource(icon), contentDescription = null)
        Text(text = title)
    }
}*/

@Composable
fun IconButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
//    bgColor: Color
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = icon, contentDescription = contentDescription)
    }
}

@Composable
fun WideButtonGroup(
    selectedIndex: Int,
    options: List<String>,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(modifier = modifier.fillMaxWidth()) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { onSelect(index) },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

@Composable
fun RadioGroup(
    selected: Int,
    options: List<String>,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.selectableGroup()) {
        options.forEachIndexed { index, value ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = index == selected,
                        onClick = { onSelect(index) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = index == selected,
                    onClick = null
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
