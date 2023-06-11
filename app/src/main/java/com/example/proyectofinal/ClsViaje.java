package com.example.proyectofinal;

public class ClsViaje {
    float valor_bruto;
    int cantidad;

    public ClsViaje(float valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public ClsViaje(int cantidad) {
        this.cantidad = cantidad;
    }

    public float val_bruto(float val_persona){
        return cantidad * val_persona;
    }

    public float iva(){
        return valor_bruto * 19/100;
    }

    public float descuento(){
     return  valor_bruto  * 10/100;

    }

    public  float valor_neto( float iva, float descuento){
        return valor_bruto - descuento + iva;
    }
}
