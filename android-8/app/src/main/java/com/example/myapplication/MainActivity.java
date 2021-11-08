package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BMIcalculation(View view){

        EditText ed1 = findViewById(R.id.height);
        EditText ed2 = findViewById(R.id.weight);

        String hn = ed1.getText().toString();
        String wn = ed2.getText().toString();

        try {
            if (!hn.contains("f")&&!wn.contains("f")&&!hn.contains("F")&&!wn.contains("F")) {
                float bminum = Float.parseFloat(wn)/Float.parseFloat(hn)/Float.parseFloat(hn)*100*100;
                String bmi = "" + (float)(Math.round(bminum*100))/100;
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("bmi", bmi);
                if(bminum < 18.5){
                    intent.putExtra("w", "異常");
                }
                else if(bminum >= 18.5 && bminum < 24){
                    intent.putExtra("w", "正常");
                }
                else if(bminum >= 24){
                    intent.putExtra("w", "異常");
                }
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
            }
        }
        catch(Exception e){
            Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
            //throw e;

        }

    }
}