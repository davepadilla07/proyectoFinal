package com.example.user.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 30/5/2017.
 */

public class Crear_ClienteSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE clientes(tipo text, nitced text, nombre text, telefono text, correo text, direccion text, ciudad text)";
    static int version=4;
    public Crear_ClienteSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS clientes");
        db.execSQL(sql);
    }
}
