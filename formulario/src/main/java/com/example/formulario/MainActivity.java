package com.example.formulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.regex.Pattern;

import static android.R.attr.tag;
import static com.example.formulario.R.string.email;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    private Spinner sCiudades;
    private String sexo="Male",hobbies,ciudad;
    private ArrayAdapter<CharSequence> adapter;
    private TextView mDisplayDate;
    public EditText eEmail,ePassword,eRPassword,eUser;
    private Boolean Continue=false;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private CheckBox cSwim,cRun,cWrite,cRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eEmail=(EditText)findViewById(R.id.eEmail);
        ePassword=(EditText)findViewById(R.id.ePassword);
        eRPassword=(EditText)findViewById(R.id.eRPassword);
        eUser=(EditText)findViewById(R.id.eUser);
        cSwim=(CheckBox)findViewById(R.id.cSwim);
        cRun=(CheckBox)findViewById(R.id.cRun);
        cRead=(CheckBox)findViewById(R.id.cRead);
        cWrite=(CheckBox)findViewById(R.id.cWrite);



        ///Spineer
        sCiudades = (Spinner) findViewById(R.id.sCiudades);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.ciudades , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCiudades.setAdapter(spinner_adapter);
        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Resources res = getResources();
                String[] ciudades = res.getStringArray(R.array.ciudades);
                ciudad=ciudades[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}});

        //DatePicker
        mDisplayDate = (TextView) findViewById(R.id.tDAte);
        mDisplayDate.setInputType(InputType.TYPE_NULL);
        mDisplayDate.setText("Date");
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            Calendar cal = Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH);
            int day=cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    MainActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,
                    year,month,day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }});
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(String.valueOf(tag),"onDateSet: mm/dd/yyyy: "+month+"/"+day+"/"+year );
                String date=day+"/"+month+"/"+year;
                mDisplayDate.setText(date);

            }
        };



    }
        //Validar Correo
        public Boolean validarEmail(String email) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            return pattern.matcher(email).matches();
        }


    public void onRadioButtonClicked(View view) {
        int id=view.getId();

        if(id==R.id.rMasculino){sexo="Female";}
        if(id==R.id.rFemenino){sexo="Male";}
    }

    public void RegisterButton(View view) {
        if(eUser.getText().toString().length()==0){eUser.setError("This field is required");Continue=false;}else{Continue=true;}
        if(ePassword.getText().toString().length()==0){ePassword.setError("This field is required");Continue=false;}
        if(eRPassword.getText().toString().length()==0){eRPassword.setError("This field is required");Continue=false;}
        if(eEmail.getText().toString().length()==0){eEmail.setError("This field is required");Continue=false;}
        if(mDisplayDate.getText().toString().length()==0){mDisplayDate.setError("This field is required");Continue=false;}
        if(!validarEmail(eEmail.getText().toString())){eEmail.setError("Invalid Email");Continue=false;}else{Continue=true;}
        if(eRPassword.getText().toString().equals(ePassword.getText().toString())
                && ePassword.getText().toString().length()!=0 && eRPassword.getText().toString().length()!=0){
            Continue=true;
        }
        else{
            eRPassword.setError("Passwords don't match");
            ePassword.setError("Passwords don't match");
            Continue=false;
        }

        hobbies=" ";
        if(cSwim.isChecked()){hobbies+="Swim ";}
        if(cRun.isChecked()){hobbies+="Run ";}
        if(cRead.isChecked()){hobbies+="Read ";}
        if(cWrite.isChecked()){hobbies+="Write ";}

        if(Continue){
            Intent next =new Intent(MainActivity.this, Main2Activity.class);
            next.putExtra("Name",eUser.getText().toString());
            next.putExtra("Password",ePassword.getText().toString());
            next.putExtra("Email",eEmail.getText().toString());
            next.putExtra("Fecha",mDisplayDate.getText().toString());
            next.putExtra("Hobbies", hobbies);
            next.putExtra("Sexo",sexo);
            next.putExtra("Ciudad",ciudad);


            startActivity(next);}




    }
}

