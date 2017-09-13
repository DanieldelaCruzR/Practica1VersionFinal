package com.example.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    private TextView tName, tEmail,tPassword, tCity,tDateBirth,tHobbies;
    //public EditText eUser2, ePassword, eEmail, mDisplayDate;
    private CheckBox cPassword;
    private ImageView imagen;
    private String username;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tName=(TextView)findViewById(R.id.tName);
        tEmail=(TextView)findViewById(R.id.tEmail);
        tPassword=(TextView)findViewById(R.id.tPassword);
        tCity=(TextView)findViewById(R.id.tCity);
        tDateBirth=(TextView)findViewById(R.id.tDateBirth);
        tHobbies=(TextView)findViewById(R.id.tHobbies);
        imagen=(ImageView)findViewById(R.id.imagen);
        cPassword=(CheckBox)findViewById(R.id.cPassword);

        bundle=getIntent().getExtras();

        tName.setText(bundle.getString("Name").toString());
        tEmail.setText(bundle.getString("Email").toString());
        tCity.setText(bundle.getString("Ciudad").toString());
        tPassword.setText("**PASSWORD**");

        tDateBirth.setText(bundle.getString("Fecha").toString());
        tHobbies.setText("Your Hobbies are: "+bundle.getString("Hobbies").toString());

        if (bundle.getString("Sexo").toString().equals("Male")){imagen.setImageResource(R.drawable.male);}
        if (bundle.getString("Sexo").toString().equals("Female")){imagen.setImageResource(R.drawable.female);}


    }

    public void check(View view) {
        if(cPassword.isChecked()){tPassword.setText(bundle.getString("Password").toString());}
        else{tPassword.setText("**PASSWORD**");}
    }
}
