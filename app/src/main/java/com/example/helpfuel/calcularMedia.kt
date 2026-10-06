package com.example.helpfuel

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calcularMedia : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensorProximidade: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Deixamos apenas o comando essencial que carrega o visual da tela
        setContentView(R.layout.activity_calcular_media)

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