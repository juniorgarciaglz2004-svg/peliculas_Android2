package com.example.myapplication

import Datos.RepositorioPeliculasSingleton
import Modelo.Pelicula
import Modelo.PelisICONOS
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Editar : AppCompatActivity() {
    var indice: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        indice = intent.extras?.getInt("indice")?: 0
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
     val id =   findViewById<TextView>(R.id.txtid)
     val titulo =   findViewById<TextView>(R.id.txttitulo)
     val anno =   findViewById<TextView>(R.id.txtanno)
     val sinopsis =   findViewById<TextView>(R.id.Sinopsis)

     val pelicula =  RepositorioPeliculasSingleton.getInstancia().elemento(this.indice)

        id.text  =pelicula.id
        titulo.text  =pelicula.titulo
        anno.text  =  pelicula.anno.toString()
        sinopsis.text  =pelicula.sinopsis
        val comboGenero = findViewById<Spinner>(R.id.comboboxGenero)

        val opciones = PelisICONOS.entries.map { it.name }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            opciones
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        comboGenero.adapter = adapter
        val posicion = adapter.getPosition(pelicula.icono.name)

        comboGenero.setSelection(posicion)

        findViewById<Button>(R.id.bGuardar).setOnClickListener {

            val pelicula = Pelicula()
            pelicula.id = id.text.toString()
            pelicula.titulo = titulo.text.toString()
            pelicula.anno =  Integer.valueOf(anno.text.toString())
            pelicula.sinopsis = sinopsis.text.toString()
            pelicula.icono = PelisICONOS.valueOf(comboGenero.selectedItem.toString())



            RepositorioPeliculasSingleton.getInstancia().actualizar(this.indice,pelicula)
            //Toast.makeText(this, "Pelicula adicionada", Toast.LENGTH_LONG).show()
            finish()

        }

        findViewById<Button>(R.id.bCancelar).setOnClickListener {
            finish()
        }

    }




}