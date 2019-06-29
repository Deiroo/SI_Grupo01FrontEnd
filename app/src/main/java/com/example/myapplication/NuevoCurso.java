package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Entity.Curso;

public class NuevoCurso extends AppCompatActivity {
String nombre;
String descripcion;
Integer nivel;
Integer vacantes;
String establecimiento;
Curso curso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_curso);
        curso=new Curso();
    }
    public void onClickGuardarCurso(View v){
    nombre=findViewById(R.id.et_nombrecurso).toString();
    descripcion=findViewById(R.id.et_descripcioncurso).toString();
    nivel=Integer.parseInt(findViewById(R.id.et_nivelcurso).toString());
    vacantes=Integer.parseInt(findViewById(R.id.et_vancantescurso).toString());
    establecimiento=findViewById(R.id.et_establecimientocurso).toString();
    if(nombre!=null&&descripcion!=null&&nivel!=null&&vacantes!=null&&establecimiento!=null){
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setEstablecimiento(establecimiento);
        curso.setNivel(nivel);
        curso.setVacantes(vacantes);
        Intent i=new Intent(NuevoCurso.this,PaginaInicial.class);
        startActivity(i);
        finish();
    }
    else
        Toast.makeText(getApplicationContext(),"LLene los campos antes de continuar",Toast.LENGTH_LONG).show();
    }
}
