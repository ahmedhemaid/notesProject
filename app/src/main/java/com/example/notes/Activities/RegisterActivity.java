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
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText emailEt,passwordEt;
    //    Button signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //fireBase instance
        mAuth=FirebaseAuth.getInstance();
        emailEt = (EditText) findViewById(R.id.email_edit_text_sign_up);
        passwordEt =(EditText) findViewById(R.id.password_edit_text_sign_up);

    }
    //fireBase authentication
    public void singup_do(View view) {
        ( mAuth.createUserWithEmailAndPassword(emailEt.getText().toString(),passwordEt.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.d("123", "onComplete: "+task.getException());
                            Toast.makeText(RegisterActivity.this, task.getException().getLocalizedMessage().toString(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    //exit icon
    public void home(View view) {
        finish();
    }
    ////Go to Sign In
    public void signin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
