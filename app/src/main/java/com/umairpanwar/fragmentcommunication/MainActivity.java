package com.umairpanwar.fragmentcommunication;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Fragment1.OnNameSetListner {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    @BindView(R.id.maintoolbar)
    public Toolbar toolbar1;
    @BindView(R.id.mainTablayout)
    public TabLayout tabLayout1;
    @BindView(R.id.textviewtab)
    public TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
       // setSupportActionBar(toolbar1);


        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1,fragment1)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout2,fragment2)
                .commit();


        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        textView1.setText("tab 1");
                        break;

                    case 1:
                        textView1.setText("tab 2");
                        break;

                    case 2:
                        textView1.setText("tab 3");
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


    @Override
    public void setName(long name) {
     Fragment2 f2 =(Fragment2) getSupportFragmentManager().findFragmentById(R.id.framelayout2);
     f2.updateinfo((long) name);
    }
}
