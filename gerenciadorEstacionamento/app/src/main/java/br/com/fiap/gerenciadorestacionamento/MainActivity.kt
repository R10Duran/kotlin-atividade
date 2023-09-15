package br.com.fiap.gerenciadorestacionamento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.gerenciadorestacionamento.screens.LoginScreen
import br.com.fiap.gerenciadorestacionamento.screens.MenuScreen
import br.com.fiap.gerenciadorestacionamento.screens.vagasDisponiveisScreen
import br.com.fiap.gerenciadorestacionamento.screens.cadastraVeiculoScreen
import br.com.fiap.gerenciadorestacionamento.screens.vagasOcupadasScreen
import br.com.fiap.gerenciadorestacionamento.screens.veiculoCadastradoScreen
import br.com.fiap.gerenciadorestacionamento.ui.theme.GerenciadorEstacionamentoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GerenciadorEstacionamentoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }
                        composable(route = "cadastra") { cadastraVeiculoScreen(navController) }
                        composable(route = "cadastrados") { veiculoCadastradoScreen(navController) }
                        composable(route = "vagasDisponiveis") { vagasDisponiveisScreen(navController) }
                        composable(route = "vagasOcupadas") { vagasOcupadasScreen(navController) }
                    }
                }
            }
        }
    }
}
