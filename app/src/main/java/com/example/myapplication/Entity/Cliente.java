package com.example.myapplication.Entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.BD_Datos.Tr_Cliente;
import com.example.myapplication.ConexionSQLiteHelper;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int codigo;
    private String nombre;
    private String contraseña;
    private String email;
    private String telefono;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Boolean AgregarCliente(ConexionSQLiteHelper con){
        try{
            SQLiteDatabase db=con.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(Tr_Cliente.NOMBRE,nombre);
            values.put(Tr_Cliente.CONTRASEÑA,contraseña);
            values.put(Tr_Cliente.CORREO,email);
            values.put(Tr_Cliente.TELEFONO,telefono);
            long ins=db.insert("Cliente",null,values);
            if(ins==1)return false;
            else return true;
        }
        catch (Exception e){
            throw e;
        }
    }
    public Boolean checkaccount(String email,String contraseña,ConexionSQLiteHelper con){
        SQLiteDatabase db=con.getReadableDatabase();
        Cursor cursor=db.rawQuery("select*from Cliente where TCorreo=? and CContraseña=?",new String[]{email,contraseña});
        if(cursor.getCount()>0) return true;
        else return false;
    }
    public Boolean checkmail(String email,ConexionSQLiteHelper con){
        SQLiteDatabase db=con.getReadableDatabase();
        Cursor cursor=db.rawQuery("select*from Cliente where TCorreo=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
