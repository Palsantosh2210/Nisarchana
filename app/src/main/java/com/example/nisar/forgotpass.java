package com.example.nisar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class forgotpass extends AppCompatActivity {


    TextInputEditText emailforget;
    TextInputLayout emailforgh;
    Button submit;
    TextView logforg;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);


        emailforget = findViewById(R.id.emailforget);
        emailforgh = findViewById(R.id.emailforgeth);
        submit = findViewById(R.id.buttonforget);
        logforg = findViewById(R.id.loginforget);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        logforg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailfor = emailforget.getText().toString().trim();

                if(emailfor.isEmpty()){
                    Toast.makeText(forgotpass.this, "Email should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    firebaseAuth.sendPasswordResetEmail(emailfor).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(forgotpass.this, "Email is send on our email please verify", Toast.LENGTH_SHORT).show();
                                Toast.makeText(forgotpass.this, "Link will expire soon please verify as soon as possible", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(forgotpass.this,login.class));
                                finish();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }







            }
        });






    }
}