package com.example.user.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mScore;
    private Button mCalculate,mExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText)findViewById(R.id.editTextName);
        mScore = (EditText)findViewById(R.id.editTextScore);

        mCalculate = (Button)findViewById(R.id.buttonCalculate);
        mExit = (Button)findViewById(R.id.buttonExit);

        mName.setError("ป้อนชื่อ");  mScore.setError("ป้อนคะเเนน");
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mName.getText().length() == 0){
                    mName.setError("ป้อนชื่อ");
                }else if(mScore.getText().length()==0) {
                    mScore.setError("ป้อนคะเเนน");
                }else{
                    int score = Integer.parseInt(mScore.getText().toString());
                    char getScoreGrade = getGrade(score);
                    String grade = String.valueOf(getScoreGrade);
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("result", grade);
                    startActivity(intent);
                }
            }
        });

        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ?");

                dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                dialog.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.show();
            }
        });






    }

    private char getGrade(int score){
        char c = ' ';
        if(score >= 80){
            c = 'A';
        }else if(score >=70){
            c = 'B';
        }else if(score >= 60){
            c = 'C';
        }else if(score >= 50){
            c = 'D';
        }else{
            c = 'F';
        }
        return c;
    }


}
