package com.example.telemedicineapp.RecordHealth;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.telemedicineapp.HealthRecord.FirstFragment;
import com.example.telemedicineapp.HealthRecord.SecondFragment;
import com.example.telemedicineapp.HealthRecord.ThirdFragment;
import com.example.telemedicineapp.HealthRecord.ViewPagerAdapter;
import com.example.telemedicineapp.R;
import com.google.android.material.tabs.TabLayout;

public class HealthRecord extends AppCompatActivity {
    public static String userName;
    public static String userID;

    public static String aa;
    private First_Fragment first_fragment;
    private Second_Fragment second_fragment;
    private Third_Fragment third_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_record);



        Intent intent = getIntent(); // 로그인에서 넘겨온값을 get으로 받음
        userName = intent.getStringExtra("userName"); //로그인에서 유저네임 값을 받음
        userID = intent.getStringExtra("userID"); //로그인에서 유저네임 값을 받음

        first_fragment= new First_Fragment();
        first_fragment.user_N_ID(userName,userID);// 첫번째 페이지에 아이디값 넘기기 setString은 firstFragment에 있음.



        second_fragment = new Second_Fragment();
        second_fragment.user_N_ID(userName,userID);// 두번째 페이지에 아이디값 넘기기 setString은 firstFragment에 있음.

        third_fragment = new Third_Fragment();
        third_fragment.user_N_ID(userName,userID);// 세번째 페이지에 아이디값 넘기기 setString은 firstFragment에 있음.

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, first_fragment).commit();

    }




}
