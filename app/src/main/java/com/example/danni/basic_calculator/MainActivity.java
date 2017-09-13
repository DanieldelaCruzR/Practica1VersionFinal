package com.example.danni.basic_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private EditText eResultado;
    private TextView tAuxiliar;
    private LinearLayout lPrincipal;
    private Button bUno,bDos,bTres,bCuatro,bCinco,bSeis,bSiete,bOcho,bNueve,bCero;
    private Button bDiv,bMas,bMenos,bPor,bPunto,bIgual;
    private Double a,b,result;
    private Boolean fMas=false,fMenos=false,fPor=false,fDiv=false;
    private int count=0;
    private String display="",displayAux="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eResultado=(EditText)findViewById(R.id.eResultado);
        eResultado.setInputType(InputType.TYPE_NULL);

        tAuxiliar=(TextView)findViewById(R.id.tAuxiliar);

        bUno=(Button)findViewById(R.id.bUno);
        bDos=(Button)findViewById(R.id.bDos);
        bTres=(Button)findViewById(R.id.bTres);
        bCuatro=(Button)findViewById(R.id.bCuatro);
        bCinco=(Button)findViewById(R.id.bCinco);
        bSeis=(Button)findViewById(R.id.bSeis);
        bSiete=(Button)findViewById(R.id.bSiete);
        bOcho=(Button)findViewById(R.id.bOcho);
        bNueve=(Button)findViewById(R.id.bNueve);
        bCero=(Button)findViewById(R.id.bCero);

        bMas=(Button)findViewById(R.id.bMas);
        bMenos=(Button)findViewById(R.id.bMenos);
        bPor=(Button)findViewById(R.id.bPor);
        bDiv=(Button)findViewById(R.id.bDiv);
        bPunto=(Button)findViewById(R.id.bPunto);
        bIgual=(Button)findViewById(R.id.bIgual);




    }

    public void Uno(View view) {display+="1";tAuxiliar.setText(displayAux+="1");eResultado.setText(display); }
    public void Dos(View view) {display+="2";tAuxiliar.setText(displayAux+="2");eResultado.setText(display); }
    public void Tres(View view) {display+="3";tAuxiliar.setText(displayAux+="3");eResultado.setText(display); }
    public void Cuatro(View view) {display+="4";tAuxiliar.setText(displayAux+="4");eResultado.setText(display); }
    public void Cinco(View view) {display+="5";tAuxiliar.setText(displayAux+="5");eResultado.setText(display); }
    public void Seis(View view) {display+="6";tAuxiliar.setText(displayAux+="6");eResultado.setText(display); }
    public void Siete(View view) {display+="7";eResultado.setText(display);tAuxiliar.setText(displayAux+="7"); }
    public void Ocho(View view) {display+="8";eResultado.setText(display);tAuxiliar.setText(displayAux+="8"); }
    public void Nueve(View view) {display+="9";eResultado.setText(display);tAuxiliar.setText(displayAux+="9"); }
    public void Cero(View view) {display+="0";eResultado.setText(display);tAuxiliar.setText(displayAux+="0"); }
    public void Punto(View view) {display+=".";eResultado.setText(display);tAuxiliar.setText(displayAux+="."); }



    public void Mas(View view) {
        tAuxiliar.setText(displayAux+="+");
        if(fMas==false){
            a=Double.parseDouble(eResultado.getText().toString());
            fMas=true;
            display="";
            eResultado.setText(display);
        }
        else{
            a=a+Double.parseDouble(eResultado.getText().toString());
            display=a.toString();
            eResultado.setText(display);
            //fMas=false;
        }


    }
    public void Menos(View view) {

        tAuxiliar.setText(displayAux+="-");
        if(fMenos==false){
            a=Double.parseDouble(eResultado.getText().toString());
            fMenos=true;
            display="";
            eResultado.setText(display);
        }
        else{
            a=a-Double.parseDouble(eResultado.getText().toString());
            display=a.toString();
            eResultado.setText(display);
            fMenos=false;
        }


    }

    public void Por(View view) {
        tAuxiliar.setText(displayAux+="x");
        if(fPor==false){
            a=Double.parseDouble(eResultado.getText().toString());
            fPor=true;
            display="";
            eResultado.setText(display);
        }
        else{
            a=a*Double.parseDouble(eResultado.getText().toString());
            display=a.toString();
            eResultado.setText(display);
            fPor=false;
        }
    }
    public void Div(View view) {
        tAuxiliar.setText(displayAux+="/");
        if(fDiv==false){
            a=Double.parseDouble(eResultado.getText().toString());
            fDiv=true;
            display="";
            eResultado.setText(display);
        }
        else{
            a=a/Double.parseDouble(eResultado.getText().toString());
            display=a.toString();
            eResultado.setText(display);
            fDiv=false;
        }
    }

    public void Igual(View view){
        tAuxiliar.setText(displayAux+="=");
        if(fMas==true){a=a+Double.parseDouble(eResultado.getText().toString());fMas=false;display=a.toString();eResultado.setText(display);}
        if(fMenos==true){a=a-Double.parseDouble(eResultado.getText().toString());fMenos=false;display=a.toString();eResultado.setText(display);}
        if(fPor==true){a=a*Double.parseDouble(eResultado.getText().toString());fPor=false;display=a.toString();eResultado.setText(display);}
        if(fDiv==true){a=a/Double.parseDouble(eResultado.getText().toString());fDiv=false;display=a.toString();eResultado.setText(display);}

    }

    public void Limpiar(View view) {
        display="";
        eResultado.setText(display);
        tAuxiliar.setText(displayAux="");
        fMas=fMenos=fPor=fDiv=false;
        a=b=result=0.0;

    }
    public void LimpiarAux(View view){ Limpiar(view);}
}
