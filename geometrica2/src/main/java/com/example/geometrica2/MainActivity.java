package com.example.geometrica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int actividad=1;
    private Button bListo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bListo = (Button)findViewById(R.id.bListo);

    }

    public void onRadioButtonClicked(View view) {
        int id=view.getId();

        if(id==R.id.rCirculo){actividad=1;}
        if(id==R.id.rCuadrado){actividad=2;}
        if(id==R.id.rCubo){actividad=3;}
        if(id==R.id.rTriangulo){actividad=4;}
    }

    public void Listo(View view) {

        switch (actividad){
            case 1:
                Intent siguiente = new Intent(MainActivity.this, CirculoActivity.class);
                startActivity(siguiente);
                break;
            case 2:
                Intent siguiente2 = new Intent(MainActivity.this, CuadradoActivity.class);
                startActivity(siguiente2);
                break;
            case 3:
                Intent siguiente3 = new Intent(MainActivity.this, CuboActivity.class);
                startActivity(siguiente3);
                break;
            case 4:
                Intent siguiente4 = new Intent(MainActivity.this, TrianguloActivity.class);
                startActivity(siguiente4);
                break;
        }
    }
}