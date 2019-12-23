package com.example.loginapp2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView dateandtime;
    EditText username,password;
    Button register;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        dateandtime = findViewById(R.id.date_time_id);
        username = findViewById(R.id.userename_id);
        password = findViewById(R.id.user_password);
        register = findViewById(R.id.reges_id);
        
        dateandtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateDailog();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("User",user);
                intent.putExtra("Password",pass);
                startActivity(intent);
            }
        });
    }

    private void dateDailog() { //cant understand the parameter (1,2) . Is there any other data picker?
        DatePickerDialog datePicker = new DatePickerDialog(this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DATE));
        datePicker.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth+ "/"+(month+1)+"/"+year;
        dateandtime.setText(date);
    }
}
