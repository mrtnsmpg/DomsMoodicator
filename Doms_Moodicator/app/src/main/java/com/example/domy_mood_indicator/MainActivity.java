package com.example.domy_mood_indicator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mUsername, mPassword;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        submit = findViewById(R.id.submitBtn);

        CRUDFunctions crudFunctions = new CRUDFunctions();
        submit.setOnClickListener(v->{

                    UserData userData = new UserData(mUsername.getText().toString(), mPassword.getText().toString());
                    crudFunctions.add(userData).addOnSuccessListener(suc->{
                        Toast.makeText(getApplicationContext(), "Record is inserted", Toast.LENGTH_LONG).show();

                    }).addOnFailureListener(er->{
                        Toast.makeText(getApplicationContext(), ""+er.getMessage(), Toast.LENGTH_LONG).show();
                    });

                }
        );

    }
}