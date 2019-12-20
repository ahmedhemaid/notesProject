package com.example.notes.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText emailEt,passwordEt;
    Button signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //firebase instance
//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user!=null)
//        {
//            Intent intent = new Intent(this , GoToEmail.class);
//            startActivity(intent);
//        }
//
//        emailEt = findViewById(R.id.email_edit_text_sign_up);
//        passwordEt = findViewById(R.id.password_edit_text_sign_up);
//        signUpBtn = findViewById(R.id.sign_up_btn);
//        signUpBtn.setOnClickListener(v->{
//            doSignUp(emailEt.getText().toString() , passwordEt.getText().toString());
//        });
    }
    public void home(View view) {
        Intent home = new Intent(this, NoteTutorial1.class);
        startActivity(home);
    }
//Go to Sign In
    public void signin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
////belong to FireBase
////SignUp method
//    private void doSignUp(String email, String password) {
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, task -> {
//                    if (task.isSuccessful()) {
//                        // Sign in success, update UI with the signed-in user's information
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        String emailF = user.getEmail();
//                        String uid = user.getUid();
//                        Map<String, Object> data = new HashMap<>();
//                        data.put("uid", uid);
//                        data.put("email", emailF);
//                        data.put("createdAt", new Date().getTime());
//
//
//                        FirebaseDatabase.getInstance().getReference().child("User").child(uid).setValue(data)
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
////onFailure
//                                    public void onFailure(@NonNull Exception e) {
//                                        Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                        Log.d("error", e.getLocalizedMessage());
//                                    }
//                                })
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
////onSuccess
//                                    public void onSuccess(Void aVoid) {
//                                        Intent intent = new Intent(RegisterActivity.this, GoToEmail.class);
//                                        startActivity(intent);
//                                    }
//                                });
//                    }
//                    else {
//                        // If sign in fails, display a message to the user.
//                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show();
//                    }
//
//                });
//    }
}