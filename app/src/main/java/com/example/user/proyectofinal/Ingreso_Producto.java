package com.example.user.proyectofinal;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Ingreso_Producto extends AppCompatActivity {

    private EditText cajaModelo;
    private EditText cajaSerie;
    private EditText cajaDescripcion;
    private EditText cajaCliente;
    private Spinner comboModelo;
    private ArrayAdapter<String> adapter;
    private String[] opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso__producto);

        cajaModelo = (EditText)findViewById(R.id.txtModelo);
        cajaSerie = (EditText)findViewById(R.id.txtSerie);
        cajaDescripcion = (EditText)findViewById(R.id.txtDescripcion);
        cajaCliente = (EditText)findViewById(R.id.txtClientePro);
        comboModelo=(Spinner)findViewById(R.id.cmbModelo);
        opc=this.getResources().getStringArray(R.array.modelos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);

        comboModelo.setAdapter(adapter);
    }

    public boolean buscarExistente(){
        Producto g;
        if(validarSerie()) {
            g = Datos.buscarPrestamo(getApplicationContext(), cajaSerie.getText().toString());
            if(g!=null){
                cajaSerie.setError(getResources().getString(R.string.error7_1));
                cajaSerie.requestFocus();
                return false;
            }
        }
        return true;
    }

    public int fotoseleccionada(int numero){
        int foto[]={R.drawable.be350glm,R.drawable.bge50ml,R.drawable.br24bpg,R.drawable.ups1000,R.drawable.ups1300,R.drawable.ups1500};
        return foto[numero];
    }

    public void guardarPro(View v){
        String  foto, serie, modelo, descripcion, cliente;
        int numero=0;
        Producto p;

        if(validarTodo() && buscarExistente()){
            serie = cajaSerie.getText().toString();
            modelo = comboModelo.getSelectedItem().toString();
            descripcion = cajaDescripcion.getText().toString();
            cliente = cajaCliente.getText().toString();

            if (modelo.equalsIgnoreCase(getResources().getString(R.string.be350glm))){
                numero=0;
            }
            if (modelo.equalsIgnoreCase(getResources().getString(R.string.bge50ml))){
                numero=1;
            }
            if (modelo.equalsIgnoreCase(getResources().getString(R.string.br24bpg))){
                numero=2;
            }
            if (modelo.equalsIgnoreCase(getResources().getString(R.string.ups1000))){
                numero=3;
            }
            if (modelo.equalsIgnoreCase(getResources().getString(R.string.ups1300))){
                numero=4;
            }
            if (modelo.equalsIgnoreCase(getResources().getString(R.string.ups1500))){
                numero=5;
            }

            foto = String.valueOf(fotoseleccionada(numero));




            p = new Producto(foto, serie, modelo, descripcion, cliente);
            p.guardarPro(getApplicationContext());

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.pguardado),
                    Toast.LENGTH_SHORT).show();

            limpiar();
        }
    }





    public boolean validarTodo(){

        if(cajaSerie.getText().toString().isEmpty()){
            cajaSerie.setError(getResources().getString(R.string.error_7));
            cajaSerie.requestFocus();
            return false;
        }
        if(cajaDescripcion.getText().toString().isEmpty()){
            cajaDescripcion.setError(getResources().getString(R.string.error_15));
            cajaDescripcion.requestFocus();
            return false;
        }
        if(cajaCliente.getText().toString().isEmpty()){
            cajaCliente.setError(getResources().getString(R.string.error_2));
            cajaCliente.requestFocus();
            return false;
        }

        return  true;
    }


    public boolean validarSerie() {
        if (cajaSerie.getText().toString().isEmpty()) {
            cajaSerie.setError(getResources().getString(R.string.error_7));
            cajaSerie.requestFocus();
            return false;
        }
        return true;
    }

    public void borrar(View v){limpiar();}

    public void limpiar(){
        cajaSerie.setText("");
        comboModelo.setSelection(0);
        cajaDescripcion.setText("");
        cajaCliente.setText("");
        cajaSerie.requestFocus();
    }

    public void buscar(View v){
        Producto p;

        if(validarSerie()) {
            p = Datos.buscarPrestamo(getApplicationContext(), cajaSerie.getText().toString());
            if(p!=null){
                cajaSerie.setText(p.getSerie());
                cajaDescripcion.setText(p.getDescripcion());
                cajaCliente.setText(p.getCliente());

                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.be350glm))){
                    comboModelo.setSelection(0);
                }
                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.bge50ml))){
                    comboModelo.setSelection(1);
                }
                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.br24bpg))){
                    comboModelo.setSelection(2);
                }
                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.ups1000))){
                    comboModelo.setSelection(3);
                }
                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.ups1300))){
                    comboModelo.setSelection(4);
                }
                if (p.getModelo().toString().equalsIgnoreCase(getResources().getString(R.string.ups1500))){
                    comboModelo.setSelection(5);
                }
            }
        }
    }

    public void modificar(View v){
        Producto c,c2;
        String serie, modelo, descripcion, cliente;
        if(validarSerie()) {
            c = Datos.buscarPrestamo(getApplicationContext(), cajaSerie.getText().toString());
            if(c!=null){

                serie = cajaSerie.getText().toString();
                modelo = comboModelo.getSelectedItem().toString();
                descripcion = cajaDescripcion.getText().toString();
                cliente = cajaCliente.getText().toString();


                c2 = new Producto(serie, modelo, descripcion, cliente);
                c2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.registro2),
                        Toast.LENGTH_SHORT).show();

                limpiar();
            }
        }
    }

    public void eliminar(View v){
        Producto c;
        if(validarSerie()) {
            c = Datos.buscarPrestamo(getApplicationContext(), cajaSerie.getText().toString());
            if(c!=null){
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle(getResources().getString(R.string.confirmacion));
                ventana.setMessage(getResources().getString(R.string.mensaje1));
                ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Producto c;
                        c = Datos.buscarPrestamo(getApplicationContext(), cajaSerie.getText().toString());
                        c.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje2),
                                Toast.LENGTH_SHORT).show();

                    }
                });

                ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cajaSerie.requestFocus();
                    }
                });

                ventana.show();
            }
        }
    }


}
