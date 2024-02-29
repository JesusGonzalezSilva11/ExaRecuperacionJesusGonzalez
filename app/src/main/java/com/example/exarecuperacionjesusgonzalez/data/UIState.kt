package com.example.exarecuperacionjesusgonzalez.data

data class UIState(
    val cantidadHoras: String = "1",
    val totalHoras: Int = 0,
    val totalPrecio: Int = 0,
    val textoAccion: String ="No has hecho ninguna accion",
    val textoResumen: String ="No hay nada que mostrar(defecto)",
    val mas: String = "+",
    val menos: String = "-",
)