package com.example.geometrica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrianguloActivity extends AppCompatActivity {
    private EditText eBase, eAltura;
    private TextView tTriangulo;
    private Button bTriangulo;
    private Double area, perimetro, base, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        eBase=(EditText)findViewById(R.id.eBase);
        eAltura=(EditText)findViewById(R.id.eAltura);
        tTriangulo=(TextView)findViewById(R.id.tTriangulo);
        bTriangulo=(Button)findViewById(R.id.bTriangulo);

    }

    public void CalcularTriangulo(View view) {
        InputMethodManager MiTeclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //almacemar dentro de Miteclado el dispositivo qu e usamos para introducir la informacion(teclado)
        MiTeclado.hideSoftInputFromWindow(eAltura.getWindowToken(), 0);
        MiTeclado.hideSoftInputFromWindow(eBase.getWindowToken(), 0);

        if(eAltura.getText().toString().length()==0 || eBase.getText().toString().length()==0){eAltura.setError("This field is required");eBase.setError("This field is required");}
        else {
            eAltura.setInputType(InputType.TYPE_NULL);
            eBase.setInputType(InputType.TYPE_NULL);
            altura = Double.parseDouble(eAltura.getText().toString());
            base = Double.parseDouble(eBase.getText().toString());

            area = (base * altura) / 2;
            perimetro = base + altura + Math.sqrt((base * base) + (altura * altura));

            tTriangulo.setText("El TRIANGULO RECTANGULO de lados " + base.toString() + " y " + altura.toString() + " \nArea: " + area.toString() + "\nPerimetro: " + perimetro.toString());
        }

    }
}
