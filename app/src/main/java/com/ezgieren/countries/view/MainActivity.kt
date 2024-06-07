package com.ezgieren.countries.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    @Composable
    fun NavGraph(startDestination: String = "home") {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = startDestination) {
            composable("home") { HomeScreen(navController) }
            composable("details") { DetailScreen() }
        }
    }

    @Composable
    fun HomeScreen(navController: NavHostController) {
        Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.End){
            Text("Home Screen")
            Button(onClick = { navController.navigate("details") }) {
                Text("Go to Details")
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Text("Detail Screen")
    }

    @Preview
    @Composable
    fun PreviewNavGraph() {
        NavGraph()
    }
}