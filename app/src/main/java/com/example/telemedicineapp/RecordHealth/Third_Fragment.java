package com.example.telemedicineapp.RecordHealth;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telemedicineapp.Main.MainActivity;
import com.example.telemedicineapp.R;

public class Third_Fragment extends Fragment {
    private TextView third_text,medicine_drugs_text,alcohol_text,smoke_text;
    private TextView medicine_drugs_ex;
    private EditText medicine_drugs_insert,text2;

    private RadioGroup alcohol_group,smoke_group;
    private RadioButton alcohol_no,alcohol_2_3,alcohol_5,nosmoke,half,somke_many;

    private Button finish_but;
    private View view;

    private static String username1,userid1;
    private static String test;
    public static String result;
    private String transfer_past,transfer_family,transfer_surgical,transfer_kidney,transfer_weight; //세컨드에서 전해져온 값

    public Third_Fragment(){}

    public void user_N_ID(String aname, String aid)
    {
        this.username1 = aname;
        this.userid1 = aid;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.record_third, container, false);
        third_text=view.findViewById(R.id.third_name_text);
        third_text.setText(this.username1+"님의 음주 및 흡연 여부");

        medicine_drugs_text=view.findViewById(R.id.medicine_drugs_text2); //약물복용
        alcohol_text=view.findViewById(R.id.alcohol_text2);             // 알코올
        smoke_text=view.findViewById(R.id.smoke_text2);                // 흡연
        medicine_drugs_ex=view.findViewById(R.id.medicine_drugs_ex2);
        medicine_drugs_insert=view.findViewById(R.id.medicine_drugs_insert2);

        if(getArguments()!=null)
        {
            transfer_kidney=getArguments().getString("kidney_2");
            transfer_weight=getArguments().getString("weight_2");
            transfer_past=getArguments().getString("past");
            transfer_family=getArguments().getString("family");
            transfer_surgical=getArguments().getString("surgical");
        }


        finish_but=view.findViewById(R.id.finishbutton2); //완료 버튼
         finish_but.setOnClickListener(new View.OnClickListener() {
           @Override
             public void onClick(View v) { // getActivity를 쓸것..
              Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
              intent.putExtra("userID",transfer_kidney ); //비밀번호
               intent.putExtra("userName",transfer_family);
                startActivity(intent);
               getActivity().finish();

           } //버튼눌렀을때

        });//이 위에 구문은 firstfragment와 연동하는것이다.

        return view;
    }





}