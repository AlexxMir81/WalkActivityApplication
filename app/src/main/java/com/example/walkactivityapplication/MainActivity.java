package com.example.walkactivityapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Count : " + count);
    }
    public void StartActivity(View view) {
        Intent intent = new Intent(this,StartActivity.class);
        intent.putExtra("count",count);
        startActivityForResult(intent,1);
        //startActivity(intent);
    }
    public void Settingctivity(View view) {
        Intent intent = new Intent(this,SettingActivity.class);
        intent.putExtra("count",count);
        startActivityForResult(intent,1);
    }
    public void AboutActivity(View view) {
        Intent intent = new Intent(this,AboutActivity.class);
        intent.putExtra("count",count);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count", 0);
        getSupportActionBar().setTitle("Count : " + count);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==200&&data!=null) {
            count = data.getIntExtra("count", 0);
            getSupportActionBar().setTitle("Count : " + count);
        }
    }
    public void Calculate(View view) {
        getSupportActionBar().setTitle("Count : " + (++count));
    }
}