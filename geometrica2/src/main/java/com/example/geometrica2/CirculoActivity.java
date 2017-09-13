package com.example.geometrica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CirculoActivity extends AppCompatActivity {
    private EditText eRadio;
    private TextView tCirculo;
    private Button bCirculo;
    private String area_s,perimetro_s;
    private Double r,area,perimetro,pi=3.1416;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        eRadio=(EditText)findViewById(R.id.eRadio);
        bCirculo=(Button)findViewById(R.id.bCirculo);
        tCirculo=(TextView)findViewById(R.id.tCirculo);

    }

    public void CalcularCirculo(View view) {

        InputMethodManager MiTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //almacemar dentro de Miteclado el dispositivo qu e usamos para introducir la informacion(teclado)
        MiTeclado.hideSoftInputFromWindow(eRadio.getWindowToken(), 0);
        if(eRadio.getText().toString().length()==0){eRadio.setError("This field is required");}
        else {
            r = Double.parseDouble(eRadio.getText().toString());


            area = pi * r * r;
            perimetro = 2 * pi * r;
            perimetro_s = perimetro.toString();
            area_s = area.toString();
            tCirculo.setText("El CÍRCULO de radio " + r.toString() + " \n\n\nArea: " + area_s + "\n\nPerimetro: " + perimetro_s);
        }

    }
}