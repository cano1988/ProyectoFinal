package com.example.proyectofinal;

public class ClsEncapsulamiento {

private float cant_agua;
private  float val_agua;
private  float cant_kilov;
private  float val_kilov;




    // Por medio de la función set y get encapsulamos las variables

    //Encapsulamiento variable cantidad de agua con los métodos set y get
    public void setCant_agua(float cant_agua) {this.cant_agua = cant_agua;    }

    //Encapsulamiento variable cantidad de agua
    public void setVal_agua(float val_agua) { this.val_agua = val_agua; }

    //Encapsulamiento variable cantidad de kilovatios
    public void setCant_kilov(float cant_kilov) {  this.cant_kilov = cant_kilov;    }

    //Encapsulamiento variable valor kilovatio
    public void setVal_kilov(float val_kilov) { this.val_kilov = val_kilov;    }

    // Métodos de las operaciones

    public  float costo_agua(){
        return cant_agua * val_agua;    }
    public  float costo_luz(){
        return  cant_kilov * val_kilov; }

    public float valor_bruto(float costo_agua , float costo_luz){
        return costo_agua + costo_luz;    }
    public  float subsidio (float valor_bruto){
        return (valor_bruto * 10)/100;
    }

    public  float valor_total(float costo_agua, float costo_luz, float subsidio){
     return (costo_agua + costo_luz) - subsidio;   }
}
