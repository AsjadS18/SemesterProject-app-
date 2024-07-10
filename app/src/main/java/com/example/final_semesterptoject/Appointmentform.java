package com.example.final_semesterptoject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Appointmentform extends AppCompatActivity {

    private EditText reasonEditText, whenEditText, firstNameEditText, lastNameEditText, emailEditText, additionalInfoEditText;
    private Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentform);
        submit=(Button) findViewById(R.id.submitButton);
    }
    public void process(View v)
    {
        reasonEditText = findViewById(R.id.reason);
        whenEditText = findViewById(R.id.when);
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        emailEditText = findViewById(R.id.email);
        additionalInfoEditText = findViewById(R.id.additionalInfo);


        String reason = reasonEditText.getText().toString();
        String date= whenEditText.getText().toString();
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String additionalInfo = additionalInfoEditText.getText().toString();

        dataholder obj= new dataholder(reason,date);

        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Appointmentform");
        node.child(firstName).setValue(obj);

        Toast.makeText(getApplicationContext(), "Form Submitted", Toast.LENGTH_SHORT).show();
    }

}
