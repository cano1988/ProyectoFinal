package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViajeActivity extends AppCompatActivity {
    EditText jetcantidad, jetvalor;
    private TextView jtvbruto, jtviva, jtvdescuento, jtvneto, jtvmen1, jtvmen2, jtvmen3, jtvmen4;
    CheckBox jcbiva, jcbdescuento;
    String  cantidad,valor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viaje);
        getSupportActionBar().hide();
        //Asociación de objetos java con xml
        jetcantidad=findViewById(R.id.etcantidad);
        jetvalor=findViewById(R.id.etvalor);
        jtvbruto=findViewById(R.id.tvbruto);
        jtviva=findViewById(R.id.tviva);
        jtvdescuento=findViewById(R.id.tvdescuento);
        jtvneto=findViewById(R.id.tvneto);
        jcbiva=findViewById(R.id.cbiva);
        jcbdescuento=findViewById(R.id.cbdescuento);
        jtvmen1=findViewById(R.id.tvmen1);
        jtvmen2=findViewById(R.id.tvmen2);
        jtvmen3=findViewById(R.id.tvmen3);
        jtvmen4=findViewById(R.id.tvmen4);

    }// Fin método onCreate

    public void calcular(View view){
        cantidad = jetcantidad.getText().toString();
        valor = jetvalor.getText().toString();
        if(cantidad.length() <=0 || valor.length() <= 0){
            Toast.makeText(this, "Los campos valor y cantidad no pueden estar vacíos", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }else{
            int cant_perso = Integer.parseInt(cantidad);
            float val_perso = Float.parseFloat(valor);
            float valor_bruto, iva, descuento, val_neto  ;
            //Instanciar clase cant_perso para poder inicializar valor_bruto
            ClsViaje  objViajes = new ClsViaje(cant_perso);
            valor_bruto = objViajes.val_bruto(val_perso);

            //Instanciar clase para el parámetro valor_bruto
            ClsViaje objViajes1 =new ClsViaje(valor_bruto);

            //Se chequea si aplica iva o no aplica
            if (jcbiva.isChecked() == true){
                iva = objViajes1.iva();
                jtviva.setText(String.valueOf(iva));
            }else{
                jtviva.setText("0");
                iva = 0;
                //Se chequea si aplica descuento  o no aplica
            }if (jcbdescuento.isChecked() == true){
                descuento = objViajes1.descuento();
                jtvdescuento.setText(String.valueOf(descuento));
            }else{
                jtvdescuento.setText("0");
                descuento =0;
            }

            //Operaciones, Se extrae descuento e iva  para poder inicializarlas

            val_neto = objViajes1.valor_neto(iva,descuento);



            //Imprimir resultados
            jtvbruto.setText(String.valueOf(valor_bruto));
            jtvneto.setText(String.valueOf(val_neto));
            jtvmen1.setVisibility(View.VISIBLE);
            jtvmen2.setVisibility(View.VISIBLE);
            jtvmen3.setVisibility(View.VISIBLE);
            jtvmen4.setVisibility(View.VISIBLE);

        }
    }// Fin método calcular

    public  void  limpiar(View view){
        jetcantidad.setText("");
        jetcantidad.requestFocus();
        jetvalor.setText("");
        jtviva.setText("");
        jtvdescuento.setText("");
        jtvbruto.setText("");
        jtvneto.setText("");
        jcbdescuento.setChecked(false);
        jcbiva.setChecked(false);
        jtvmen1.setVisibility(View.INVISIBLE);
        jtvmen2.setVisibility(View.INVISIBLE);
        jtvmen3.setVisibility(View.INVISIBLE);
        jtvmen4.setVisibility(View.INVISIBLE);


    }// Fin proceso limpiar


    public void regresar(View view){
        Intent intOpcionesActivity = new Intent(this, OpcionesActivity.class);
        startActivity(intOpcionesActivity);
    }//Fin método regresar
}