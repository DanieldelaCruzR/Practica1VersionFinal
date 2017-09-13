package com.example.geometrica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CuboActivity extends AppCompatActivity {
    private TextView tCubo;
    private EditText eLadoCub;
    private Button bCubo;
    private Double area,perimetro,volumen,lado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);

        tCubo=(TextView)findViewById(R.id.tCubo);
        eLadoCub=(EditText)findViewById(R.id.eLadoCub);
        bCubo=(Button)findViewById(R.id.bCubo);
    }

    public void CalcularCubo(View view) {
        InputMethodManager MiTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //almacemar dentro de Miteclado el dispositivo qu e usamos para introducir la informacion(teclado)
        MiTeclado.hideSoftInputFromWindow(eLadoCub.getWindowToken(), 0);
        if (eLadoCub.getText().toString().length() == 0) {
            eLadoCub.setError("This field is required");
        } else {
            lado = Double.parseDouble(eLadoCub.getText().toString());
            area = 6 * lado * lado;
            volumen = lado * lado * lado;
            perimetro = lado * 12;
            tCubo.setText("El CUBO de lado " + lado.toString() + " \n\nArea: " + area.toString() + "\n\nPerimetro: " + perimetro.toString() + "\n\nVolumen: " + volumen.toString());
        }
    }
}
