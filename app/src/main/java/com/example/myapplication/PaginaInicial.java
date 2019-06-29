package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PaginaInicial extends AppCompatActivity {
    FloatingActionButton btflotante;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);
        btflotante=findViewById(R.id.fl_añadirmascota);
    }
    public void onClickAñadirMascota(View v){
       Intent i=new Intent(PaginaInicial.this, NuevaMascota.class);
       startActivity(i);
    }
}
