package com.umairpanwar.fragmentcommunication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.umairpanwar.fragmentcommunication.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment2 extends Fragment {
    @BindView(R.id.textView)
    TextView tvClick;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        ButterKnife.bind(this,view);

        return view;
    }
    public void updateinfo(String name){
        tvClick.setText(name);

    }

}
