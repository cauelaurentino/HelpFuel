package com.example.helpfuel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mantemos apenas o comando essencial que desenha a tela inicial
        setContentView(R.layout.activity_main)
    }

    fun abrirTelaMedia(view: View){
        val telaMedia = Intent(this, calcularMedia::class.java)
        startActivity(telaMedia)
    }

    fun abrirTelaAutonomia(view: View){
        val telaAutonomia = Intent(this, estimarAutonomia::class.java)
        startActivity(telaAutonomia)
    }

    fun abrirTelaTanque(view: View){
        val telaTanque = Intent(this, calcularTanque::class.java)
        startActivity(telaTanque)
    }
}