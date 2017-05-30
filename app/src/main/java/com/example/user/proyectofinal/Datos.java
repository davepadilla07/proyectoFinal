package com.example.user.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by user on 22/5/2017.
 */

public class Datos {

    public static ArrayList<Crea_Garantia> traerGarantia(Context contexto){
        ArrayList<Crea_Garantia> garantia = new ArrayList<>();

        SQLiteDatabase db;
        String sql, rma, cliente, telefono, correo, equipo, modelo, serie, fecha;
        Crea_Garantia g;

        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        sql ="select * from garantias";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                rma = c.getString(0);
                cliente = c.getString(1);
                telefono =c.getString(2);
                correo = c.getString(3);
                equipo = c.getString(4);
                modelo = c.getString(5);
                serie = c.getString(6);
                fecha = c.getString(7);
                g = new Crea_Garantia(rma, cliente, telefono, correo, equipo, modelo, serie, fecha);
                garantia.add(g);

            }while (c.moveToNext());
        }
        db.close();

        return garantia;
    }

    public static Crea_Garantia buscarGarantia(Context contexto, String rm){

        //Declarar variables
        SQLiteDatabase db;
        String sql, rma, cliente, telefono, correo, equipo, modelo, serie, fecha;
        Crea_Garantia g=null;
        //Abrir conexión de lectura
        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from garantias where rma ='"+rm+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            rma = c.getString(0);
            cliente = c.getString(1);
            telefono =c.getString(2);
            correo = c.getString(3);
            equipo = c.getString(4);
            modelo = c.getString(5);
            serie = c.getString(6);
            fecha = c.getString(7);
            g = new Crea_Garantia(rma, cliente, telefono, correo, equipo, modelo, serie, fecha);
        }
        db.close();
        return g;
    }


    public static ArrayList<Producto> traerPrestamo(Context contexto){
        ArrayList<Producto> producto = new ArrayList<>();

        SQLiteDatabase db;
        String sql, foto, serie, modelo, descripcion, cliente;
        Producto p;

        ProductoSQLiteOpenHelper aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        sql ="select * from prestamos";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                serie = c.getString(1);
                modelo = c.getString(2);
                descripcion = c.getString(3);
                cliente = c.getString(4);

                p = new Producto(foto, serie, modelo, descripcion, cliente);
                producto.add(p);

            }while (c.moveToNext());
        }
        db.close();

        return producto;
    }

    public static Producto buscarPrestamo(Context contexto, String ser){

        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, serie, modelo, descripcion, cliente;
        Producto p=null;
        //Abrir conexión de lectura
        ProductoSQLiteOpenHelper aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from prestamos where serie ='"+ser+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            foto = c.getString(0);
            serie = c.getString(1);
            modelo = c.getString(2);
            descripcion = c.getString(3);
            cliente = c.getString(4);
            p = new Producto(foto, serie, modelo, descripcion, cliente);
        }
        db.close();
        return p;
    }

    public static ArrayList<Crea_Cliente> traerCliente(Context contexto){
        ArrayList<Crea_Cliente> cliente = new ArrayList<>();

        SQLiteDatabase db;
        String sql, tipo, nitced, nombre, telefono, correo, direccion, ciudad;
        Crea_Cliente cl;

        Crear_ClienteSQLiteOpenHelper aux = new Crear_ClienteSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        sql ="select * from clientes";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                tipo = c.getString(0);
                nitced = c.getString(1);
                nombre = c.getString(2);
                telefono = c.getString(3);
                correo = c.getString(4);
                direccion = c.getString(5);
                ciudad = c.getString(6);

                cl = new Crea_Cliente(tipo, nitced, nombre, telefono, correo, direccion, ciudad);
                cliente.add(cl);

            }while (c.moveToNext());
        }
        db.close();
        return cliente;
    }

    public static Crea_Cliente buscarCliente(Context contexto, String nitc){

        //Declarar variables
        SQLiteDatabase db;
        String sql, tipo, nitced, nombre, telefono, correo, direccion, ciudad;
        Crea_Cliente cl=null;
        //Abrir conexión de lectura
        Crear_ClienteSQLiteOpenHelper aux = new Crear_ClienteSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from clientes where nitced ='"+nitc+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            tipo = c.getString(0);
            nitced = c.getString(1);
            nombre = c.getString(2);
            telefono = c.getString(3);
            correo = c.getString(4);
            direccion = c.getString(5);
            ciudad = c.getString(6);
            cl = new Crea_Cliente(tipo, nitced, nombre, telefono, correo, direccion, ciudad);
        }
        db.close();
        return cl;
    }

}
