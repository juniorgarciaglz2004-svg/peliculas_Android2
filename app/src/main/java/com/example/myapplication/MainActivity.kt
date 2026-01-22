package com.example.myapplication

import CasosDeUso.AppController
import Datos.RepositorioPeliculasSingleton
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var controlador: AppController
    override fun onCreate(savedInstanceState: Bundle?) {
        controlador = AppController(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.boton_verLista).setOnClickListener {
        controlador.verLista()

        }


        findViewById<Button>(R.id.button_Editar).setOnClickListener {
            dialogoEditar()

        }

        findViewById<Button>(R.id.button_Eliminar).setOnClickListener {
            dialogoElegir()

        }

        findViewById<Button>(R.id.adicionar).setOnClickListener {
            controlador.adicionar()

        }




    }
    fun dialogoEditar() {
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_TEXT
        AlertDialog.Builder(this)
            .setTitle("Editar Pelicula")
            .setMessage("Teclee ID")
            .setView(entrada)
            .setPositiveButton("Editar") { dialog, which ->
                val id = entrada.text.toString()
                val indice =RepositorioPeliculasSingleton.getInstancia().peliculaPorID(id)

                if (indice>=0) {
                    controlador.editar(indice)
                } else {
                    Toast.makeText(this, "No se ha encontrado", Toast.LENGTH_LONG).show()
                }

            }
            .setNegativeButton("Cancelar", null)
            .show()
    }


    fun dialogoElegir() {
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_TEXT
        AlertDialog.Builder(this)
            .setTitle("Eliminar Pelicula")
            .setMessage("Teclee ID")
            .setView(entrada)
            .setPositiveButton("Eliminar") { dialog, which ->
                val id = entrada.text.toString()
                val resultado = RepositorioPeliculasSingleton.getInstancia().eliminar(id)

                if (resultado) {
                    Toast.makeText(this, "Eliminado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "No se ha encontrado", Toast.LENGTH_LONG).show()
                }

            }

            .setNegativeButton("Cancelar", null)
            .show()
    }

}