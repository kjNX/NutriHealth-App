package com.unmsm.nutrihealth_app.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unmsm.nutrihealth_app.R
import com.unmsm.nutrihealth_app.ui.shard.LabeledButton
import com.unmsm.nutrihealth_app.ui.auth.AuthViewModel

@Composable
fun AuthComposite(
    isLogin: Boolean,
    name: String,
    email: String,
    password: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSwitch: () -> Unit,
    onSuccessfulAuth: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo_nutrihealth),
            contentDescription = null,
            modifier = Modifier
                .width(96.dp)
        )
        Text(
            text = "Bienvenido a NutriHealth",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        LoginInformationColumn(
            isLogin = isLogin,
            name = name,
            email = email,
            password = password,
            onNameChange = onNameChange,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange
        )
        Spacer(Modifier.height(8.dp))
        LabeledButton(
            title = "Iniciar sesión",
            onClick = onSuccessfulAuth
        )
        AnotherLoginRow(icons, loginName, onLoginSelect)
        LoginSelect(isLogin, onSwitch)
    }
}
