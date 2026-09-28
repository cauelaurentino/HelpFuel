package com.example.helpfuel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class calcularMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcular_media)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    val kmRodado = findViewById<EditText>(R.id.kmRodado)
    val litrosCondumidos = findViewById<EditText>(R.id.litrosConsumidos)
    val mediaConsumo = findViewById<TextView>(R.id.mediaConsumo)

    fun calcularMedia(view: View) {
        val resultado = kmRodado / litrosCondumidos
    }
}