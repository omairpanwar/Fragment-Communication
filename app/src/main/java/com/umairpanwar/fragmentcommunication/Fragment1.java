package com.umairpanwar.fragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Fragment1 extends Fragment {
    // public   String str1;
    @BindView(R.id.fragment1btn)
    Button button;
    @BindView(R.id.edittext)
    EditText editText1;
    @BindView(R.id.edittext2)
            EditText editText2;
    OnNameSetListner onnamesetlistner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fragment1btn})
    public void onClick(View view) {
        long num1 = 0;
        long num2 = 0;
        try {
            String mynum1 = editText1.getText().toString();
            num1 = Integer.parseInt(mynum1);
            String mynum2 = editText2.getText().toString();
            num2 = Integer.parseInt(mynum2);
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(),"enter both values",Toast.LENGTH_SHORT).show();
        }
        final long result = num1 + num2;
        onnamesetlistner.setName(result);
    }

    public interface OnNameSetListner {
        public void setName(double name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onnamesetlistner = (OnNameSetListner) context;
    }
}
