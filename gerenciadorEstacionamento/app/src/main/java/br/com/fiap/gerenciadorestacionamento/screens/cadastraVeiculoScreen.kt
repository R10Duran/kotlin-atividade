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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import br.com.fiap.gerenciadorestacionamento.model.Veiculo
import br.com.fiap.gerenciadorestacionamento.screens.veiculosCadastrados


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cadastraVeiculoScreen(navController: NavController) {
    var placa by remember { mutableStateOf("") }
    var cor by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var dataHora by remember { mutableStateOf("") }
    var vagaOcupada by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,  // Alinhando todos os elementos no centro horizontalmente
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar Veículo", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = placa, onValueChange = { placa = it }, label = { Text("Placa") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = cor, onValueChange = { cor = it }, label = { Text("Cor") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome do Veículo") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = dataHora, onValueChange = { dataHora = it }, label = { Text("Data e Horário") })
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = vagaOcupada, onValueChange = { vagaOcupada = it }, label = { Text("Vaga Ocupada") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val veiculo = Veiculo(placa, cor, nome, dataHora, vagaOcupada)
                    veiculosCadastrados.add(veiculo)
                    navController.navigate("cadastrados")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor  = Color(0xFF87CEEB),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 32.dp)  // Adiciona padding horizontal para aumentar o tamanho do botão
                    .align(Alignment.CenterHorizontally)  // Alinha o botão no centro horizontalmente
            ) {
                Text(text = "Cadastrar Veículo")
            }
        }
    }
}
