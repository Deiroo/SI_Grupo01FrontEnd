package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.BD_Datos.Tr_Cliente;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    final String CREAR_TABLA_CLIENTE= Tr_Cliente.TABLA_CLIENTE;
    public ConexionSQLiteHelper(Context context) {
        super(context,"bd_finanzas",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        onCreate(db);
    }
}
