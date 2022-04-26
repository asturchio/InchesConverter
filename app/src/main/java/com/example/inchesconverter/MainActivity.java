package com.example.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    Button calculateButton;
    EditText meterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }


    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
        meterEditText = findViewById(R.id.edit_text_meters);

    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String meterString = meterEditText.getText().toString();
                String alertText = "Please enter a number in meters";

                if (meterString.isEmpty()) {
                    Toast.makeText(MainActivity.this, alertText, Toast.LENGTH_LONG).show();
                } else {
                    double inchesResult = calculateInches();
                    displayResult(inchesResult);
                }
            }
        });
    }


    private double calculateInches() {
        String meterText = meterEditText.getText().toString();

        double meters = Integer.parseInt(meterText);

        double inches = meters * 39.3701;
        return inches;
    }

    private void displayResult(double inches) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String inchTextResult = myDecimalFormatter.format(inches);
        String fullStringResult = inchTextResult + " inches";
        resultText.setText(fullStringResult);
    }
}