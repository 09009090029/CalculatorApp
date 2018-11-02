package com.deltalabs.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class HomeActivity extends AppCompatActivity {
    private static String LOGGING_TAG = "HomeActivity";
    private int firstNumber = -1;
    private int secoundNumber = -1;
    private String operator = null;
    private int answer = 0;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPlus;
    private Button buttonClear;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonResult;
    private TextView result;
    private TextView equationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        result = findViewById(R.id.result);
        buttonResult = findViewById(R.id.buttonResult);
        equationTextView = findViewById(R.id.equationText);
        buttonClear = findViewById(R.id.buttonClear);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum();
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(0);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(6);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(7);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(8);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber(9);
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalButton();
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cutOperation();
            }
        });

    }


    private void sum() {
        Log.d(LOGGING_TAG, "sum ()");
        if (operator != null) {
            Toast.makeText(getApplicationContext(), "Multiple operator not allow", Toast.LENGTH_SHORT).show();
        } else {
            operator = AppConstant.ADD_OPRATOR;
            buildEquation(operator);
        }


    }


    private void equalButton() {
        Log.d(LOGGING_TAG, "equalButton");
        int answer = calculateResult();
        result.setText("" + answer);
        equationTextView.setText("");
        operator = null;
    }

    private void clickNumber(int number) {
        Log.d(LOGGING_TAG, "clickNumber number = " + number);
        buildEquation("" + number);
    }

    private void buildEquation(String equationValue) {
        String currentEquation = equationTextView.getText().toString();
        Log.d(LOGGING_TAG, "currentEquation = " + currentEquation);
        currentEquation = currentEquation + "" + equationValue;
        equationTextView.setText(currentEquation);
    }

//    private void cutOperation() {
//        Log.d(LOGGING_TAG, "cutOperation");
//        equationTextView.setText("");
//        operator = null;
//    }

    private void cutOperation() {
        Log.d(LOGGING_TAG, "cutOperation2");
        String currentEquation = equationTextView.getText().toString();
        int equationLength = currentEquation.length();
        if (equationLength > 0) {
            char lastChar = currentEquation.charAt(equationLength - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == '*') {
                Log.d(LOGGING_TAG, "operator delete");
                operator = null;
            }
            String remaningString = "";
            if (equationLength > 1) {
                remaningString = currentEquation.substring(0, equationLength - 1);
                Log.d(LOGGING_TAG, "remaningString = " + remaningString);
            }
            equationTextView.setText(remaningString);

        }
    }


    private int calculateResult() {
        Log.d(LOGGING_TAG, "calculateResult");
        String currentEquation = equationTextView.getText().toString();
        Log.d(LOGGING_TAG, "currentEquation = " + currentEquation);
        int answer = 0;
        if (operator != null) {

            String[] numbers = currentEquation.split(String.format("\\%s", operator));
            Log.d(LOGGING_TAG, "numbers = " + numbers);
            if (numbers.length == 2) {
                int number1 = Integer.parseInt(numbers[0]);
                int number2 = Integer.parseInt(numbers[1]);
                Log.d(LOGGING_TAG, "number1 = " + number1);
                Log.d(LOGGING_TAG, "number2 = " + number2);
                switch (operator) {
                    case AppConstant.ADD_OPRATOR:
                        answer = number1 + number2;
                        break;
                    default:
                        answer = 0;
                        Toast.makeText(getApplicationContext(), "operator is not valid", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getApplicationContext(), "Input not right", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Please enter any operator", Toast.LENGTH_SHORT).show();
        }
        return answer;
    }


    // make method of find the data
    // make has map
    //
}
