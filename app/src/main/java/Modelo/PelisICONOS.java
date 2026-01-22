package Modelo;

import com.example.myapplication.R;

public enum PelisICONOS {

    HISTORIA(R.drawable.historia),

    ACCION(R.drawable.accion),

    SCIFI(R.drawable.scifi),

    PIRATA(R.drawable.pirata),

    ROMANTICO(R.drawable.romantico),

    GUERRA(R.drawable.guerra);

int id ;

    PelisICONOS(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
