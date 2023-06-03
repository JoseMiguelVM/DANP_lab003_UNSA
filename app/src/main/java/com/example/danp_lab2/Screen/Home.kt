package com.example.danp_lab2.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp_lab2.R

@Composable
fun HomeView(navCotroller: NavHostController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 30.dp),
                color = Color.White,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.school),
                        contentDescription = "Descripción de la imagen",
                        modifier = Modifier.size(150.dp)
                    )

                    Text(
                        text = "Gestion Academica Administrativa",
                        color = Color.Black
                    )
                    Button(onClick = { navCotroller.navigate("courseRegister") }) {
                        Text(text = "Registrar una Materia")
                    }

                    Button(onClick = { navCotroller.navigate("studentRegister") }) {
                        Text(text = "Registrar un Alumno")
                    }

                    Button(onClick = { navCotroller.navigate("list") }) {
                        Text(text = "Listar Datos")
                    }
                }
            }
        }
    }
}