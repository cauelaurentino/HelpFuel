package com.example.helpfuel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calcularMedia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Deixamos apenas o comando essencial que carrega o visual da tela
        setContentView(R.layout.activity_calcular_media)
    }

    fun calcularMediaConsumo(view: View) {
        val kmRodado = findViewById<EditText>(R.id.kmRodado).text.toString().toDoubleOrNull()
        val litrosConsumidos = findViewById<EditText>(R.id.litrosConsumidos).text.toString().toDoubleOrNull()
        val mediaConsumo = findViewById<TextView>(R.id.mediaConsumo)

        if (kmRodado != null && litrosConsumidos != null && litrosConsumidos > 0.0) {
            val resultado = kmRodado / litrosConsumidos
            mediaConsumo.text = String.format("Média: %.2f km/L", resultado)
    }
}
}