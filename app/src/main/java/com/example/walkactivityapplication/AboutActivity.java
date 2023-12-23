package com.example.walkactivityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        count = getIntent().getIntExtra("count",0);
        getSupportActionBar().setTitle("Count : " + count);
    }
    public void BackMainActivity(View view) {
        Intent intent = new Intent();
        intent.putExtra("count",count);
        setResult(200,intent);
        finish();
    }
    public void Calculate(View view) {
        count+=Math.ceil(count*.1);
        getSupportActionBar().setTitle("Count : " + (count));
    }
}