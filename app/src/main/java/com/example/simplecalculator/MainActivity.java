package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSubtract);
        mul = findViewById(R.id.btnMultiply);
        div = findViewById(R.id.btnDivide);
        result = findViewById(R.id.textResult);

        add.setOnClickListener(v -> calculate('+'));
        sub.setOnClickListener(v -> calculate('-'));
        mul.setOnClickListener(v -> calculate('*'));
        div.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            result.setText("Please enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res = 0;

        switch (operator) {
            case '+': res = n1 + n2; break;
            case '-': res = n1 - n2; break;
            case '*': res = n1 * n2; break;
            case '/':
                if (n2 == 0) {
                    result.setText("Error: Divide by zero");
                    return;
                }
                res = n1 / n2;
                break;
        }

        result.setText("Result: " + res);
    }
}
