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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.gerenciadorestacionamento.model.Veiculo
import br.com.fiap.gerenciadorestacionamento.screens.veiculosCadastrados

@Composable
fun veiculoCadastradoScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,  // Alinhando todos os elementos no centro horizontalmente
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Veículos Cadastrados", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(veiculosCadastrados) { veiculo ->
                    VeiculoCard(veiculo)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun VeiculoCard(veiculo: Veiculo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Placa: ${veiculo.placa}")
            Text(text = "Cor: ${veiculo.cor}")
            Text(text = "Nome: ${veiculo.nome}")
            Text(text = "Data e Hora: ${veiculo.dataHora}")
            Text(text = "Vaga Ocupada: ${veiculo.vagaOcupada}")
        }
    }
}
