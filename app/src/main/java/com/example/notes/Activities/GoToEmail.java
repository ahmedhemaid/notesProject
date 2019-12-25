package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.notes.R;

public class GoToEmail extends AppCompatActivity {
    String email;
    Intent intent=null,chooser=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gotoemail);
        email=ForgetPassActivity.email;

    }

    public void GoToEmail(View view) {
        if (email.contains("hotmail")||email.contains("outlook")){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1577305095&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3df88d55dc-a9e5-20ed-49bc-998a1024c7a2&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015"));
            chooser=Intent.createChooser(intent,"go to email using");
            if (intent.resolveActivity(getPackageManager())!=null){
                startActivity(chooser);
            }
        }
        else if (email.contains("gmail")){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://accounts.google.com/ServiceLogin/signinchooser?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
            chooser=Intent.createChooser(intent,"go to email using");
            if (intent.resolveActivity(getPackageManager())!=null){
                startActivity(chooser);
            }
        }
        else{
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            chooser=Intent.createChooser(intent,"go to email using");
            if (intent.resolveActivity(getPackageManager())!=null){
                startActivity(chooser);
            }        }
    }
    public void OnClickcancel(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}