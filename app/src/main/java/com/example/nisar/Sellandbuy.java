package com.example.nisar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
public class Sellandbuy extends AppCompatActivity {
    //NavigationView navigationView;
    Toolbar toolbar;

    RecyclerView recyclerView;
    ArrayList<modelsell> labList;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    selleradapter selleradapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellandbuy);

        recyclerView = (RecyclerView) findViewById(R.id.landseller);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        labList = new ArrayList<>();
        selleradapter1 = new selleradapter(labList);
        recyclerView.setAdapter(selleradapter1);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        DatabaseReference getImage = databaseReference.child("images/");

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("RegisterSeller").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d: list)
                {
                    modelsell obj = d.toObject(modelsell.class);
                    labList.add(obj);
                }

                //update adapter
                selleradapter1.notifyDataSetChanged();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Sellandbuy.this,"Error" +e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


        toolbar = findViewById(R.id.toolar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dosell, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id1 = item.getItemId();
        if(id1 == R.id.Sell){
            startActivity( new Intent(getApplicationContext(),sell.class) );

        }

        else {
           startActivity( new Intent(getApplicationContext(),developer.class) );

        }

        return true;
    }

}






