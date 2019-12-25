package com.example.notes.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassActivity extends AppCompatActivity {
    EditText resetPassInput;
    FirebaseAuth mAuth;
    static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        resetPassInput=findViewById(R.id.editText5);
        mAuth=FirebaseAuth.getInstance();
        email=resetPassInput.getText().toString();
    }
    public void backFromForgetPass(View view) {
        finish();
    }

    public void onClickrecover(View view) {
        email=resetPassInput.getText().toString();
        getIntent().putExtra("email",email);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent =new Intent(ForgetPassActivity.this,GoToEmail.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ForgetPassActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}