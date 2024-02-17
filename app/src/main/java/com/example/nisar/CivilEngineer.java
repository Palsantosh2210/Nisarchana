package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
public class CivilEngineer extends AppCompatActivity {
    RecyclerView recylerfar;
    ArrayList<modelfar> farmertlist;
    FirebaseFirestore firebaseFirestore;
    engiadapter engiadapter1;
    TextView textView;
    ImageView Setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_engineer);
        recylerfar = (RecyclerView) findViewById(R.id.receiveEngineer);
        recylerfar.setLayoutManager(new LinearLayoutManager(this));

        Setting = findViewById(R.id.imageButton2);
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        textView =findViewById(R.id.engineer);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity1();

            }
        });
        textView =findViewById(R.id.labour);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity3();

            }
        });


    farmertlist = new ArrayList<>();
        engiadapter1 = new engiadapter(farmertlist);
        recylerfar.setAdapter(engiadapter1);


        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("RegisterEngi")
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<DocumentSnapshot> farlist = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d:farlist)
                        {
                            modelfar obj = d.toObject(modelfar.class);
                            farmertlist.add(obj);
                        }

                        //update adapter

                        engiadapter1.notifyDataSetChanged();



                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CivilEngineer.this,"Error" +e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });








    }
    private void openActivity3() {
        Intent intent = new Intent(CivilEngineer.this, Labour.class);
        startActivity(intent);
    }

    private void openActivity1() {
        Intent intent = new Intent(CivilEngineer.this, CivilEngineer.class);
        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(CivilEngineer.this, SettingsActivity.class);
        startActivity(intent);

    }

}


