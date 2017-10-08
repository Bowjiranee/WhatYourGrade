package com.example.user.whatsyourgrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        String output = bundle.getString("result");

        TextView tv1 = (TextView)findViewById(R.id.outputGrade);
        tv1.setTextSize(90);
        tv1.setText(output);




    }
}
