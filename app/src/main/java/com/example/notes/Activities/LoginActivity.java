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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth FirebaseAuth;
    EditText emailEt,passwordEt;
    @Override
    //onCreate
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEt = findViewById( R.id.edit_text_email_login);
        passwordEt = findViewById(R.id.edit_text_password_login);
        //fireBase instance
        FirebaseApp.initializeApp(this);

        FirebaseAuth=FirebaseAuth.getInstance();

    }
    //exit icon
    public void home(View view) {
        finish();
    }
    //go to signUp
    public void singup(View view) {
        Intent singup = new Intent(this, RegisterActivity.class);
        startActivity(singup);
    }
    //forget password
    public void forget(View view) {
        Intent forget = new Intent(this, ForgetPassActivity.class);
        startActivity(forget);
    }
    //fireBase get data method
    public void onClickSignIn(View view) {
        (FirebaseAuth.signInWithEmailAndPassword(emailEt.getText().toString(),passwordEt.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            // write value to shared pref (is_logged_in)

                            Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(LoginActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}