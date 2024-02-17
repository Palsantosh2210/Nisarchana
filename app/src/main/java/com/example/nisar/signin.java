package com.example.nisar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class signin extends AppCompatActivity {
    public static final String TAG = "TAG";
    TextInputEditText Name, Phone, Emails, Passwords, Confpass,Otp;
    TextInputLayout Nameh, Phoneh, Emailsh, Passwordsh, Confpassh,Otph;
    Button Signin;
    TextView Login;
    ProgressDialog progressDialog;
    String userId;
    private FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;


    //private FirebaseAuth firebaseAuth ;

    // variable for our text input
    // field for phone and OTP.
   // private EditText edtPhone, edtOTP;

    // buttons for generating OTP and verifying OTP
    private Button verifyOTPBtn, generateOTPBtn;

    // string for storing our verification ID
    private String verificationId;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // below line is for getting instance
        // of our FirebaseAuth.
        //firebaseAuth = FirebaseAuth.getInstance();

        // initializing variables for button and Edittext.
        //edtPhone = findViewById(R.id.idEdtPhoneNumber);
        Otp = findViewById(R.id.idEdtOtp);
        verifyOTPBtn = findViewById(R.id.idBtnVerify);
        generateOTPBtn = findViewById(R.id.idBtnGetOtp);

        Nameh = findViewById(R.id.namesignh);
        Phoneh = findViewById(R.id.phonesignh);
        Emailsh = findViewById(R.id.emailsignh);
        Passwordsh = findViewById(R.id.passsignh);
        Confpassh = findViewById(R.id.confpasssignh);
        Name = findViewById(R.id.namesignin);

        Phone = findViewById(R.id.phonesignin);
        Emails = findViewById(R.id.emailsignin);
        Passwords = findViewById(R.id.passignin);
        Confpass = findViewById(R.id.confpasssignin);
        Signin = findViewById(R.id.buttonsign);
        Login = findViewById(R.id.textViewsign);
        Otph=findViewById(R.id.idEdtOtph);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), contentmain.class));
            finish();
        }



        // register

        Signin.setOnClickListener(new View.OnClickListener()

                                  {
                                      @Override
                                      public void onClick (View v){
                                          final String name = Name.getText().toString().trim();
                                          final String phone = Phone.getText().toString().trim();
                                          final String email = Emails.getText().toString().trim();
                                          final String password = Passwords.getText().toString().trim();
                                          final String confpas = Confpass.getText().toString().trim();

                                          if ((email.isEmpty()) || (password.isEmpty()) || (name.isEmpty()) || (phone.isEmpty())) {
                                              Toast.makeText(signin.this, "Name or Phone number or Email or Password should not be empty", Toast.LENGTH_SHORT).show();
                                              return;
                                          } else if (!(password.equals(confpas))) {
                                              Toast.makeText(signin.this, "password and confirm password should be same", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                                          firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                              @Override
                                              public void onComplete(@NonNull Task<AuthResult> task) {
                                                  if (task.isSuccessful()) {
                                                      FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                                      firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                          @Override
                                                          public void onSuccess(Void unused) {
                                                              Toast.makeText(getApplicationContext(), "Register Successfull", Toast.LENGTH_SHORT).show();

//4
                                                          }
                                                      }).addOnFailureListener(new OnFailureListener() {
                                                          @Override
                                                          public void onFailure(@NonNull Exception e) {
                                                              Log.d(TAG, "OnFailure: Email not sent" + e.getMessage());
                                                              //5
                                                          }
                                                      });

                                                      Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                                                      userId = firebaseAuth.getUid();
                                                      DocumentReference documentReference = firebaseFirestore.collection("User").document(userId);
                                                      Map<String, Object> user = new HashMap<>();
                                                      user.put("fname", name);
                                                      user.put("phone", phone);
                                                      user.put("email", email);
                                                      user.put("password", password);
                                                      documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                          @Override
                                                          public void onSuccess(Void unused) {
                                                              Log.d(TAG, "On Success : user created" + userId);
                                                          }
                                                      }).addOnFailureListener(new OnFailureListener() {
                                                          @Override
                                                          public void onFailure(@NonNull Exception e) {
                                                              Log.d(TAG, "On failure : user not created" + e.toString());
                                                          }
                                                      });
                                                      Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                      startActivity(intent);


//3
                                                  } else {
                                                      Toast.makeText(signin.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                  }


                                                  //1
                                              }
                                          });

                                          //move to login

                                          Login.setOnClickListener(new View.OnClickListener()

                                          {
                                              @Override
                                              public void onClick (View v){
                                                  Intent intent = new Intent(signin.this, login.class);
                                                  startActivity(intent);
                                                  finish();
                                              }
                                          });
//2
                                      }
                                  });

        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is for checking whether the user
                // has entered his mobile number or not.
                if (TextUtils.isEmpty(Phone.getText().toString())) {
                    // when mobile number text field is empty
                    // displaying a toast message.
                    Toast.makeText(signin.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    // if the text field is not empty we are calling our
                    // send OTP method for getting OTP from Firebase.
                    String phone = "+91" + Phone.getText().toString();
                    sendVerificationCode(phone);
                }
            }
        });

        // initializing on click listener
        // for verify otp button
        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the OTP text field is empty or not.
                if (TextUtils.isEmpty(Otp.getText().toString())) {
                    // if the OTP text field is empty display
                    // a message to user to enter OTP
                    Toast.makeText(signin.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    // if OTP field is not empty calling
                    // method to verify the OTP.
                    verifyCode(Otp.getText().toString());
                }
            }
        });
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // if the code is correct and the task is successful
                            // we are sending our user to new activity.
                            /*Intent i = new Intent(signin.this, signin.class);
                            startActivity(i);
                            finish();*/
                            Toast.makeText(signin.this, "Phone Number Verified", Toast.LENGTH_SHORT).show();
                        } else {
                            // if the code is not correct then we are
                            // displaying an error message to the user.
                            Toast.makeText(signin.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    private void sendVerificationCode(String number) {
        // this method is used for getting
        // OTP on user phone number.
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(number)         // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)         // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    // callback method is called on Phone auth provider.
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            // initializing our callbacks for on
            // verification callback method.
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // below method is used when
        // OTP is sent from Firebase
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            // when we receive the OTP it
            // contains a unique id which
            // we are storing in our string
            // which we have already created.
            verificationId = s;
        }

        // this method is called when user
        // receive OTP from Firebase.
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // below line is used for getting OTP code
            // which is sent in phone auth credentials.
            final String code = phoneAuthCredential.getSmsCode();

            // checking if the code
            // is null or not.
            if (code != null) {
                // if the code is not null then
                // we are setting that code to
                // our OTP edittext field.
                Otp.setText(code);

                // after setting this code
                // to OTP edittext field we
                // are calling our verifycode method.
                verifyCode(code);
            }
        }

        // this method is called when firebase doesn't
        // sends our OTP code due to any error or issue.
        @Override
        public void onVerificationFailed(FirebaseException e) {
            // displaying error message with firebase exception.
            Toast.makeText(signin.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    // below method is use to verify code from Firebase.
    private void verifyCode(String code) {
        // below line is used for getting
        // credentials from our verification id and code.
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        // after getting credential we are
        // calling sign in method.
        signInWithCredential(credential);
    }

}






