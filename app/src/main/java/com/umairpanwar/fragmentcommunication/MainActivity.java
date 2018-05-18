package com.umairpanwar.fragmentcommunication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    @BindView(R.id.maintoolbar)
    public Toolbar toolbar1;
    @BindView(R.id.mainTablayout)
    public TabLayout tabLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout,fragment1)
                .commit();

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayout,fragment1)
                                .commit();
                        break;

                    case 1:
                     //   textView1.setText("tab 2");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayout,fragment2)
                                .commit();
                        break;

                    case 2:
                     //   textView1.setText("tab 3");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayout,fragment3)
                                .commit();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
