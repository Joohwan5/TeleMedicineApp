package com.example.telemedicineapp.RecordHealth;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Record_check_Request extends StringRequest {
    //서버 URL 설정(Php파일 연동)
    final static private String URL = "http://ghksdh587.dothome.co.kr/inster_first_record.php";
    private Map<String, String> map;
    public Record_check_Request(String userID,int check, Response.Listener<String> listener)
    {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID",userID);
        map.put("first_login",check+"");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
