package com.example.my_application1td;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void limpiar (View View)
    {
        EditText cedula = (EditText) findViewById(R.id.txtCedula);
        EditText nombres = (EditText) findViewById(R.id.txtNombre1);
        EditText fecha = (EditText) findViewById(R.id.txtfecha1);
        EditText ciudad = (EditText) findViewById(R.id.txtciudad1);
        EditText correo = (EditText) findViewById(R.id.txtcorreo1);
        EditText telefono = (EditText) findViewById(R.id.txttelefo1);
        cedula.setText("");
        nombres.setText("");
        fecha.setText("");
        ciudad.setText("");
        correo.setText("");
        telefono.setText("");
    }
    public void login (View View)
    {
        RadioGroup radioGroup = findViewById(R.id.btgrup);
        int radiobselec = radioGroup.getCheckedRadioButtonId();
        String generos = "";
        if (radiobselec != -1) {
            RadioButton radioButton = findViewById(radiobselec);
            generos = radioButton.getText().toString();
        }
        if (generos == "")
        {
            Toast.makeText(getApplicationContext(), "no se seleciono ningun genero", Toast.LENGTH_SHORT).show();
            return;
        }
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        EditText cedula = (EditText) findViewById(R.id.txtCedula);
        EditText nombres = (EditText) findViewById(R.id.txtNombre1);
        EditText fecha = (EditText) findViewById(R.id.txtfecha1);
        EditText ciudad = (EditText) findViewById(R.id.txtciudad1);
        EditText correo = (EditText) findViewById(R.id.txtcorreo1);
        EditText telefono = (EditText) findViewById(R.id.txttelefo1);
        String cedu, nombre, fech, ciuda, corre, telefon;
        cedu = cedula.getText().toString();
        nombre = nombres.getText().toString();
        fech = fecha.getText().toString();
        ciuda = ciudad.getText().toString();
        corre = correo.getText().toString();
        telefon = telefono.getText().toString();
        if (!pattern.matcher(corre).matches())
        {
            Toast.makeText(getApplicationContext(), "el correo ingresado es invàlido", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!validaFecha(fech))
        {
            Toast.makeText(getApplicationContext(), "la fecha ingresada es invàlido", Toast.LENGTH_SHORT).show();
            return;
        }
        Bundle b = new Bundle();
        b.putString("CEDULA", cedu);
        b.putString("NOMBRES",nombre);
        b.putString("FECHA", fech);
        b.putString("CIUDAD", ciuda);
        b.putString("GENERO",generos);
        b.putString("CORREO", corre);
        b.putString("TELEFONO", telefon);
        Intent intent = new Intent(MainActivity.this, MainActivity2e1td.class);
        intent.putExtras(b);
        startActivity(intent);
    }
    //validar fecha
    private boolean validaFecha(String fecha)
    {
        try {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            dt.setLenient(false);
            dt.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}