package com.example.helpfuel

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class calcularTanque : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensorProximidade: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcular_tanque)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorProximidade = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

    }

    override fun onResume() {
        super.onResume()
        // Liga o sensor quando o utilizador está a olhar para a tela
        sensorProximidade?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Desliga para poupar a bateria do Moto G1
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            val distancia = event.values[0]
            val alcanceMaximo = sensorProximidade?.maximumRange ?: 0f

            // Se o valor lido for menor que o máximo, significa que tapou o sensor
            if (distancia < alcanceMaximo) {
                finish() // Encerra esta tela e a MainActivity volta a aparecer
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Obrigatório existir, mas fica vazio
    }

    fun calcularEncherTanque(view: View) {
        val litroTanque = findViewById<EditText>(R.id.litroTanque).text.toString().toDoubleOrNull()
        val valorGasolina = findViewById<EditText>(R.id.valorGasolina).text.toString().toDoubleOrNull()
        val resultadoTanque = findViewById<TextView>(R.id.resultadoTanque)

        if (litroTanque != null && valorGasolina != null && litroTanque > 0.0 && valorGasolina > 0.0) {
            val resultado = valorGasolina * litroTanque
            resultadoTanque.text = String.format("Valor: R$ %.2f", resultado)
        }
    }
}