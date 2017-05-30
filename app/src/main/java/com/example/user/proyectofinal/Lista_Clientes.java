package com.example.user.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista_Clientes extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Crea_Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__clientes);

        tabla=(TableLayout)findViewById(R.id.tblClientes);
        clientes = Datos.traerCliente(getApplicationContext());

        for (int i = 0; i < clientes.size(); i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);
            TextView c8 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(clientes.get(i).getTipo());
            c3.setText(clientes.get(i).getNitced());
            c4.setText(clientes.get(i).getNombre());
            c5.setText(clientes.get(i).getTelefono());
            c6.setText(clientes.get(i).getCorreo());
            c7.setText(clientes.get(i).getDireccion());
            c8.setText(clientes.get(i).getCiudad());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);
            fila.addView(c8);

            tabla.addView(fila);

        }
    }
}
