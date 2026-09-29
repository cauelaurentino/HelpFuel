package com.example.helpfuel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class estimarAutonomia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estimar_autonomia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun estimarAutonomiaTanque(view: View) {
        val litrosRestantes = findViewById<EditText>(R.id.litrosRestantes).text.toString().toDoubleOrNull() // DÚVIDA: Pq eu tenho que transformar em uma string primeiro dps em double??
        val mediaVeiculo = findViewById<EditText>(R.id.mediaVeiculo).text.toString().toDoubleOrNull()
        val resultadoEstimado = findViewById<TextView>(R.id.resultadoEstimado)

        if (litrosRestantes != null && mediaVeiculo != null && litrosRestantes > 0.0 && mediaVeiculo > 0.0) {
            val resultado = litrosRestantes * mediaVeiculo
            resultadoEstimado.text = String.format("Média: %.2f", resultado)
        } else {
            // Popup na tela:
            Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_SHORT).show()
        }
    }

}