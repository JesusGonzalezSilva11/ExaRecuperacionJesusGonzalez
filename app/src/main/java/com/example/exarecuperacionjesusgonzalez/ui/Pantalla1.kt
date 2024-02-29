package com.example.examen1viewmodel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.examen1viewmodel.data.Asignatura
import com.example.examen1viewmodel.data.DataSource
import com.example.exarecuperacionjesusgonzalez.data.UIState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla1(
    modifier: Modifier = Modifier,
    asignaturas: ArrayList<Asignatura> = DataSource.asignaturas,
    onClickCambiarPantalla: () -> Unit,
    viewModel: ViewModel,
    uiState: UIState
) {

    Column() {
        Text(
            text = "Bienvenido a la academia de Jesús González",
            modifier = modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                //.weight(0.25f)
                .padding(start = 20.dp, top = 50.dp)
        )
        AsignaturasScroll(
            modifier,
            asignaturas,
            viewModel,
            uiState,
        )

        /*TextFieldHoras(
            viewModel,
            uiState,
        )*/
        TextoActualizandose(modifier, uiState)

        Button(
            onClick = onClickCambiarPantalla,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Cambiar de pantalla")
        }
    }
}


/*
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TextFieldHoras(viewModel: ViewModel, uiState: UIState) {
    TextField(
        value = uiState.cantidadHoras,
        singleLine = true,
        modifier = Modifier
            .padding(16.dp)
        /*onValueChange = {viewModel.setHorasTexto(it)},
        label = { Text("Horas a contratar o eliminar") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        )*/
    )
}
*/
@Composable
private fun TextoActualizandose(
    modifier: Modifier,
    uiState: UIState,

    ) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Ultima acción:",
        )
        Text(
            text = uiState.textoAccion,
        )
        Text(
            "Resumen:",
        )
        Text(
            text = uiState.textoResumen,
        )
        Text(
            text = "Total horas: "+uiState.totalHoras,
        )
        Text(
            text = "Total precio: "+uiState.totalPrecio,
        )
    }
}

@Composable
private fun AsignaturasScroll(
    modifier: Modifier,
    asignaturas: ArrayList<Asignatura>,
    viewModel: ViewModel,
    uiState: UIState,

    ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(asignaturas) { asignatura ->
            Card(
                modifier = modifier
                    .padding(8.dp)
                    .width(250.dp)
            ) {
                Text(
                    text = "Asig: ${asignatura.nombre}",
                    modifier = Modifier
                        .background(Color.Yellow)
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                Text(
                    text = "€/hora: ${asignatura.precioHora.toString()}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Cyan)
                        .padding(20.dp)
                )
                Row{
                    Button(
                        onClick =
                        {
                            viewModel.pagar(
                                asignatura.nombre,
                                uiState.cantidadHoras,
                                uiState.mas
                            )
                        },
                        modifier = Modifier
                            .padding(16.dp,8.dp,0.dp,8.dp)
                    ) {
                        Text(text = "+")
                    }
                    Button(
                        onClick =
                        {
                            viewModel.pagar(
                                asignatura.nombre,
                                uiState.cantidadHoras,
                                uiState.menos
                            )
                        },
                        modifier = Modifier
                            .padding(0.dp,8.dp,16.dp,8.dp)
                    ) {
                        Text(text = "-")
                    }
                }

            }
        }
    }
}

