package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText jetusuario, jetclave;
    private Button jbtingresar;
    String usuario, clave;
    int intentos = 1;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //Asociación de variables
        jetusuario=findViewById(R.id.etusuario);
        jetclave=findViewById(R.id.etclave);
        jbtingresar=findViewById(R.id.btingresar);
        jbtingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = jetusuario.getText().toString();
                clave = jetclave.getText().toString();
                String pass = "joga";
                String user = "andres";
                if (usuario.isEmpty() || clave.isEmpty()){
                    Toast.makeText(MainActivity.this, "Los campos de clave y usuario no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                    jetusuario.requestFocus();
                }else{
                    if (usuario.equals(user) && clave.equals(pass)) {
                    Intent intOpcionesActivity = new Intent(getApplication(), OpcionesActivity.class);
                    startActivity(intOpcionesActivity);

                } else if (intentos == 3) {
                    Toast.makeText(MainActivity.this, "Has excedido el número de intentos, el boton ingresar queda desactivado", Toast.LENGTH_SHORT).show();
                    jbtingresar.setEnabled(false);
                }else {
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecto, te  \n quedan  " + (3 - intentos) + " intentos", Toast.LENGTH_SHORT).show();
                        jetusuario.setText("");
                        jetusuario.requestFocus();
                        jetclave.setText("");
                        intentos = intentos + 1;
                    }
                }
            }
        });
    }
}