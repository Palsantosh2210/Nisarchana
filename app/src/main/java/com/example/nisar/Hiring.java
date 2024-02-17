package com.example.nisar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hiring extends AppCompatActivity {
    private static final int PICK_CAMERA_REQUEST = 0;
    private final int PICK_IMAGE_REQUEST = 22;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;
    Uri uri;
    private ImageView imageView;
    private String PhotoUrl;
    private Button btnSelect, btnUpload;
    private Uri filePath;
    private TextView Imagetag;
    FirebaseStorage storage;
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    StorageReference storageReference;




    AutoCompleteTextView engineeringLabour;
    TextInputEditText name,phone ,email,age,education,state,district,experience;
    TextInputLayout nameout,phoneout ,emailout,ageout,educationout,stateout,districtout,experienceout,engineeringLabourout;
    Button ADD ;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String Registerf;
    String item1;

    String[] item={"Civil Engineer", "Labour"};
    // AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    Spinner spinnerV;
    DatabaseReference spinnerRef;
    ArrayList<String> spinnerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiring);

        btnSelect = findViewById(R.id.button_choose_image);
        btnUpload = findViewById(R.id.upload);
        imageView = findViewById(R.id.imgView);

        // get the Firebase storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        ImageView  imageButton = findViewById(R.id.imageButton2);
        Imagetag = findViewById(R.id.Image_tag);



        //spinnerV= findViewById(R.id.spinner);
        spinnerRef= FirebaseDatabase.getInstance().getReference("Spinner Data");
        spinnerList=new ArrayList<>();
        adapterItems=new ArrayAdapter<String>(Hiring.this, android.R.layout.simple_spinner_dropdown_item,spinnerList);

        engineeringLabour= findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);
        engineeringLabour.setAdapter(adapterItems);
        engineeringLabour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item= adapterView.getItemAtPosition(i).toString();
                item1= item;
                //  Toast.makeText(Hiring.this, "+ item"+ item, Toast.LENGTH_SHORT).show();
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
            public void onClick(View view) {

                if (PhotoUrl.length() != 0) {

                String name1 = name.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String age1 = age.getText().toString().trim();
                String education1 = education.getText().toString().trim();
                String state1 = state.getText().toString().trim();
                String district1 = district.getText().toString().trim();
                String experience1 = experience.getText().toString().trim();
                String engineeringLabour1 = engineeringLabour.getText().toString().trim();
                String item2 = item1;


                    String image = PhotoUrl + ".jpg";

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
                }else if (image.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Rainfall value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if(item2 == item[0]){
                        Map<String, Object> regfa = new HashMap<>();
                        regfa.put("name", name1);
                        regfa.put("phone", phone1);
                        regfa.put("email", email1);
                        regfa.put("age", age1);
                        regfa.put("education", education1);
                        regfa.put("state", state1);
                        regfa.put("district", district1);
                        regfa.put("experience", experience1);
                        regfa.put("engineeringLabour", item2);

                        regfa.put("image", image);

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
                                Imagetag.setText("");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Hiring.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        //end
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
                        regfa.put("engineeringLabour", item2);

                        regfa.put("image", image);

                        firebaseFirestore.collection("RegisterEngi2").add(regfa).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
                                Imagetag.setText("");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Hiring.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        //end
                    }
                    }
                    return;
                } else {
                        Toast.makeText(getApplicationContext(), "first image", Toast.LENGTH_SHORT).show();
                        return;




                }

            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });

        // on pressing btnUpload uploadImage() is called
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }





    // Select Image method
    private void SelectImage() {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image from here..."), PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }

    // UploadImage method
    private void uploadImage() {
        if (filePath != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref = storageReference.child("images/" + filePath.getLastPathSegment());
            //UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    if (uri != null) {
                                        PhotoUrl = uri.toString();
                                    }
                                }
                            });

                            // Image uploaded successfully
                            // Dismiss dialog
                            progressDialog.dismiss();
                            Toast.makeText(Hiring.this, "Image Uploaded!!", Toast.LENGTH_SHORT).show();
                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@org.checkerframework.checker.nullness.qual.NonNull Exception e) {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast.makeText(Hiring.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {

                        // Progress Listener for loading
                        // percentage on the dialog box
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()
                                    / taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }

    }

    private Context getActivity() {
        return null;
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        Activity activity = (Activity) parent.getContext();
        Intent myIntent = new Intent();
        if (i == 0) {
            startActivity( new Intent(getApplicationContext(),CivilEngineer.class));
            finish();
            //myIntent.setClassName(activity, CivilEngineer.class);
        } else if (i == 1) {
            startActivity( new Intent(getApplicationContext(),Labour.class));
            finish();
            //myIntent.setClassName(activity, Labour.class);
        }
        activity.startActivity(myIntent);
    }

}

