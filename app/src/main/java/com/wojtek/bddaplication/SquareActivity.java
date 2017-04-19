package com.wojtek.bddaplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SquareActivity extends AppCompatActivity implements OnSquareListener {

    private TextInputLayout valueXWrapper;
    private TextInputLayout valueYWrapper;
    private AppCompatTextView result;
    private Toolbar toolbar;
    private CalculateArea calculateArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        grabUI();
        init();

    }

    private void init() {
        toolbar.setTitle(R.string.square_title);
        setSupportActionBar(toolbar);
        calculateArea = new CalculateArea();
    }

    private void grabUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        valueXWrapper = (TextInputLayout) findViewById(R.id.value_x_wrapper);
        valueYWrapper = (TextInputLayout) findViewById(R.id.value_y_wrapper);
        result = (AppCompatTextView) findViewById(R.id.result);
    }

    public void areaCalculate(View view) {
        String valueXText = valueXWrapper.getEditText().getText().toString();
        String valueYText = valueYWrapper.getEditText().getText().toString();

        if (!valueXText.isEmpty() && !valueYText.isEmpty()) {
            int valueX = Integer.parseInt(valueXText);
            int valueY = Integer.parseInt(valueYText);
            calculateArea.areaOfSquare(valueX, valueY, this);
        }
        else {
            if (valueXText.isEmpty()) {
                incorrectData(valueXWrapper, R.string.incorrect_data);
            }
            if (valueYText.isEmpty()) {
                incorrectData(valueYWrapper, R.string.incorrect_data);
            }
            result.setText("");

        }
    }

    private void incorrectData(TextInputLayout wrapper, int incorrect_data) {
        wrapper.setError(getString(incorrect_data));
    }

    @Override
    public void onSuccess(int squareOfArea) {
        valueXWrapper.setError("");
        valueYWrapper.setError("");
        result.setText(String.format("Area of square is %d", squareOfArea));
    }

    @Override
    public void onFailed(int error) {
        switch (error) {
            case -1:
                incorrectData(valueXWrapper, R.string.incorrect_data);
                break;
            case -2:
                incorrectData(valueYWrapper, R.string.incorrect_data);
                break;
        }
        result.setText("");
    }
}
