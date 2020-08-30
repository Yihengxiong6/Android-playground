package com.yihengx.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        final EditText nameEditText = findViewById(R.id.nameEditText);
        final EditText emailEditText = findViewById(R.id.emailEditText);
        Button submitButton = findViewById(R.id.submitButton);

        // 可以和comparator一样理解
        // 因为java里无法用callback，
        // 所以只能在arguments里传一个interface然后定义要用函数的abstract
        // 比如这里，button的 setOnclicklistener 里需要有一个click后的一些行为的逻辑，比如对现在view的改变
        // 这些逻辑只能从当前的class传入到setOnclickListener, 所以就用了一个interface的办法
        // 事先定义好这个interface，和代表这个行为逻辑的abstract方法，这样就可以在setOnClickerListener
        // 里用一个变量接住这个interface，然后调用该方法（逻辑）
        //
        submitButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                welcomeTextView.setText("Welcome " + name + ", your email is: " + email);
            }
        });
    }
}

