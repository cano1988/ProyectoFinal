package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.sax.SAXResult;

public class ServiciosActivity extends AppCompatActivity {

   private TextView jtvmen1,jtvmen2,jtvmen3,jtvmen4,jtvmen5,jtvmen6,jtvmen7, jtvbruto,jtvsubsidio, jtvtotal;
    EditText jetcant_agua, jetval_agua, jetcant_kilov, jetval_kilov;
    Spinner jspestrato, jspconsu_agua, jspconsu_kilov;
    String cant_agua, val_agua, cant_kilov, val_kilov, selestrato, selconkilov, selconagua;
    ClsEncapsulamiento objEncap = new ClsEncapsulamiento();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        getSupportActionBar().hide();
        //Asociación de objetos java con xml
        jtvmen1=findViewById(R.id.tvmen1);
        jtvmen2=findViewById(R.id.tvmen2);
        jtvmen3=findViewById(R.id.tvmen3);
        jtvmen4=findViewById(R.id.tvmen4);
        jtvmen5=findViewById(R.id.tvmen5);
        jtvmen6=findViewById(R.id.tvmen6);
        jtvmen7=findViewById(R.id.tvmen7);
        jtvbruto =findViewById(R.id.tvbruto);
        jtvsubsidio =findViewById(R.id.tvsubsidio);
        jtvtotal=findViewById(R.id.tvtotal);
        jetcant_agua=findViewById(R.id.etcant_agua);
        jetval_agua=findViewById(R.id.etval_agua);
        jetcant_kilov=findViewById(R.id.etcant_kilov);
        jetval_kilov=findViewById(R.id.etval_kilov);
        jspestrato=findViewById(R.id.spestrato);
        jspconsu_agua=findViewById(R.id.spconsu_agua);
        jspconsu_kilov=findViewById(R.id.spconsu_kilov);

        //Se realiza la función array adapter y se llaman por medio de la clase ArrayAdapter para crear un ListView (Spinner)

        String [] opciones1 = {"Estrato 1 y 2", "Estrato 3 y 4", "Estrato 5 y 6"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_servicio, opciones1);
        jspestrato.setAdapter(adapter1);

        String [] opciones2 = {"Menos de 10m^3", "Mas de 10m^3"};
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_servicio, opciones2);
        jspconsu_agua.setAdapter(adapter2);


        String [] opciones3 = {"Menos de 100kv",  "Mas de 100kv"};
        ArrayAdapter <String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner_servicio, opciones3);
        jspconsu_kilov.setAdapter(adapter3);
    }

    public void calcular(View view) {
        //Se crean variables string, que nos permiten recuperar los valores ingresados por el usuario en los edit text
        cant_agua = jetcant_agua.getText().toString();
        val_agua = jetval_agua.getText().toString();
        cant_kilov = jetcant_kilov.getText().toString();
        val_kilov = jetval_kilov.getText().toString();
        //Si las variables para editar estan vacias se genera un mensaje al usuario
        if (cant_agua.length() <= 0 || val_agua.length() <= 0 || cant_kilov.length() <= 0 || val_kilov.length() <= 0) {
            Toast.makeText(this, "Ninguno de los campos puede estar vacío", Toast.LENGTH_SHORT).show();
            jetcant_agua.requestFocus();
        }else{
           selestrato = jspestrato.getSelectedItem().toString();
           selconagua = jspconsu_agua.getSelectedItem().toString();
           selconkilov = jspconsu_kilov.getSelectedItem().toString();
           float canAgua = Float.parseFloat(cant_agua);
           float valAgua = Float.parseFloat(val_agua);
           float canKilov = Float.parseFloat(cant_kilov);
           float valKilov = Float.parseFloat(val_kilov);
           float costo_agua, costo_luz, valor_total, subsidio, valor_bruto;

           //Instanciar los métodos de encapsulamiento

            objEncap.setCant_agua(canAgua);
            objEncap.setVal_agua(valAgua);
            objEncap.setCant_kilov(canKilov);
            objEncap.setVal_kilov(valKilov);

            costo_agua = objEncap.costo_agua();
            costo_luz = objEncap.costo_luz();
            valor_bruto = objEncap.valor_bruto(costo_agua,costo_luz);

            if(selestrato.equals("Estrato 1 y 2") && selconagua.equals("Menos de 10m^3") && selconkilov.equals("Menos de 100kv")) {
                subsidio = objEncap.subsidio(valor_bruto);
                jtvsubsidio.setText(String.valueOf(subsidio));
            }else{
                jtvsubsidio.setText("0");
                subsidio = 0;

            }

            valor_total = objEncap.valor_total(costo_agua,costo_luz,subsidio);
            //Imprimir resuiltados
            jtvtotal.setText(String.valueOf(valor_total));
            jtvbruto.setText(String.valueOf(valor_bruto));
            jtvmen1.setVisibility(View.VISIBLE);
            jtvmen2.setVisibility(View.VISIBLE);
            jtvmen3.setVisibility(View.VISIBLE);
            jtvmen4.setVisibility(View.VISIBLE);
            jtvmen5.setVisibility(View.VISIBLE);
            jtvmen6.setVisibility(View.VISIBLE);
            jtvmen7.setVisibility(View.VISIBLE);


        }
    }//Fin método calcular

    public  void  limpiar(View view){
        jetcant_agua.setText("");
        jetcant_agua.requestFocus();
        jetval_agua.setText("");
        jetcant_kilov.setText("");
        jetval_kilov.setText("");
        jtvbruto.setText("");
        jtvsubsidio.setText("");
        jtvtotal.setText("");
        jtvmen1.setVisibility(View.INVISIBLE);
        jtvmen2.setVisibility(View.INVISIBLE);
        jtvmen3.setVisibility(View.INVISIBLE);
        jtvmen4.setVisibility(View.INVISIBLE);
        jtvmen5.setVisibility(View.INVISIBLE);
        jtvmen6.setVisibility(View.INVISIBLE);
        jtvmen7.setVisibility(View.INVISIBLE);



    }// Fin proceso limpiar


    public void regresar(View view){
        Intent intOpcionesActivity = new Intent(this, OpcionesActivity.class);
        startActivity(intOpcionesActivity);
    }//Fin método regresar
}