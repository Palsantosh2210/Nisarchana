package com.example.nisar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signin extends AppCompatActivity {
    public  static final String TAG = "TAG";
    TextInputEditText Name,Phone,Emails,Passwords,Confpass;
    TextInputLayout Nameh,Phoneh,Emailsh,Passwordsh,Confpassh;
    Button Signin;
    TextView Login;
    ProgressDialog progressDialog;
    String userId;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        Nameh = findViewById(R.id.namesignh);
        Phoneh= findViewById(R.id.phonesignh);
        Emailsh= findViewById(R.id.emailsignh);
        Passwordsh= findViewById(R.id.passsignh);
        Confpassh = findViewById(R.id.confpasssignh);
        Name = findViewById(R.id.namesignin);

        Phone = findViewById(R.id.phonesignin);
        Emails = findViewById(R.id.emailsignin);
        Passwords = findViewById(R.id.passignin);
        Confpass = findViewById(R.id.confpasssignin);
        Signin = findViewById(R.id.buttonsign);
        Login = findViewById(R.id.textViewsign);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if(firebaseAuth.getCurrentUser()!= null){
            startActivity( new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        //move to login

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, login.class);
                startActivity(intent);
                finish();
            }
        });

        // register

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = Name.getText().toString().trim();
                final String phone = Phone.getText().toString().trim();
                final String email = Emails.getText().toString().trim();
                final String password = Passwords.getText().toString().trim();
                final String confpas = Confpass.getText().toString().trim();

                if((email.isEmpty()) || (password.isEmpty()) || (name.isEmpty()) || (phone.isEmpty())){
                    Toast.makeText(signin.this, "Name or Phone number or Email or Password should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!(password.equals(confpas))){
                    Toast.makeText(signin.this, "password and confirm password should be same", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(),"Register Successfull", Toast.LENGTH_SHORT).show();

//4
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"OnFailure: Email not sent" + e.getMessage());
                                    //5
                                }
                            });

                            Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                            userId  = firebaseAuth.getUid();
                            DocumentReference documentReference = firebaseFirestore.collection("User").document(userId);
                            Map<String,Object> user= new HashMap<>();
                            user.put("fname",name);
                            user.put("phone",phone);
                            user.put("email",email);
                            user.put("password",password);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"On Success : user created" + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"On failure : user not created" + e.toString());
                                }
                            });
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);





//3
                        }
                        else {
                            Toast.makeText(signin.this,"Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }



                        //1
                    }
                });


//2
            }
        });





    }
}