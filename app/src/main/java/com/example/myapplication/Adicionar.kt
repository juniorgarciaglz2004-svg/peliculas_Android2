package com.example.myapplication

import Datos.RepositorioPeliculasSingleton
import Modelo.Pelicula
import Modelo.PelisICONOS
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Adicionar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_annadir_elementos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = findViewById<EditText>(R.id.txtid)
        val titulo = findViewById<EditText>(R.id.txttitulo)
        val anno = findViewById<EditText>(R.id.txtanno)
        val sinopsis = findViewById<EditText>(R.id.Sinopsis)
        val comboGenero = findViewById<Spinner>(R.id.comboboxGenero)

        val opciones = PelisICONOS.entries.map { it.name }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            opciones
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        comboGenero.adapter = adapter


        findViewById<Button>(R.id.bGuardar).setOnClickListener {

            val pelicula = Pelicula()
            pelicula.id = id.text.toString()
            pelicula.titulo = titulo.text.toString()
            pelicula.anno =  Integer.valueOf(anno.text.toString())
            pelicula.sinopsis = sinopsis.text.toString()
            pelicula.icono = PelisICONOS.valueOf(comboGenero.selectedItem.toString())

            RepositorioPeliculasSingleton.getInstancia().adicionar(pelicula)
            //Toast.makeText(this, "Pelicula adicionada", Toast.LENGTH_LONG).show()
            finish()

        }

        findViewById<Button>(R.id.bCancelar).setOnClickListener {
            finish()
        }


    }
}