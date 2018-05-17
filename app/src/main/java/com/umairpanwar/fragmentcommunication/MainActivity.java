package com.umairpanwar.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnNameSetListner {
    private Fragment1 fragment1;
    private Fragment2 fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1,fragment1)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout2,fragment2)
                .commit();
    }


    @Override
    public void setName(double name) {
     Fragment2 f2 =(Fragment2) getSupportFragmentManager().findFragmentById(R.id.framelayout2);
     f2.updateinfo((long) name);
    }
}
