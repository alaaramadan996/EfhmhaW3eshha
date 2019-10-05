package com.alaa.efhmhaw3eshha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText conformpassword;
    private Button createaccount;
    private Button login;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private FirebaseAuth.AuthStateListener mAuthlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText) findViewById(R.id.email2);
        password = (EditText) findViewById(R.id.pass2);
        conformpassword = (EditText) findViewById(R.id.passconfirm);
        createaccount = (Button) findViewById(R.id.createAccount);
       // login = (Button) findViewById(R.id);
        mAuth = FirebaseAuth.getInstance();
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Createaccounte();
            }

            private void Createaccounte() {
                String memail = email.getText().toString().trim();
                String mpassword = password.getText().toString().trim();
                String mconpassword = conformpassword.getText().toString().trim();

                if (TextUtils.isEmpty(memail) || TextUtils.isEmpty(mpassword) || TextUtils.isEmpty(mconpassword)) {
                    Toast.makeText(SignUp.this, "Enter the Email and password ", Toast.LENGTH_LONG).show();
                } else {

                    mAuth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(SignUp.this, "Success", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}