package com.example.user.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Clientes extends AppCompatActivity {

    private ListView opciones;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        opciones = (ListView)findViewById(R.id.lsClientes);
        opc = getResources().getStringArray(R.array.clientes);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opciones.setAdapter(adapter);
        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Clientes.this,Ingresar_Cliente.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Clientes.this,Lista_Clientes.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
