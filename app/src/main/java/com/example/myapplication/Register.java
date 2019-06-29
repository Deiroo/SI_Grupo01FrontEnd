package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Entity.Cliente;

public class Register extends AppCompatActivity {
    public ConexionSQLiteHelper con=new ConexionSQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void onClickRegistrar(View v) {
        Cliente cliente = new Cliente();
        EditText nombre;
        EditText contraseña;
        EditText contraseña2;
        EditText email;
        EditText telefono;
        nombre = findViewById(R.id.box_nombre);
        contraseña=findViewById(R.id.box_password);
        contraseña2=findViewById(R.id.box_contraseñac);
        email = findViewById(R.id.box_email);
        telefono = findViewById(R.id.box_telefono);
        String snombre = nombre.getText().toString();
        String scontraseña=contraseña.getText().toString();
        String scontraseñac=contraseña2.getText().toString();
        String semail = email.getText().toString();
        String stelefono = telefono.getText().toString();
        cliente.setNombre(snombre);
        cliente.setContraseña(scontraseña);
        cliente.setEmail(semail);
        cliente.setTelefono(stelefono);
        if (snombre.equals("") || scontraseña.equals("")||scontraseñac.equals("")||semail.equals("")||stelefono.equals(""))
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        else {
            if (scontraseña.equals(scontraseñac)==true) {
                Boolean checkmail = cliente.checkmail(semail,con);
                if (checkmail == true) {
                    Boolean insert = cliente.AgregarCliente(con);
                    if (insert == true){
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Register.this, Login.class);
                        startActivity(i);
                        finish();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "Email, Already exists", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
        }
        con.close();

    }
}
