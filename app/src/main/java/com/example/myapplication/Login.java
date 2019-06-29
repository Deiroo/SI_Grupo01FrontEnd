package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Entity.Cliente;

public class Login extends AppCompatActivity {
    ConexionSQLiteHelper con=new ConexionSQLiteHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClickLogin(View v){
        Cliente cliente=new Cliente();
        EditText Email=findViewById(R.id.box_user);
        EditText Contraseña=findViewById(R.id.box_password);
        String sEmail=Email.getText().toString();
        String sContraseña=Contraseña.getText().toString();
        if(cliente.checkaccount(sEmail,sContraseña,con)==true){
            Intent i=new Intent(Login.this, PaginaInicial.class);
            startActivity(i);
            finish();
        }
        else
            Toast.makeText(this,"Usuario o contraseña incorrecto",Toast.LENGTH_SHORT).show();
        con.close();
    }
    public void onClickRegister(View v){
        Intent i=new Intent(Login.this, Register.class);
        startActivity(i);
    }
}
