package com.example.helpfuel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    val botaoMedia = findViewById<Button>(R.id.calcularMedia)
    val botaoEstimador = findViewById<Button>(R.id.estimarAutonomia)
    val botaoTanque = findViewById<Button>(R.id.calcularTanque)

    fun abrirTelaMedia(view: View){
        val telaMedia = Intent(this, calcularMedia::class.java)
        startActivity(telaMedia)
    }

    fun abrirTelaTanque(view: View){
        val telaAutonomia = Intent(this, estimarAutonomia::class.java)
        startActivity(telaAutonomia)
    }

    fun abrirTelaAutonomia(view: View){
        val telaTanque = Intent(this, calcularTanque::class.java)
        startActivity(telaTanque)
    }
}