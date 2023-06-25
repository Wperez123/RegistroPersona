package com.example.my_application1td;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2e1td extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2e1td);
        TextView txtmensaj = findViewById(R.id.txtmensaje);
        TextView txtcedula2 = findViewById(R.id.txtcedula2);
        TextView txtnombre2 = findViewById(R.id.txtnombre2);
        TextView txtfechna2 = findViewById(R.id.txtfechna2);
        TextView txtciudad2 = findViewById(R.id.txtciudad2);
        TextView txtgenero2 = findViewById(R.id.txtgenero2);
        TextView txtcorreo2 = findViewById(R.id.txtcorreo2);
        TextView txttelefono2 = findViewById(R.id.txttelefono2);
        Bundle bundle = this.getIntent().getExtras();
        String cedula, nombre, fecha, genero, ciudad, correo, telefono, mensajeEncabezado;
        cedula = bundle.getString("CEDULA");
        nombre = bundle.getString("NOMBRES");
        fecha = bundle.getString("FECHA");
        genero = bundle.getString("GENERO");
        ciudad = bundle.getString("CIUDAD");
        correo = bundle.getString("CORREO");
        telefono = bundle.getString("TELEFONO");
        if(genero.equals("Masculino"))
        {
            mensajeEncabezado = "BIENVENIDO";
        }else
        {
            mensajeEncabezado = "BIENVENIDA";
        }
        txtmensaj.setText("Hola "+ mensajeEncabezado);
        txtcedula2.setText(cedula);
        txtnombre2.setText(nombre);
        txtfechna2.setText(fecha);
        txtciudad2.setText(ciudad);
        txtgenero2.setText(genero);
        txtcorreo2.setText(correo);
        txttelefono2.setText(telefono);
    }
}