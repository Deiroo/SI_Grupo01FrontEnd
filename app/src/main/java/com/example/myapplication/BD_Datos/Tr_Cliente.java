package com.example.myapplication.BD_Datos;

public class Tr_Cliente {
    public static final String CLIENTE="CCliente";
    public static final String NOMBRE="NCliente";
    public static final String CONTRASEÑA="CContraseña";
    public static final String TELEFONO="TTelefono";
    public static final String CORREO="TCorreo";
    public static final String TABLA_CLIENTE="create table Cliente("+CLIENTE+" integer PRIMARY KEY,"+NOMBRE+" varchar(100),"+CONTRASEÑA+" varchar(50),"+TELEFONO+" varchar(20),"+CORREO+" varchar(100))";
}
