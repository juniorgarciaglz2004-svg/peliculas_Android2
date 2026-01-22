package Datos;

import android.widget.Toast;

import java.util.ArrayList;

import Modelo.Pelicula;
import Modelo.PelisICONOS;

public class RepositorioPeliculasSingleton {
    private static final RepositorioPeliculasSingleton instancia = new RepositorioPeliculasSingleton();
    private ArrayList<Pelicula> peliculas;
    private RepositorioPeliculasSingleton() {
    this.peliculas=new ArrayList<>();
    this.peliculas.add(new Pelicula("123","Alien","En una nave espacial se infiltra un criatura" ,"Frank Miller",2013, PelisICONOS.ACCION));
    this.peliculas.add(new Pelicula("456","Vengadores","Cuando un enemigo inesperado surge como una gran amenaza para la seguridad mundial, Nick Fury, director de la Agencia SHIELD, decide reclutar a un equipo para salvar al mundo de un desastre casi seguro." ,"Joe Russo",2010 ,PelisICONOS.SCIFI));
    this.peliculas.add(new Pelicula("789","Piratas Del Caribe","El capitán Barbossa le roba el barco al pirata Jack Sparrow y secuestra a Elizabeth," ,"Rob Marshall",2015 ,PelisICONOS.PIRATA));
    }

    public static RepositorioPeliculasSingleton getInstancia()
    {
        return instancia;
    }

    public void adicionar(Pelicula pelicula){
        peliculas.add(pelicula);
    }

    public boolean eliminar(String id)
    {
        int indice = peliculaPorID(id);

        if(indice>=0)
        {
            peliculas.remove(indice);
            return true;
        }
        else {
            return false;
        }

    }

    public int peliculaPorID(String id)
    {
        for (int i = 0 ; i < peliculas.size() ; i++ )
        {
            if (id.equalsIgnoreCase(peliculas.get(i).getId()))
            {

                return i;
            }
        }
        return  -1;
    }

    public int tamanno() {
        return peliculas.size();
    }

    public Pelicula elemento(int i)
    {
        return peliculas.get(i);
    }

    public void actualizar(int indice , Pelicula pelicula) {
    peliculas.set(indice,pelicula);
    }


}
