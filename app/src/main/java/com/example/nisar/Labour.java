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

public class Labour extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<modelfar> labList;
    FirebaseFirestore firebaseFirestore;
    labouradapter labadapter1;
    TextView textView;
    ImageView Setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour);

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



    recyclerView = (RecyclerView) findViewById(R.id.labur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        labList = new ArrayList<>();
        labadapter1 = new labouradapter(labList);
        recyclerView.setAdapter(labadapter1);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("RegisterEngi2").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d: list)
                {
                    modelfar obj = d.toObject(modelfar.class);
                    labList.add(obj);
                }

                //update adapter
                labadapter1.notifyDataSetChanged();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Labour.this,"Error" +e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });




    }
    private void openActivity3() {
        Intent intent = new Intent(Labour.this, Labour.class);
        startActivity(intent);
    }

    private void openActivity1() {
        Intent intent = new Intent(Labour.this, CivilEngineer.class);
        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(Labour.this, SettingsActivity.class);
        startActivity(intent);

    }
}