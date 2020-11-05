package com.example.telemedicineapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.telemedicineapp.login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;
import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;

import android.widget.DatePicker;
//확인

public class RegisterActivity extends AppCompatActivity {
    private EditText et_id,et_pass,et_name,et_date;
    private Button et_ok,but_calender;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_name=findViewById(R.id.et_name);
        et_date = findViewById(R.id.et_date);

        et_ok = findViewById(R.id.et_ok); // 확인 버튼
        but_calender= findViewById(R.id.but_calender); //날짜 버튼

        but_calender.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();

                int y = now.get(Calendar.YEAR);
                int m = now.get(Calendar.MONTH);
                int d = now.get(Calendar.DAY_OF_MONTH);

                dialog = new DatePickerDialog(RegisterActivity.this,dateSetListener,y,m,d);  // date 셋리스너는 맨밑에 정의되어있음.
                dialog.show();
            }
        });

        //회원가입 버튼 클릭 시 수행
        et_ok.setOnClickListener(new View.OnClickListener(){ //버튼눌렀을때
            @Override
            public void onClick(View view) {

               //EditText에 현재 입력되어 있는 값을 가져온다
                String userID=et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                String userBirth = et_date.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success)//회원가입 성공시
                                {
                                    Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class); // 화면전화?
                                    startActivity(intent);
                                } else {//실패시
                                    Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다..", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };


                // 서버로 volley를 이용해서 요청을 함
                RegisterRequest registerRequest= new RegisterRequest(userID,userPass,userName,userBirth,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }

    DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String starDate = String.format("%d-%02d-%02d",year, month+1, dayOfMonth);
            et_date.setText((starDate));
        }
    };
}