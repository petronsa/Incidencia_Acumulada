package com.petron.incidenciaacumulada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonCalcular.setOnClickListener { incidenciaAcumulada2() }
    }

    fun incidenciaAcumulada2(){
        val numeroContagios = Integer.parseInt (editTextNumberContagios.getText().toString()).toDouble()
        val poblacion = Integer.parseInt(editTextNumberPoblacion.getText().toString())
        var calcular : Double = (numeroContagios / poblacion) * 100000
        textViewResultados.setText(String.format("%.2f",calcular))

    }
}