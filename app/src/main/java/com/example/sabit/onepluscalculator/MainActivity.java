package com.example.sabit.onepluscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
                    buttonDot, buttonDelete, buttonDivision, buttonMultiplication, buttonAddition, buttonSubtraction, buttonEquals;
    private TextView expressionText, resultText;

    private Stack<ExpressionAndResult>stack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSubtraction = (Button) findViewById(R.id.buttonSubtraction);
        buttonEquals = (Button) findViewById(R.id.buttonEquals);

        expressionText = (TextView) findViewById(R.id.expressionText);
        resultText = (TextView) findViewById(R.id.resultText);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"0");
                updateText("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"1");
                updateText("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"2");
                updateText("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"3");
                updateText("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"4");
                updateText("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"5");
                updateText("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"6");
                updateText("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"7");
                updateText("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"8");
                updateText("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+"9");
                updateText("9");
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expressionText.setText(expressionText.getText()+".");
                updateText(".");
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stack.empty() == false) {
                    ExpressionAndResult topOfStack = stack.pop();
                    expressionText.setText(topOfStack.getExpression());
                    resultText.setText(topOfStack.getResult());
                }
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("/");
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("*");
            }
        });
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("-");
            }
        });
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("+");
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateResult();

                while(stack.empty() == false)
                    stack.pop();
                expressionText.setText("");
            }
        });
    }

    private void updateText(String s){
        stack.push(new ExpressionAndResult(expressionText.getText(), resultText.getText()));
        expressionText.setText(expressionText.getText()+s);

        updateResult();
    }

    private void updateResult() {
        Expression e = new Expression((String) expressionText.getText());
        if(e.checkSyntax() == false)
            resultText.setText(stack.peek().getResult());
        else
            resultText.setText(Float.toString((float) e.calculate()));
    }

    private void clearEverything() {
        while(stack.empty() == false)
            stack.pop();
        expressionText.setText("");
        resultText.setText("");
    }
}
