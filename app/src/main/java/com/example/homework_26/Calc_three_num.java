package com.example.homework_26;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calc_three_num extends AppCompatActivity implements View.OnClickListener {
    private double lastNum;
    private TextView resultPole;
    private EditText firstPole,secPole,threePole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_three_num);
        firstPole = findViewById(R.id.first_num);
        secPole = findViewById(R.id.second_num);
        threePole = findViewById(R.id.three_num);
        resultPole = findViewById(R.id.result_calcul);
        Button calcBtn = findViewById(R.id.btn_calc);
        calcBtn.setOnClickListener(this);
        Button exitBtn = findViewById(R.id.exit_btn);
        exitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calc){
            String first = firstPole.getText().toString();
            String sec = secPole.getText().toString();
            String three = threePole.getText().toString();
            if (!first.isEmpty() && !sec.isEmpty() && !three.isEmpty()){
                double result = Double.parseDouble(first)-Double.parseDouble(sec)-Double.parseDouble(three);
                Log.d("calculating_tag", "res = "+result);
                if (result%1 == 0) {
                    resultPole.setText(String.valueOf((int)result));
                    lastNum = result;
                }else{
                    resultPole.setText(String.valueOf(result));
                    lastNum = result;
                }
                firstPole.getText().clear();
                secPole.getText().clear();
                threePole.getText().clear();
            }else {
                Log.d("calculating_tag","Пропущено поле ввода");
                Toast.makeText(getApplicationContext(),"Не введено одно из полей",Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.exit_btn) {
            Intent intent = new Intent();
            intent.putExtra("data",lastNum);
            setResult(111111,intent);
            Log.d("calculating_tag","Выход из калькулятора");
            finish();
        }
    }
}