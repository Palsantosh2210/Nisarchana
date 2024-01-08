package com.example.nisar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hiring extends AppCompatActivity {
    AutoCompleteTextView engineeringLabour;
    TextInputEditText name,phone ,email,age,education,state,district,experience;
    TextInputLayout nameout,phoneout ,emailout,ageout,educationout,stateout,districtout,experienceout,engineeringLabourout;
    Button ADD ;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String Registerf;

    String[] item={"Civil Engineer", "Labour"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    Spinner spinnerV;
    DatabaseReference spinnerRef;
    ArrayList<String> spinnerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring);


        //spinnerV= findViewById(R.id.spinner);
        spinnerRef= FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList=new ArrayList<>();
        adapterItems=new ArrayAdapter<String>(Hiring.this, android.R.layout.simple_spinner_dropdown_item,spinnerList);




        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
       adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);
       autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item= adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Hiring.this, "+ item", Toast.LENGTH_SHORT).show();

            }
        });

        nameout = findViewById(R.id.nameout);
        phoneout  = findViewById(R.id.phoneout);
        emailout  = findViewById(R.id.emailout);
        ageout  = findViewById(R.id.ageout);
        educationout  = findViewById(R.id.educationout);
        stateout = findViewById(R.id.stateout);
        districtout = findViewById(R.id.districtout);
        experienceout = findViewById(R.id.experienceout);
        engineeringLabourout =findViewById(R.id.dropdown);


        name = findViewById(R.id.name);
        phone  = findViewById(R.id.phone);
        email  = findViewById(R.id.email);
        age  = findViewById(R.id.age);
        education  = findViewById(R.id.education);
        state = findViewById(R.id.state);
        district = findViewById(R.id.district);
        experience = findViewById(R.id.experience);
       engineeringLabour =findViewById(R.id.auto_complete_txt);
        ADD = findViewById(R.id.buttonjoin);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String age1 = age.getText().toString().trim();
                String education1 = education.getText().toString().trim();
                String state1 = state.getText().toString().trim();
                String district1 = district.getText().toString().trim();
                String experience1 = experience.getText().toString().trim();
                String engineeringLabour1 = engineeringLabour.getText().toString().trim();





                if (name1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Name should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (phone1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Phone should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (email1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (age1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Age should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (education1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " name should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (state1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (district1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (experience1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (engineeringLabour1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {


                    Map<String, Object> regfa = new HashMap<>();
                    regfa.put("name", name1);
                    regfa.put("phone", phone1);
                    regfa.put("email", email1);
                    regfa.put("age", age1);
                    regfa.put("education", education1);
                    regfa.put("state", state1);
                    regfa.put("district", district1);
                    regfa.put("experience", experience1);
                    //regfa.put("engineeringLabour", engineeringLabour1);


                    firebaseFirestore.collection("RegisterEngi").add(regfa).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Toast.makeText(Hiring.this, "Sucessfully stored", Toast.LENGTH_SHORT).show();
                            name.setText("");
                            phone.setText("");
                            email.setText("");
                            age.setText("");
                            education.setText("");
                            state.setText("");
                            district.setText("");
                            experience.setText("");
                            engineeringLabour.setText("");
                            
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Hiring.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });


    }
   public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Activity activity = (Activity) parent.getContext();
        Intent myIntent = new Intent();
        if (pos == 0) {
            startActivity( new Intent(getApplicationContext(),CivilEngineer.class));
            finish();
            //myIntent.setClassName(activity, CivilEngineer.class);
        } else if (pos == 1) {
            startActivity( new Intent(getApplicationContext(),Labour.class));
            finish();
            //myIntent.setClassName(activity, Labour.class);
        }
        activity.startActivity(myIntent);
    }


}










