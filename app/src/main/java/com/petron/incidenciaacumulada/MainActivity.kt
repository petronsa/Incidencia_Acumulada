package com.petron.incidenciaacumulada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonCalcular.setOnClickListener { incidenciaAcumulada2() }



    }
    // Función que hace el calculo de la incidencia acumulada
    fun incidenciaAcumulada2() {
        val numeroContagios = Integer.parseInt (editTextNumberContagios.getText().toString()).toDouble()
        val poblacion = Integer.parseInt(editTextNumberPoblacion.getText().toString())
        var calcular : Double = (numeroContagios / poblacion) * 100000
        var calcularformat = (String.format("%.2f",calcular))
        textViewResultados.setText(calcularformat)

        fun envioDatos(): String {
            return calcularformat
        }



    }

    // Sobreescribimos la función y llamamos al menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }
    // Funciones del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            // Llamada a compartir haber como exporto la variable que quiero enviar
            R.id.compartir -> {
                // Sacamos el dato de incidencia de textView
                var envio = textViewResultados.getText()

                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    // Mandomos un texto y dentro la varible con la incidencia acumulada
                    putExtra(Intent.EXTRA_TEXT, "Incidencia acumulada $envio" )
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }

            // Llamada al boton salir
            R.id.salir -> {
                finish()
            }

        }



        return super.onOptionsItemSelected(item)
    }


}