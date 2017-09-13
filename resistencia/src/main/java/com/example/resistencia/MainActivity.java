package com.example.resistencia;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioButton rBanda1,rBanda2,rBanda3;
    private Spinner sTolerancia;
    private TextView tResistencia;
    private LinearLayout lBanda1,lBanda2,lBanda3,lTolerancia;
    private String tol=" ±1%";
    private int banda=1,b1=10,b2=0,b3=0,ResistValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().hide();

        rBanda1=(RadioButton)findViewById(R.id.rBanda1);
        rBanda2=(RadioButton)findViewById(R.id.rBanda2);
        rBanda3=(RadioButton)findViewById(R.id.rBanda3);
        sTolerancia=(Spinner)findViewById(R.id.sTolerancia);
        tResistencia=(TextView)findViewById(R.id.tResistencia);
        lBanda1=(LinearLayout)findViewById(R.id.lBanda1);
        lBanda2=(LinearLayout)findViewById(R.id.lBanda2);
        lBanda3=(LinearLayout)findViewById(R.id.lBanda3);
        lTolerancia=(LinearLayout)findViewById(R.id.lTolerancia);



        sTolerancia = (Spinner) findViewById(R.id.sTolerancia);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.tolerancia_array , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTolerancia.setAdapter(spinner_adapter);
        sTolerancia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){lTolerancia.setBackgroundColor(Color.rgb(153,51,0));tol=" ±1%";}
                if(position==1){lTolerancia.setBackgroundColor(Color.rgb(255,0,0));tol=" ±2%";}
                if(position==2){lTolerancia.setBackgroundColor(Color.rgb(212,175,55));tol=" ±5%";}
                if(position==3){lTolerancia.setBackgroundColor(Color.rgb(192,192,192));tol=" ±10%";}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});



    }


    public String calcular(int b1, int b2, int b3){
        float result=0;
        String display="Ohm";

       // if(b3<100000000){
            result=(b1+b2)*b3;
            if(result<1000){display=Float.toString(result)+" Ohm";return display;}
            if(result>=1000 && result<1000000){result/=1000; display=Float.toString(result)+"K Ohm"; return display;}
            if(result>=1000000){result/=1000000; display=Float.toString(result)+"M Ohm"; return display;}
        //}

        return display;
    }

    public void onRadioButtonClicked(View view) {
        int id=view.getId();
        if(id==R.id.rBanda1){banda=1;}
        if(id==R.id.rBanda2){banda=2;}
        if(id==R.id.rBanda3){banda=3;}
    }

    public void NegroClick(View view) {
        if(banda==1){b1=0;lBanda1.setBackgroundColor(Color.rgb(0,0,0));}
        if(banda==2){b2=0;lBanda2.setBackgroundColor(Color.rgb(0,0,0));}
        if(banda==3){b3=1;lBanda3.setBackgroundColor(Color.rgb(0,0,0));}
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void MarronClick(View view) {
        if(banda==1){b1=10;lBanda1.setBackgroundColor(Color.rgb(153,51,0));}
        if(banda==2){b2=1;lBanda2.setBackgroundColor(Color.rgb(153,51,0));}
        if(banda==3){b3=10;lBanda3.setBackgroundColor(Color.rgb(153,51,0));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void RojoClick(View view) {
        if(banda==1){b1=20;lBanda1.setBackgroundColor(Color.rgb(255,0,0));}
        if(banda==2){b2=2;lBanda2.setBackgroundColor(Color.rgb(255,0,0));}
        if(banda==3){b3=100;lBanda3.setBackgroundColor(Color.rgb(255,0,0));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void NaranjaClick(View view) {
        if(banda==1){b1=30;lBanda1.setBackgroundColor(Color.rgb(255,153,0));}
        if(banda==2){b2=3;lBanda2.setBackgroundColor(Color.rgb(255,153,0));}
        if(banda==3){b3=1000;lBanda3.setBackgroundColor(Color.rgb(255,153,0));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void AmarilloClick(View view) {
        if(banda==1){b1=40;lBanda1.setBackgroundColor(Color.rgb(255,255,0));}
        if(banda==2){b2=4;lBanda2.setBackgroundColor(Color.rgb(255,255,0));}
        if(banda==3){b3=10000;lBanda3.setBackgroundColor(Color.rgb(255,255,0));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void VerdeClick(View view) {
        if(banda==1){b1=50;lBanda1.setBackgroundColor(Color.rgb(0,204,0));}
        if(banda==2){b2=5;lBanda2.setBackgroundColor(Color.rgb(0,204,0));}
        if(banda==3){b3=100000;lBanda3.setBackgroundColor(Color.rgb(0,204,0));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void AzulClick(View view) {
        if(banda==1){b1=60;lBanda1.setBackgroundColor(Color.rgb(0,51,204));}
        if(banda==2){b2=6;lBanda2.setBackgroundColor(Color.rgb(0,51,204));}
        if(banda==3){b3=1000000;lBanda3.setBackgroundColor(Color.rgb(0,51,204));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void MoradoClick(View view) {
        if(banda==1){b1=70;lBanda1.setBackgroundColor(Color.rgb(128,0,128));}
        if(banda==2){b2=7;lBanda2.setBackgroundColor(Color.rgb(128,0,128));}
        if(banda==3){b3=10000000;lBanda3.setBackgroundColor(Color.rgb(128,0,128));}
        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void GrisClick(View view) {
        if(banda==1){b1=80;lBanda1.setBackgroundColor(Color.rgb(102,102,102));}
        if(banda==2){b2=8;lBanda2.setBackgroundColor(Color.rgb(102,102,102));}

        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }
    public void BlancoClick(View view) {
        if(banda==1){b1=90;lBanda1.setBackgroundColor(Color.rgb(255,255,255));}
        if(banda==2){b2=9;lBanda2.setBackgroundColor(Color.rgb(255,255,255));}

        ResistValue=(b1+b2)*b3;
        tResistencia.setText(calcular(b1,b2,b3)+tol);
    }


}
