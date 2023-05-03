package com.example.bmicalci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText weight, heightF, heightI;
        Button calculate;
        TextView result;
        weight = findViewById(R.id.editWeight);
        heightF = findViewById(R.id.editHeightFt);
        heightI = findViewById(R.id.editHeightIn);
        calculate = findViewById(R.id.buttonCalculate);
        result = findViewById(R.id.textResult);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(heightF.getText().toString());
                int in = Integer.parseInt(heightI.getText().toString());
                int total = ft*12 + in;
                double cm = total*2.53;
                double meters = cm/1000;
                double bmi = wt/(meters*meters);

                if(bmi > 25){
                    result.setText(R.string.textOW);
                }
                else if(bmi < 18){
                    result.setText(R.string.textUW);
                }
                else{
                    result.setText(R.string.textH);
                }
            }
        });
    }
}