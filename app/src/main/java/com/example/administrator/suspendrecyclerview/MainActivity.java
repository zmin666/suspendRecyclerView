package com.example.administrator.suspendrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * 主类...
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleList(View view) {
        Toast.makeText(this, "点击了简单的", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SimpleActivity.class));
    }


    public void simpPackleList(View view) {
        Toast.makeText(this, "点击了封装的", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SimplePackActivity.class));
    }

    public void simpDoubleleList(View view) {
        Toast.makeText(this, "点击了双类型", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SimpleDoublePackActivity.class));
    }

    public void simpHeaderList(View view) {
        Toast.makeText(this, "点击了加头部的悬浮列表", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SimpHeaderActivity.class));
    }

    public void simpHeaderPackList(View view) {
        Toast.makeText(this, "点击了包装的加头部的悬浮列表", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SimpHeaderPackActivity.class));
    }


}
