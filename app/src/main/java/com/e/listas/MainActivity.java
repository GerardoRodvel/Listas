package com.e.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //VARIABLES
    ListView list_View;
    ArrayAdapter<String> arrayAdapter;
    int indice = 0;
    String countryList[]={ "India", "Mexico","Japon","EUA", "Francia", "Africa"};
    final ArrayList<String> lista = new ArrayList<String>(Arrays.asList(countryList));
    Button btn_Agregar;
    Button btn_Edit_Apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Agregar = findViewById(R.id.btn_Agregar);
        btn_Edit_Apply = findViewById(R.id.btn_Edit_Apply);
        list_View = findViewById(R.id.list_View);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview, R.id.txt_Palabra, lista);
        list_View.setAdapter(arrayAdapter);
        btn_Edit_Apply.setVisibility(View.GONE);
    }
    //METODOS
    public void agregar(View view) {
        final TextView txtagregar = findViewById(R.id.txt_Campo);
        String palabra = txtagregar.getText().toString();
        lista.add(palabra);
        Toast.makeText(this,"AGREGADO",Toast.LENGTH_SHORT).show();
        arrayAdapter.notifyDataSetChanged();
    }

    public void eliminar(View view) {
        View item = (View) view.getParent();
        int pos = list_View.getPositionForView(item);
        lista.remove(pos);
        Toast.makeText(this,"ELIMINADO",Toast.LENGTH_SHORT).show();
        arrayAdapter.notifyDataSetChanged();
    }

    public void editar(View view) {
        Toast.makeText(this,"EDITANDO",Toast.LENGTH_SHORT).show();
        View item = (View) view.getParent();
        int pos = list_View.getPositionForView(item);
        btn_Agregar.setVisibility(View.GONE);
        btn_Edit_Apply.setVisibility(View.VISIBLE);
        indice = pos;
    }

    public void aplicar(View view) {
        final TextView txtagregar = findViewById(R.id.txt_Campo);
        String palabra = txtagregar.getText().toString();
        lista.set(indice, palabra);
        arrayAdapter.notifyDataSetChanged();
        btn_Edit_Apply.setVisibility(View.GONE);
        btn_Agregar.setVisibility(View.VISIBLE);
        Toast.makeText(this,"GUARDADO",Toast.LENGTH_SHORT).show();

    }
}
