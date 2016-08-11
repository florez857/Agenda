package com.example.android.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView lista;
    ArrayAdapter<String> adaptador;
    ArrayList<String> datos;
    ArrayList<Contacto> ListaContactos;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        datos=new ArrayList<>();
        ListaContactos=new ArrayList<>();
        lista=(ListView) findViewById(R.id.VistaLista);
         swipe=(SwipeRefreshLayout)findViewById(R.id.swipe);
        for(int i=0;i<20;i++){
            Contacto contacto=new Contacto("florez@gmail.com","3265+65+","alfredo");
            datos.add(contacto.getNombre());
            ListaContactos.add(contacto);
        }


        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               new  Handler().postDelayed(
                new Runnable() {
                    @Override public void run() {
                        swipe.setRefreshing(false);
                    }
                }, 5000);


            }
        });

        adaptador=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adaptador);

       lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               Intent intent=new Intent(getApplication(),DetalleActivity.class);

               intent.putExtra("Nombre",ListaContactos.get(i).getNombre());
               intent.putExtra("Telefono",ListaContactos.get(i).getTelefono());
               intent.putExtra("Mail",ListaContactos.get(i).getMail());
               startActivity(intent);

               Snackbar.make(view,"click",Snackbar.LENGTH_LONG).show();
           }
       });

    }
}
