package com.example.sabit.onepluscalculator;

public class ExpressionAndResult {
    private CharSequence expression, result;

    public ExpressionAndResult(CharSequence expression, CharSequence result) {
        this.expression = expression;
        this.result = result;
    }

    public CharSequence getExpression() {
        return expression;
    }

    public void setExpression(CharSequence expression) {
        this.expression = expression;
    }

    public CharSequence getResult() {
        return result;
    }

    public void setResult(CharSequence result) {
        this.result = result;
    }
}

