package com.androidcourse.discountcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText insertedValue;
    private TextView textPercentage;
    private TextView textDiscount;
    private TextView textTotal;
    private SeekBar seekBar;
    private double percentage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertedValue = findViewById(R.id.value);
        textPercentage = findViewById(R.id.textViewPercentage);
        textDiscount = findViewById(R.id.textViewDiscount);
        textTotal = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage = progress;
                textPercentage.setText(Math.round(percentage) + "%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    public void calculate(){
        String value = insertedValue.getText().toString();

        if(value == null || value.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Insert a value please!",
                    Toast.LENGTH_LONG
            ).show();
        } else{
            double enteredValue = Double.parseDouble(value);

            double discount = enteredValue * (percentage/100);
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            textDiscount.setText(numberFormat.format(discount) + "€");

            double total = enteredValue - discount;
            textTotal.setText(numberFormat.format(total) + "€");
        }

    }



}