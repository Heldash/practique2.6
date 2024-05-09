package com.example.homework_26;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next_calc = findViewById(R.id.next_calc);
        next_calc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_calc){
            Intent intent = new Intent(this,Calc_three_num.class);
            Log.d("simple_app_tag","starting calculator");
            startActivityForResult(intent,111111);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111111){
            TextView last_res = findViewById(R.id.last_result);
            double result = data.getDoubleExtra("data",0.0f);
            Log.d("simple_app_tag","last result = "+result);
            if (result%1==0){
                last_res.setText("Последний результат равен = "+(int)result);
            }else{
                last_res.setText("Последний результат равен = "+result);
            }
        }
    }
}