package com.example.bmi_task0;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bmi_task0.R;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {


    EditText h, w;
    Button b, reset;
    TextView BMI, verdict, TextReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = (EditText) findViewById(R.id.heightt);
        w = (EditText) findViewById(R.id.weightt);
        b = (Button) findViewById(R.id.Sub);
        reset = (Button) findViewById(R.id.RESET);
        BMI = (TextView) findViewById(R.id.BMI);
        verdict = (TextView) findViewById(R.id.verdict);
        TextReset = (TextView) findViewById(R.id.TEXTRESET);

        reset.setVisibility(View.INVISIBLE);
        TextReset.setVisibility(View.INVISIBLE);
        BMI.setVisibility(View.INVISIBLE);
        verdict.setVisibility(View.INVISIBLE);

    }

    public void calc(View view) {

        h = (EditText) findViewById(R.id.heightt);
        w = (EditText) findViewById(R.id.weightt);
        b = (Button) findViewById(R.id.Sub);
        reset = (Button) findViewById(R.id.RESET);
        BMI = (TextView) findViewById(R.id.BMI);
        verdict = (TextView) findViewById(R.id.verdict);
        TextReset = (TextView) findViewById(R.id.TEXTRESET);

        b.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.VISIBLE);
        TextReset.setVisibility(View.VISIBLE);

        float i = 0f, j = 0f;

        if (!(h.getText().toString()).equals("") && !(w.getText().toString()).equals("") && Float.parseFloat(h.getText().toString()) != 0 && Float.parseFloat(w.getText().toString()) != 0) {
            i = Float.parseFloat(h.getText().toString());
            j = Float.parseFloat(w.getText().toString());

            if (i != 0 && j != 0) {
                float ans = 10000 * (j / (i * i));

                DecimalFormat f = new DecimalFormat("##.00");

                BMI.setVisibility(View.VISIBLE);
                verdict.setVisibility(View.VISIBLE);

                BMI.setText("Your BMI is... " + f.format(ans));

                if (ans <= 18.5)
                    verdict.setText("Underweight");
                else if (ans <= 25)
                    verdict.setText("Healthy");
                else if (ans <= 30)
                    verdict.setText("Overweight");
                else
                    verdict.setText("Obese");
            }
        }
        else {
            BMI.setText("INVALID INPUT");
            BMI.setVisibility(View.VISIBLE);
            verdict.setVisibility(View.INVISIBLE);
        }
    }

    public void RESET (View V)
    {
        h = (EditText) findViewById(R.id.heightt);
        w = (EditText) findViewById(R.id.weightt);
        b = (Button) findViewById(R.id.Sub);
        reset = (Button) findViewById(R.id.RESET);
        BMI = (TextView) findViewById(R.id.BMI);
        verdict = (TextView) findViewById(R.id.verdict);
        TextReset = (TextView) findViewById(R.id.TEXTRESET);

        h.setText("");
        w.setText("");

        b.setVisibility(View.VISIBLE);
        BMI.setVisibility(View.INVISIBLE);
        verdict.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        TextReset.setVisibility(View.INVISIBLE);
    }
}