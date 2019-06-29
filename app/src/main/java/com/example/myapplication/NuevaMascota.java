package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Entity.Mascota;

public class NuevaMascota extends AppCompatActivity {
    String nombre;
    String descripcion;
    String raza;
    String tipo;
    String dueño;
Mascota mascota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);
        mascota=new Mascota();
    }
    public void onClickAñadirMascota(View v){
        nombre=findViewById(R.id.et_nombremascota).toString();
        descripcion=findViewById(R.id.et_descripcionmascota).toString();
        raza=findViewById(R.id.et_razamascota).toString();
        tipo=findViewById(R.id.et_tipomascota).toString();
        dueño=findViewById(R.id.et_dueñomascota).toString();
        if(nombre!=null&&descripcion!=null&&raza!=null&&tipo!=null&&dueño!=null){
            mascota.setNombre(nombre);
            mascota.setDescripcion(descripcion);
            mascota.setRaza(raza);
            mascota.setTipo(tipo);
            mascota.setDueño(dueño);
            Toast.makeText(getApplicationContext(), "Mascota guardadada exitosamente", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(NuevaMascota.this,PaginaInicial.class);
            startActivity(i);
            finish();
        }
        else
            Toast.makeText(getApplicationContext(), "Complete los campos antes de continuar", Toast.LENGTH_SHORT).show();

    }
}
