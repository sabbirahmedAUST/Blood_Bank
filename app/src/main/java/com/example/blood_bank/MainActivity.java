package com.example.blood_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login_button_id;
    private Button create_button_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_button_id=(Button)findViewById(R.id.login_id);

        login_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_login();
            }
        });
        create_button_id=(Button)findViewById(R.id.create_id);

        create_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_create_account();
            }
        });
    }

    public void open_login() {
        Intent intent =new Intent(this,Login.class);
        startActivity(intent);

    }

    public void open_create_account(){
        Intent intent =new Intent(this,Create_account.class);
        startActivity(intent);
    }
}