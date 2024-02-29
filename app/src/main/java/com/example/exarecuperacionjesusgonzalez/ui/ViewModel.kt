package com.example.examen1viewmodel.ui

import androidx.lifecycle.ViewModel
import com.example.examen1viewmodel.data.DataSource
import com.example.exarecuperacionjesusgonzalez.data.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()
    private val asignaturas = DataSource.asignaturas

    fun setAsignatura(escritoEnAsignaturanombre: String) {
        _uiState.update { currentState ->
            currentState.copy(
                textoAccion = escritoEnAsignaturanombre
            )
        }

    }

    fun setHoras(escritoEnHoras: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                totalHoras = escritoEnHoras
            )
        }
    }

    fun setHorasTexto(escritoEnHoras: String) {
        _uiState.update { currentState ->
            currentState.copy(
                cantidadHoras = escritoEnHoras
            )
        }
    }

    fun pagar(nombre: String, cantidadHoras: String, accion: String) {
        if (accion.equals("+")){
            setHoras(_uiState.value.totalHoras+cantidadHoras.toInt())
            setAsignatura("Se han añadido "+cantidadHoras+" de "+nombre+" a "/*+ asignaturas[asignaturas.indexOf(nombre)].precioHora+"€"*/)
        }else{
            if (_uiState.value.totalHoras-cantidadHoras.toInt()<0){
                setHoras(0)
            }else{
                setHoras(_uiState.value.totalHoras-cantidadHoras.toInt())
            }
            setAsignatura("Se han eliminado "+cantidadHoras+" de "+nombre+" a "/*+ asignaturas[asignaturas.indexOf(nombre)].precioHora+"€"*/)
        }
    }
}

