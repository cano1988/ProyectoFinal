package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpcionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        getSupportActionBar().hide();
    }





   //Método que con el objeto intent me permite ir a la actividad de viaje
    public void viaje(View view){
        Intent intViajeActivity = new Intent(this, ViajeActivity.class);
        startActivity(intViajeActivity);
    }
    //Método que con el objeto intent me permite ir a la actividad de servicios
    public void servicios(View view){
        Intent intServiciosActivity = new Intent(this, ServiciosActivity.class);
        startActivity(intServiciosActivity);
    }

    //Método regresar
    public void regresar(View view){
        Intent intMainActivity = new Intent(this, MainActivity.class);
        startActivity(intMainActivity);
    }

}