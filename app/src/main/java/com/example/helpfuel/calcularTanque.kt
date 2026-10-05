package com.example.helpfuel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class calcularTanque : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcular_tanque)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularEncherTanque(view: View) {
        val litroTanque = findViewById<EditText>(R.id.litroTanque).text.toString().toDoubleOrNull()
        val valorGasolina = findViewById<EditText>(R.id.valorGasolina).toString().toDoubleOrNull()
        val resultadoTanque = findViewById<TextView>(R.id.resultadoTanque)

        if (litroTanque != null && valorGasolina != null && litroTanque > 0.0 && valorGasolina > 0.0) {
            val resultado = valorGasolina * litroTanque
            resultadoTanque.text = String.format("Valor: %.2f km/L", resultado)
        }
    }
}