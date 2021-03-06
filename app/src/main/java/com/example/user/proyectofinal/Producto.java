package com.example.user.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 22/5/2017.
 */

public class Producto {

    private String foto;
    private String serie;
    private String modelo;
    private String Descripcion;
    private String cliente;

    public Producto(String foto, String serie, String modelo, String descripcion, String cliente) {
        this.foto = foto;
        this.serie = serie;
        this.modelo = modelo;
        this.Descripcion = descripcion;
        this.cliente = cliente;
    }

    public Producto(String serie, String modelo, String descripcion, String cliente) {

        this.serie = serie;
        this.modelo = modelo;
        this.Descripcion = descripcion;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void guardarPro(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        ProductoSQLiteOpenHelper aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO prestamos values('"+this.getFoto()+"','"+this.getSerie()+"','"+this.getModelo()+"','"+this.getDescripcion()+"','"+this.getCliente()+"')";

        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        ProductoSQLiteOpenHelper  aux = new ProductoSQLiteOpenHelper (contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE prestamos SET serie='"+this.getSerie()+"', modelo='"+this.getModelo()+"', descripcion='"+this.getDescripcion()+"', " + "cliente='" +this.getCliente()+"'";

        db.execSQL(sql);
        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        ProductoSQLiteOpenHelper  aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM prestamos where serie='"+this.getSerie()+"'";
        db.execSQL(sql);
        db.close();

    }


}
