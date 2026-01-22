package CasosDeUso;

import android.content.Context;
import android.content.Intent;

import com.example.myapplication.Editar;
import com.example.myapplication.Lista;
import com.example.myapplication.Adicionar;

public class AppController {

    private final Context context;

    public AppController(Context context) {
        this.context = context;
    }

    public void verLista () {
        Intent intent = new Intent(context, Lista.class);
        context.startActivity(intent);
    }

    public void editar (int indice) {
        Intent intent = new Intent(context, Editar.class);
        intent.putExtra("indice", indice);
        context.startActivity(intent);
    }

    public void adicionar () {
        Intent intent = new Intent(context, Adicionar.class);
        context.startActivity(intent);
    }




}
