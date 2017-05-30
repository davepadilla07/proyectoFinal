package com.example.user.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 30/5/2017.
 */

public class Crea_Cliente {

    private String tipo;
    private String nitced;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private String ciudad;

    public Crea_Cliente(String tipo, String nitced, String nombre, String telefono, String correo, String direccion, String ciudad) {
        this.tipo = tipo;
        this.nitced = nitced;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Crea_Cliente(String nitced, String nombre, String telefono, String correo, String direccion, String ciudad) {
        this.nitced = nitced;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNitced() {
        return nitced;
    }

    public void setNitced(String nitced) {
        this.nitced = nitced;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void guardarCli(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_ClienteSQLiteOpenHelper  aux = new Crear_ClienteSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO clientes values('"+this.getTipo()+"','"+this.getNitced()+"','"+this.getNombre()+"','"+this.getTelefono()+"','"+this.getCorreo()+"','"+this.getDireccion()+"','"+this.getCiudad()+"')";

        db.execSQL(sql);
        db.close();
    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_ClienteSQLiteOpenHelper  aux = new Crear_ClienteSQLiteOpenHelper (contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE clientes SET nitced='"+this.getNitced()+"', nombre='"+this.getNombre()+"', telefono='"+this.getTelefono()+"', " + "correo='" +this.getCorreo()+"', " + "direccion='" +this.getDireccion()+"', " + "ciudad='" +this.getCiudad()+"'";

        db.execSQL(sql);
        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_ClienteSQLiteOpenHelper  aux = new Crear_ClienteSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM clientes where nitced='"+this.getNitced()+"'";
        db.execSQL(sql);
        db.close();

    }


}
