package com.example.loginapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    TextView reg;
    ArrayList<String> user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.user_Id);
        e2 = findViewById(R.id.password_id);
        b1 = findViewById(R.id.login_id);
        reg = findViewById(R.id.reg_id);

         /*final String u1[] = {"user1","user2","user3"};
         final String p1[] = {"userp1","userp2","userp3"};
         final int end = u1.length;*/
         user = new ArrayList<>();
         password = new ArrayList<>();




        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUser();

            }
        });
    }

    private void checkUser() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String getUser = bundle.getString("User");
            String getPass = bundle.getString("Password");

            user.add(getUser);
            password.add(getPass);

            for (int i = 0; i < user.size() ; i++) {
                if (e1.getText().toString().trim().equals(user.get(i)) &&
                        e2.getText().toString().trim().equals(password.get(i))){
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "User and Password not found", Toast.LENGTH_SHORT).show();
                }
            }
        }else {
            Toast.makeText(this, "No User Found", Toast.LENGTH_SHORT).show();
        }

    }

}
