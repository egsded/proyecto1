package com.example.proyecto1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView lbl1;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        lbl1 = findViewById(R.id.lbl1);

        View.OnClickListener clickbtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                lbl1.setText(String.valueOf(contador));
            }
        };
        btn1.setOnClickListener(clickbtn);
        lbl1.setOnClickListener(clickbtn);

        new CountDownTimer(20000,500){
            @Override
            public void onTick(long millisUntilFinished){
                Random r = new Random();
                int x = r.nextInt(9)+1;

                Log.i("num",String.valueOf(x));

                FrameLayout.LayoutParams lp= new FrameLayout.LayoutParams(-2,-2);
                switch (x){
                    case 1:
                        lp.gravity = Gravity.TOP;
                        break;
                    case 2:
                        lp.gravity = Gravity.LEFT|Gravity.BOTTOM;
                        break;
                    case 3:
                        lp.gravity = Gravity.RIGHT|Gravity.TOP;
                        break;
                    case 4:
                        lp.gravity = Gravity.LEFT|Gravity.TOP;
                        break;
                    case 5:
                        lp.gravity = Gravity.RIGHT|Gravity.BOTTOM;
                        break;
                    case 6:
                        lp.gravity = Gravity.CENTER|Gravity.BOTTOM;
                        break;
                    case 7:
                        lp.gravity = Gravity.CENTER|Gravity.TOP;
                        break;
                    case 8:
                        lp.gravity = Gravity.RIGHT|Gravity.CENTER;
                        break;
                    case 9:
                        lp.gravity = Gravity.LEFT|Gravity.CENTER;
                        break;
                }
                btn1.setLayoutParams(lp);
            }
            @Override
            public void onFinish(){
                Toast.makeText(MainActivity.this, "Se Terminó", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}
