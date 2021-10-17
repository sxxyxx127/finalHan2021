package com.example.finalhan2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFirebaseAuth = FirebaseAuth.getInstance();//초기화

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

        if(user ==null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            for(UserInfo profile : user.getProviderData()){
                String name=profile.getDisplayName();
                if(name==null){
                    Intent intent = new Intent(MainActivity.this, informationActivity.class);
                    startActivity(intent);
                }
            }
        }

        Button btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그아웃
                mFirebaseAuth.signOut();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }


        });

        //주행 Activity
        Button btn_driv = findViewById(R.id.btn_driv);
        btn_driv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, drivActivity.class);
                startActivity(intent);
            }
        });

        //라이브스트리밍 Activity
        Button btn_strm = findViewById(R.id.btn_strm);
        btn_strm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, strmActivity.class);
                startActivity(intent);
            }
        });

        //커뮤니티 Activity
        Button btn_cm = findViewById(R.id.btn_cm);
        btn_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommunityActivity.class);
                startActivity(intent);
            }
        });

        Button btn_nw = findViewById(R.id.btn_nw);
        btn_nw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NwActivity.class);
                startActivity(intent);
            }
        });



    }}