package com.deltalabs.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Delta Labs Workshop
 */
public class HomeActivity extends AppCompatActivity {
    private static String LOGGING_TAG = "HomeActivity";
    private String operator = null;
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
        equationTextView = findViewById(R.id.equationText);


        //buttonClear = findViewById(R.id.buttonClear);
        //buttonPlus = findViewById(R.id.buttonPlus);

        //result = findViewById(R.id.result);
        // buttonResult = findViewById(R.id.buttonResult);

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


    }


//    private void sum() {
//        Log.d(LOGGING_TAG, "sum ()");
//
//        operator = AppConstant.ADD_OPRATOR;
//        buildEquation(operator);
//
//
//    }

//
//    private void equalButton() {
//        Log.d(LOGGING_TAG, "equalButton");
//        int answer = calculateResult();
//        result.setText("" + answer);
//        equationTextView.setText("");
//        operator = null;
//
//    }

    /**
     * @param number that will be click
     */
    private void clickNumber(int number) {
        Log.d(LOGGING_TAG, "clickNumber number = " + number);
        buildEquation("" + number);
    }

    /**
     * @param equationValue string add in the equationValue
     */
    private void buildEquation(String equationValue) {
        String currentEquation = equationTextView.getText().toString();
        Log.d(LOGGING_TAG, "currentEquation = " + currentEquation);
        currentEquation = currentEquation + "" + equationValue;
        equationTextView.setText(currentEquation);
    }
//
//    private void cutOperation() {
//        Log.d(LOGGING_TAG, "cutOperation");
//        equationTextView.setText("");
//        operator = null;
//    }
//

//    private int calculateResult() {
//        Log.d(LOGGING_TAG, "calculateResult");
//        String currentEquation = equationTextView.getText().toString();
//        Log.d(LOGGING_TAG, "currentEquation = " + currentEquation);
//        int answer = 0;
//
//        String[] numbers = currentEquation.split(String.format("\\%s", operator));
//        Log.d(LOGGING_TAG, "numbers = " + numbers);
//        int number1 = Integer.parseInt(numbers[0]);
//        int number2 = Integer.parseInt(numbers[1]);
//        Log.d(LOGGING_TAG, "number1 = " + number1);
//        Log.d(LOGGING_TAG, "number2 = " + number2);
//        switch (operator) {
//            case AppConstant.ADD_OPRATOR:
//                answer = number1 + number2;
//                break;
//        }
//
//        return answer;
//
//    }
}