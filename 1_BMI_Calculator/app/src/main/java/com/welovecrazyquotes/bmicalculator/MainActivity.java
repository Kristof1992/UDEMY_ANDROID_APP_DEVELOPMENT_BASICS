package com.welovecrazyquotes.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;

    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;

    Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);

        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);

        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);
                if (age >= 18) {
                    displayResult(calculateBmi());
                } else {
                    displayGuidance(age);
                }
            }
        });
    }

    private double calculateBmi() {
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        // Converting the number 'Strings' into 'int' variables
        int feetValue = Integer.parseInt(feetText);
        int inchValue = Integer.parseInt(inchesText);
        int weightValue = Integer.parseInt(weightText);

        int totalInches = (feetValue * 12) + inchValue;
        double heightInMeters = totalInches * 0.0254;
        return weightValue / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = "Your BMI: " + myDecimalFormatter.format(bmi);

        String fullResult;

        if (bmi < 18.5) {
            fullResult = bmiTextResult + " - You are underweight";
        } else if(bmi > 25) {
            // overweight
            fullResult = bmiTextResult + " - You are overweight";
        } else {
            // underweight
            fullResult = bmiTextResult + " - You are a healthy weight";
        }

        resultText.setText(fullResult);
    }


    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = "Your BMI: " + myDecimalFormatter.format(bmi);

        String fullResultString;
        if (radioButtonMale.isChecked()) {
            // Display boy guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for boys";
        } else if(radioButtonFemale.isChecked()) {
            // Display girl guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for girls";
        } else {
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range";
        }
        resultText.setText(fullResultString);
    }

}