package com.alaa.efhmhaw3eshha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private EditText memail;
    private EditText mpassword;
    private Button login;
    private TextView signout;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signout = (TextView) findViewById(R.id.txt_sigin);
        memail = (EditText) findViewById(R.id.email);
        mpassword = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.button_login);
        mAuth = FirebaseAuth.getInstance();
        mAuthlistener = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                if (mAuth.getCurrentUser() != null)
                {
                    Intent intent = new Intent(SignIn.this, MainActivity.class);

                    intent.putExtras(intent);
                    startActivity(intent);
                }
            }
        };
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignIn.this,SignUp.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartSignin();
            }
        });

    }
    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthlistener);
    }



    private void StartSignin()
    {
        String email=memail.getText().toString();
        String passord=mpassword.getText().toString();
        if (TextUtils.isEmpty(email)||TextUtils.isEmpty(passord))
        {
            Toast.makeText(SignIn.this,"feild is empty",Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,passord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if ( !task.isSuccessful())
                    {
                        Toast.makeText(SignIn.this,"Sign is problem",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}