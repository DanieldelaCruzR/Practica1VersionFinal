package com.example.geometrica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CuadradoActivity extends AppCompatActivity {
    private EditText eLadoCua;
    private Button bCuadrado;
    private TextView tCuadrado;
    private Double area,perimetro,lado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        eLadoCua=(EditText)findViewById(R.id.eLadoCua);
        bCuadrado=(Button)findViewById(R.id.bCuadrado);
        tCuadrado=(TextView)findViewById(R.id.tCuadrado);
    }

    public void CalcularCuadrado(View view) {
        InputMethodManager MiTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //almacemar dentro de Miteclado el dispositivo qu e usamos para introducir la informacion(teclado)
        MiTeclado.hideSoftInputFromWindow(eLadoCua.getWindowToken(), 0);
        if (eLadoCua.getText().toString().length() == 0) {
            eLadoCua.setError("This field is required");
        } else {
            lado = Double.parseDouble(eLadoCua.getText().toString());
            area = lado * lado;
            perimetro = lado * 4;

            tCuadrado.setText("El CUADRADO de lado " + lado.toString() + " \n\n\nArea: " + area.toString() + "\n\nPerimetro: " + perimetro.toString());
        }
    }
}