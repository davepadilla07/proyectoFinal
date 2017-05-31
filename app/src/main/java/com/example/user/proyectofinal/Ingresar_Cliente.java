package com.example.user.proyectofinal;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingresar_Cliente extends AppCompatActivity {


    private EditText cajaNitCed;
    private EditText cajaNombre;
    private EditText cajaTelefono;
    private EditText cajaCorreo;
    private EditText cajaDireccion;
    private EditText cajaCiudad;
    private RadioButton rdNit;
    private RadioButton rdCedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar__cliente);

        rdNit= (RadioButton)findViewById(R.id.r1);
        rdCedula= (RadioButton)findViewById(R.id.r2);

        cajaNitCed = (EditText)findViewById(R.id.txtNitCed);
        cajaNombre = (EditText)findViewById(R.id.txtNombreCliente);
        cajaTelefono = (EditText)findViewById(R.id.txtTelefonoCliente);
        cajaCorreo = (EditText)findViewById(R.id.txtCorreoCliente);
        cajaDireccion = (EditText)findViewById(R.id.txtDireccionCliente);
        cajaCiudad = (EditText)findViewById(R.id.txtCiudadCliente);
    }

    public boolean buscarExistente(){
        Crea_Cliente g;
        if(validarNitCed()) {
            g = Datos.buscarCliente(getApplicationContext(), cajaNitCed.getText().toString());
            if(g!=null){
                cajaNitCed.setError(getResources().getString(R.string.error2_1));
                cajaNitCed.requestFocus();
                return false;
            }
        }
        return true;
    }

    public void guardarCli(View v){
        String  tipo, nitced, nombre, telefono, correo, direccion, ciudad;
        Crea_Cliente c;

        if(validarTodo() && buscarExistente()){


            nitced = cajaNitCed.getText().toString();
            nombre = cajaNombre.getText().toString();
            telefono = cajaTelefono.getText().toString();
            correo = cajaCorreo.getText().toString();
            direccion = cajaDireccion.getText().toString();
            ciudad = cajaCiudad.getText().toString();

            if(rdNit.isChecked()) tipo = getResources().getString(R.string.nit);
            else tipo = getResources().getString(R.string.cedula);

            c = new Crea_Cliente(tipo, nitced, nombre, telefono, correo, direccion, ciudad);
            c.guardarCli(getApplicationContext());

            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje_9),
                    Toast.LENGTH_SHORT).show();

            limpiar();
        }
    }

    public boolean validarTodo(){
        if(cajaNitCed.getText().toString().isEmpty()){
            cajaNitCed.setError(getResources().getString(R.string.error_9));
            cajaNitCed.requestFocus();
            return false;
        }
        if(cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(getResources().getString(R.string.error_10));
            cajaNombre.requestFocus();
            return false;
        }
        if(cajaTelefono.getText().toString().isEmpty()){
            cajaTelefono.setError(getResources().getString(R.string.error_11));
            cajaTelefono.requestFocus();
            return false;
        }
        if(cajaCorreo.getText().toString().isEmpty()){
            cajaCorreo.setError(getResources().getString(R.string.error_12));
            cajaCorreo.requestFocus();
            return false;
        }
        if (!isEmailValid(cajaCorreo.getText().toString())){
            cajaCorreo.setError(getResources().getString(R.string.error4_1));
            cajaCorreo.requestFocus();
            return false;
        }
        if(cajaDireccion.getText().toString().isEmpty()){
            cajaDireccion.setError(getResources().getString(R.string.error_13));
            cajaDireccion.requestFocus();
            return false;
        }
        if(cajaCiudad.getText().toString().isEmpty()){
            cajaCiudad.setError(getResources().getString(R.string.error_14));
            cajaCiudad.requestFocus();
            return false;
        }

        return true;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public boolean validarNitCed(){
        if(cajaNitCed.getText().toString().isEmpty()){
            cajaNitCed.setError(getResources().getString(R.string.error_9));
            cajaNitCed.requestFocus();
            return false;
        }

        return true;
    }

    public void borrar(View v){limpiar();}

    public void limpiar(){
        rdNit.setChecked(true);
        cajaNitCed.setText("");
        cajaNombre.setText("");
        cajaTelefono.setText("");
        cajaCorreo.setText("");
        cajaDireccion.setText("");
        cajaCiudad.setText("");
        cajaNitCed.requestFocus();

    }

    public void buscar(View v){
        Crea_Cliente c;
        if(validarNitCed()) {
            c = Datos.buscarCliente(getApplicationContext(), cajaNitCed.getText().toString());
            if(c!=null){
                if(rdNit.isChecked()) rdNit.setChecked(true);
                else rdCedula.setChecked(true);
                cajaNitCed.setText(c.getNitced());
                cajaNombre.setText(c.getNombre());
                cajaTelefono.setText(c.getTelefono());
                cajaCorreo.setText(c.getCorreo());
                cajaDireccion.setText(c.getDireccion());
                cajaCiudad.setText(c.getCiudad());
            }
        }
    }

    public void modificar(View v){
        Crea_Cliente c,c2;
        String nitced, nombre, telefono, correo, direccion, ciudad;
        if(validarNitCed()) {
            c = Datos.buscarCliente(getApplicationContext(), cajaNitCed.getText().toString());
            if(c!=null){

                nitced = cajaNitCed.getText().toString();
                nombre = cajaNombre.getText().toString();
                telefono = cajaTelefono.getText().toString();
                correo = cajaCorreo.getText().toString();
                direccion = cajaDireccion.getText().toString();
                ciudad = cajaCiudad.getText().toString();

                c2 = new Crea_Cliente(nitced, nombre, telefono, correo, direccion, ciudad);
                c2.modificar(getApplicationContext());

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.registro2),
                        Toast.LENGTH_SHORT).show();

                limpiar();
            }
        }
    }

    public void eliminar(View v){
        Crea_Cliente c;
        if(validarNitCed()) {
            c = Datos.buscarCliente(getApplicationContext(), cajaNitCed.getText().toString());
            if(c!=null){
                AlertDialog.Builder ventana = new AlertDialog.Builder(this);
                ventana.setTitle(getResources().getString(R.string.confirmacion));
                ventana.setMessage(getResources().getString(R.string.mensaje1));
                ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Crea_Cliente c;
                        c = Datos.buscarCliente(getApplicationContext(), cajaNitCed.getText().toString());
                        c.eliminar(getApplicationContext());
                        limpiar();
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.mensaje2),
                                Toast.LENGTH_SHORT).show();

                    }
                });

                ventana.setNegativeButton(getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cajaNitCed.requestFocus();
                    }
                });

                ventana.show();
            }
        }
    }

}
