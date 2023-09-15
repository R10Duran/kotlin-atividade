package br.com.fiap.gerenciadorestacionamento.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.Visibility
import androidx.navigation.NavController
import br.com.fiap.gerenciadorestacionamento.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var isDialogVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth()
                .shadow(5.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "LogiCar",
                fontSize = 46.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )

            Text(text = "Login: fiap", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text(text = "Senha: 123456", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuário") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha") },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Mostrar/Ocultar Senha"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (username == "fiap" && password == "123456") {
                        navController.navigate("menu")
                    } else {
                        isDialogVisible = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xFF87CEEB),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Entrar",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (isDialogVisible) {
            AlertDialog(
                onDismissRequest = { isDialogVisible = false },
                title = { Text(text = "Erro") },
                text = { Text("Para fazer o login use no usuario: fiap e na senha: 123456") },
                confirmButton = {
                    Button(onClick = { isDialogVisible = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
