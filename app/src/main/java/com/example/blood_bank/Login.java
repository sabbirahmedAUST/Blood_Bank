package com.example.blood_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private TextView test_id;
    private EditText name_id;
    private EditText phone_id;
    private Button login_id;
    String phone;
    String name;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        name_id=(EditText)findViewById(R.id.name_id);
        phone_id=(EditText)findViewById(R.id.phone_id);
        login_id=(Button)findViewById(R.id.login_id);


        login_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_features();
//                check();
//                match();

            }
        });

    }





    public void check() {

        name = name_id.getText().toString();
        phone = phone_id.getText().toString();

        if (name.matches("") & phone.matches("")) {
            Toast.makeText(this, "Enter a username & Phone No", Toast.LENGTH_SHORT).show();

        } else {
            if (phone.length() == 14) {

//                Toast.makeText(this, "Processing", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "Ivalid Phone No", Toast.LENGTH_SHORT).show();
            }

        }

    }


    public void match(){
        db = FirebaseFirestore.getInstance();

        name = name_id.getText().toString();
        phone = phone_id.getText().toString();

        db.collection("Info")
                .whereEqualTo("name",name)
                .whereEqualTo("phone",phone)

                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Toast.makeText(Login.this, "Working", Toast.LENGTH_SHORT).show();




                        if(queryDocumentSnapshots.isEmpty()){

                            Toast.makeText(Login.this, "Wrong Name & Phone", Toast.LENGTH_SHORT).show();



                        }
                        else
                        {

                            Toast.makeText(Login.this, "Logged", Toast.LENGTH_SHORT).show();
                            open_features();

                        }


                    }
                });
                        }



    public void open_features(){
        Intent intent = new Intent(Login.this, Features.class);

        startActivity(intent);

    }


    }