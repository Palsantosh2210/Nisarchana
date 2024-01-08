package com.example.nisar;


import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class sell extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_CAMERA_REQUEST = 0;

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
    private TextView Imagetag;

    TextInputEditText sellername, sellerphone, sellerprice, sellerstate, sellerdistrict;
    TextInputLayout sellernameout, sellerphoneout, sellerpriceout, sellerstateout, sellerdistrictout;
    Button Sell;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String Registerf;


    // views for button
    private Button btnSelect, btnUpload;

    // view for image view


    // Uri indicates, where the image will be picked from
    private Uri filePath;

    // request code


    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        sellernameout = findViewById(R.id.sellernameout);
        sellerphoneout = findViewById(R.id.sellerphoneout);

        sellerpriceout = findViewById(R.id.sellerpriceout);
        sellerstateout = findViewById(R.id.sellerstateout);
        sellerdistrictout = findViewById(R.id.sellerdistrictout);

        ImageButton imageButton = findViewById(R.id.imageButton2);

        sellername = findViewById(R.id.sellername);
        sellerphone = findViewById(R.id.sellerphone);

        sellerprice = findViewById(R.id.sellerprice);
        sellerstate = findViewById(R.id.sellerstate);
        sellerdistrict = findViewById(R.id.sellerdistrict);

        Imagetag = findViewById(R.id.Image_tag);

        Sell = findViewById(R.id.sell);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

       Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sellername1 = sellername.getText().toString().trim();
                String sellerphone1 = sellerphone.getText().toString().trim();

                String sellerprice1 = sellerprice.getText().toString().trim();
                String sellerstate1 = sellerstate.getText().toString().trim();
                String sellerdistrict1 = sellerdistrict.getText().toString().trim();


                if (sellername1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Name should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (sellerphone1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Address should not be empty", Toast.LENGTH_SHORT).show();
                    return;

                } else if (sellerprice1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Price should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (sellerstate1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "StateDistrict value should not be empty", Toast.LENGTH_SHORT).show();
                    return;
                } else if (sellerdistrict1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Rainfall value should not be empty", Toast.LENGTH_SHORT).show();
                    return;

                } else {


                    Map<String, Object> regfa = new HashMap<>();
                    regfa.put("sellername", sellername1);
                    regfa.put("sellerphone", sellerphone1);
                    regfa.put("sellerprice", sellerprice1);
                    regfa.put("sellerstate", sellerstate1);
                    regfa.put("sellerdistrict", sellerdistrict1);


                    firebaseFirestore.collection("RegisterSeller").add(regfa).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                            Toast.makeText(sell.this, "Sucessfully stored", Toast.LENGTH_SHORT).show();
                            sellername.setText("");
                            sellerphone.setText("");
                            sellerprice.setText("");
                            sellerstate.setText("");
                            sellerdistrict.setText("");


                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(sell.this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });


       ActionBar actionBar;
       actionBar = getSupportActionBar();
     /*  ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#0F9D58"));
       actionBar.setBackgroundDrawable(colorDrawable);*/

        // initialise views
        btnSelect = findViewById(R.id.button_choose_image);
        btnUpload = findViewById(R.id.upload);
        imageView = findViewById(R.id.imgView);

        // get the Firebase storage reference
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        // on pressing btnSelect SelectImage() is called
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
        startActivityForResult(Intent.createChooser(intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            //cropImage();

            Picasso.with(getActivity()).load(mImageUri).into(mImageView);
        }
        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
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
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "images/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(sell.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(sell.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int) progress + "%");
                                }
                            });
        }

    }

   private void cropImage() {
        try {
            Intent cropIntent;

            cropIntent = new Intent("com.android.camera.action.CROP");
            cropIntent.setDataAndType(mImageUri, "image/*");

            cropIntent.putExtra("crop", " true");
            cropIntent.putExtra("outputx", 180);
            cropIntent.putExtra("outputY", 180);
            cropIntent.putExtra("aspectx", 3);
            cropIntent.putExtra("aspecty", 4);
            cropIntent.putExtra("scaleUpIfNeeded", true);
            cropIntent.putExtra("return-data ", true);

            startActivityForResult(cropIntent, 1);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
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
    }




