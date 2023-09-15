package br.com.fiap.gerenciadorestacionamento.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Texto "Menu" adicionado aqui
            Text(
                text = "Menu",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MenuBlock(title = "Veículos Cadastrados") {
                    navController.navigate("cadastrados")
                }
                MenuBlock(title = "Cadastrar Veículo") {
                    navController.navigate("cadastra")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MenuBlock(title = "Vagas Disponíveis") {
                    navController.navigate("vagasDisponiveis")
                }
                MenuBlock(title = "Vagas Ocupadas") {
                    navController.navigate("vagasOcupadas")
                }
            }
        }
    }
}

@Composable
fun MenuBlock(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(150.dp, 150.dp)
            .background(Color(0xFF87CEEB), shape = RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .shadow(4.dp, shape = RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center // Isto garantirá que o Text esteja centralizado
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center, // Alinha o texto ao centro
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        )
    }
}
