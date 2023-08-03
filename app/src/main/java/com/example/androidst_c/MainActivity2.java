package com.example.androidst_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText text_nombre, text_apellido, text_cargo, text_suel_base, text_dias_lab;

    private CheckBox check1, check2, check3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text_nombre = (EditText)findViewById(R.id.lbl_nombres);
        text_apellido = (EditText)findViewById(R.id.lbl_apellidos);
        text_cargo = (EditText)findViewById(R.id.lbl_cargo);
        text_suel_base = (EditText)findViewById(R.id.lbl_suel_bas);
        text_dias_lab = (EditText)findViewById(R.id.lbl_dias_lab);
        check1 = (CheckBox)findViewById(R.id.check_descuento);
        check2 = (CheckBox)findViewById(R.id.check_salud);
        check3 = (CheckBox)findViewById(R.id.check_pension);

    }

    public void Siguiente(View view){

        Intent presionar = new Intent(this, liquidacion.class);

        double sueldo_inicial = Double.parseDouble(text_suel_base.getText().toString());
        double sueldoXdia = Double.parseDouble(text_dias_lab.getText().toString());

        boolean descuento = check1.isChecked();
        boolean salud = check2.isChecked();
        boolean pension = check3.isChecked();

        double porcentaje_descuento = 0;
        if(descuento){
            porcentaje_descuento += 3;
            double descuento_descuento = sueldo_inicial * 0.3;
            presionar.putExtra("descuento",descuento_descuento);
        }
        if(salud){
            porcentaje_descuento += 4;
            double descuento_salud = sueldo_inicial * 0.4;
            presionar.putExtra("salud",descuento_salud);
        }
        if(pension){
            porcentaje_descuento += 4;
            double descuento_pension = sueldo_inicial * 0.4;
            presionar.putExtra("pension",descuento_pension);
        }

        double total_descuento = sueldo_inicial * (porcentaje_descuento / 100);
        double sueldo_dia = sueldo_inicial / 30;
        double sueldo_bruto = sueldo_dia * sueldoXdia;
        double sueldo_neto = sueldo_bruto - total_descuento;


        presionar.putExtra("nombres", text_nombre.getText().toString());
        presionar.putExtra("apellidos", text_apellido.getText().toString());
        presionar.putExtra("cargo", text_cargo.getText().toString());
        presionar.putExtra("sueldo_b", text_suel_base.getText().toString());
        presionar.putExtra("dias_laborales", text_dias_lab.getText().toString());
        presionar.putExtra("sueldo_dia",sueldo_dia);
        presionar.putExtra("sueldoneto", sueldo_neto);

        startActivity(presionar);
    }
}