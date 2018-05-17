package com.umairpanwar.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.umairpanwar.fragmentcommunication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Fragment1 extends Fragment {
    // public   String str1;
    @BindView(R.id.fragment1btn)
    Button button;
    @BindView(R.id.edittext)
    EditText editText1;
    OnNameSetListner onnamesetlistner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);

        ButterKnife.bind(this, view);


        return view;
    }

    @OnClick({R.id.fragment1btn})
    public void onClick(View view){
        String Name = editText1.getText().toString();
        onnamesetlistner.setName(Name);
    }

    public interface OnNameSetListner {
        public void setName(String name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onnamesetlistner = (OnNameSetListner) context;
    }
}
