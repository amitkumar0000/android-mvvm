package com.android.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.mvvm.R;
import com.android.mvvm.models.UserModels;
import com.android.mvvm.viewmodels.UserViewModels;

public class MainActivity extends AppCompatActivity {

    UserViewModels userViewModels;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.firstnametext);
        editText2 = findViewById(R.id.lastnametext);
        //view has reference of ViewModel
        userViewModels = ViewModelProviders.of(this).get(UserViewModels.class);

        subscribeUserViewModel();
    }

    //view subscribe for viewmodel data
    private void subscribeUserViewModel() {
        userViewModels.getUserModels().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String name) {
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
            }
        });;
    }

    //View notify viewmodel of user input
    public void click(View view){
        userViewModels.onclick(String.valueOf(editText1.getText()),
                String.valueOf(editText2.getText()));
    }


}
