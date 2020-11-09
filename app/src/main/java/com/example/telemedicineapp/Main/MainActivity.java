package com.example.telemedicineapp.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.telemedicineapp.R;


public class MainActivity extends AppCompatActivity {

    private TextView tv_id,tv_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_id = findViewById(R.id.tv_id);
        tv_pass=findViewById(R.id.tv_pass);

        Intent intent =getIntent();
        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userName");

        tv_id.setText(userID);
        tv_pass.setText(userPass);
    }
}