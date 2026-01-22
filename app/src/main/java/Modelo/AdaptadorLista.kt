package Modelo

import Datos.RepositorioPeliculasSingleton
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R


class AdaptadorLista(val contexto: Context,
                     val inflador: LayoutInflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    : RecyclerView.Adapter<AdaptadorLista.CreadorPeliculas>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorPeliculas {

        val v = inflador.inflate(
            R.layout.activity_ver_lista,
            parent, false)
        return CreadorPeliculas(v)
    }

    override fun onBindViewHolder(
        holder: CreadorPeliculas,
        position: Int
    ) {
        val pelicula = RepositorioPeliculasSingleton.getInstancia().elemento(position)
        holder.titulo.text = pelicula.titulo
        holder.id.text = pelicula.id
        holder.anno.text =  pelicula.anno.toString()
        holder.sinopsis.text = pelicula.sinopsis
        val draw = AppCompatResources.getDrawable(
            holder.view.context, pelicula.icono.id)
            holder.icono.setImageDrawable(draw)

    }

    override fun getItemCount(): Int {
        return RepositorioPeliculasSingleton.getInstancia().tamanno()
    }

    class CreadorPeliculas(
        val view: View,
        val titulo: TextView = view.findViewById(R.id.Titulo),
        val id: TextView = view.findViewById(R.id.peliculaId),
        val anno: TextView = view.findViewById(R.id.annotxt),
        val sinopsis: TextView = view.findViewById(R.id.sinopsis),
        val icono : ImageView = view.findViewById<ImageView>(R.id.iconoGenero)
    ) : RecyclerView.ViewHolder(view)






    }











