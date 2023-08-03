package com.example.androidst_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class liquidacion extends AppCompatActivity {

    private TextView nombresCompleted;
    private TextView cargos;
    private TextView sueldo_base;
    private TextView dias_laborales;
    private TextView sueldoXdia;
    private TextView sueldoneto;
    private TextView descuento_descuento;
    private TextView salud_descuento;
    private TextView pension_descuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquidacion);

        nombresCompleted = (TextView)findViewById(R.id.nombres_completos);

        cargos = (TextView)findViewById(R.id.Cargos_P);

        sueldo_base = (TextView)findViewById(R.id.suel_base_M);

        dias_laborales =(TextView)findViewById(R.id.dias_L);

        sueldoXdia =(TextView)findViewById(R.id.sueldo_d);

        sueldoneto =(TextView)findViewById(R.id.sueldo_n);

        descuento_descuento=(TextView)findViewById(R.id.descuento_d);

        salud_descuento=(TextView)findViewById(R.id.salud_d);

        pension_descuento= (TextView)findViewById(R.id.pension_d);


        String recibiendoNombre = getIntent().getStringExtra("nombres");
        String recibiendApellidos = getIntent().getStringExtra("apellidos");
        nombresCompleted.setText("nombres: " + recibiendoNombre + " " +recibiendApellidos);

        String recibiendoCargo = getIntent().getStringExtra("cargo");
        cargos.setText("cargo: "+recibiendoCargo);

        String recibiendoSaldo = getIntent().getStringExtra("sueldo_b");
        sueldo_base.setText("Sueldo base: " + recibiendoSaldo);

        String recibiendoDias= getIntent().getStringExtra("dias_laborales");
        dias_laborales.setText("dias laborales :" + recibiendoDias);

        double recibiendoSueldoXdia= getIntent().getDoubleExtra("sueldo_dia", 0.0);
        sueldoXdia.setText(String.valueOf("valor por dia: " + recibiendoSueldoXdia));


        double recibiendoSueldoNeto= getIntent().getDoubleExtra("sueldoneto",0.0);
        sueldoneto.setText(String.valueOf("sueldo neto: " + recibiendoSueldoNeto));

        double recibiendoDescuentoDescuento= getIntent().getDoubleExtra("descuento", 0.0);
        descuento_descuento.setText(String.valueOf("el valor del descuento es: " + recibiendoDescuentoDescuento));

        double recibiendoSaludDescuento= getIntent().getDoubleExtra("salud", 0.0);
        salud_descuento.setText(String.valueOf("descuento de salud: " + recibiendoSaludDescuento));

        double recibiendoPensionDescuento= getIntent().getDoubleExtra("pension", 0.0);
        pension_descuento.setText(String.valueOf("el descuento de pension: " + recibiendoPensionDescuento));


    }
}