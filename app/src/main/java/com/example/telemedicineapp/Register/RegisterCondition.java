package com.example.telemedicineapp.Register;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;


import com.example.telemedicineapp.Main.MainActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCondition
{
    public static final Pattern pwPattern= Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$"); //숫자 문자 특수문자 포함 8~15자
    public static final Pattern pwPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
    RegisterActivity activity; // 선언해주기


    public RegisterCondition(RegisterActivity inActivity) { //생성자 이렇게선언하기
            activity = inActivity;
    }

    public boolean user_pass_check(String user_pass, String user_id)
    {
        //String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z])";
        Matcher matcher = pwPattern.matcher(user_pass);
        // pwPattern = "(.)\\1\\1\\1";
        Matcher matcher2 = pwPattern2.matcher(user_pass);
        Toast toast;
        if(!matcher.matches()){
            Toast.makeText(activity.getApplicationContext(), "숫자 문자 특수문자 포함 8~15자가 되어야합니다.", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(user_pass.indexOf(user_id)>-1){
            Toast.makeText(activity.getApplicationContext(), "비밀번호에 아이디형식이 들어갈 수 없습니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(user_pass.contains(" ")) {
            Toast.makeText(activity.getApplicationContext(), "비밀번호엔 공백을 포함할수 없습니다.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }




}
