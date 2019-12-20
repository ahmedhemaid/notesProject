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

public class LoginActivity extends AppCompatActivity {

    EditText emailEt , passwordEt;
    Button signUpBtn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null)
        {
            Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
            startActivity(intent);
        }

        emailEt = findViewById(R.id.edit_text_email_login);
        passwordEt = findViewById(R.id.edit_text_password_login);
        signUpBtn = findViewById(R.id.login_btn);
        signUpBtn.setOnClickListener(v->{
            doSignIn(emailEt.getText().toString() , passwordEt.getText().toString());
        });
    }
    public void home(View view) {
        Intent home = new Intent(this, NoteTutorial1.class);
        startActivity(home);
    }
    public void singup(View view) {

        Intent singup = new Intent(this, RegisterActivity.class);
        startActivity(singup);
    }
    public void forget(View view) {
        Intent forget = new Intent(this, ForgetPassActivity.class);
        startActivity(forget);
    }



    private void doSignIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();


                        Map<String,Object> data = new HashMap<>();
                        data.put("lastSignIn",new Date().getTime());


                        FirebaseDatabase.getInstance().getReference().child("User").child(user.getUid()).updateChildren(data)
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                        Log.d("error",e.getLocalizedMessage());
                                    }
                                })
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                                        startActivity(intent);
                                    }
                                });




                        Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                        startActivity(intent);


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                });
    }
}

