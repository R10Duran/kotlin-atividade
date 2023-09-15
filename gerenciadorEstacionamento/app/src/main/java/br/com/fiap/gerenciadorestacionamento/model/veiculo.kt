package br.com.fiap.gerenciadorestacionamento.model

data class Veiculo(
    val placa: String,
    val cor: String,
    val nome: String,
    val dataHora: String,
    val vagaOcupada: String
)