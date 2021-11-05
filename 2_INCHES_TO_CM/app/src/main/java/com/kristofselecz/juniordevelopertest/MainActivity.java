package com.kristofselecz.juniordevelopertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText inchesText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private double convertInchesToMeters(double inchValue) {
        return (inchValue * 0.0254);
    }

    private void findViews() {
        resultText = findViewById(R.id.result_text);
        inchesText = findViewById(R.id.inches_text);
        button = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFieldValue = inchesText.getText().toString();

                if (!textFieldValue.isEmpty()) {
                    double doubleValueOfTextView = Double.parseDouble(textFieldValue);
                    double resultingDoubleValue = convertInchesToMeters(doubleValueOfTextView);
                    displayResult(resultingDoubleValue);
                } else {
                    Toast.makeText(MainActivity.this, "Input field is empty please provide a value", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void displayResult(double value) {
            DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
            String resultedString = myDecimalFormatter.format(value);
            resultText.setText("Inches to meters: " + resultedString);
    }

}