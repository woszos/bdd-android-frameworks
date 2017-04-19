package com.wojtek.bddaplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CuboidActivity extends AppCompatActivity {

    private TextInputLayout valueLWrapper;
    private TextInputLayout valueHWrapper;
    private TextInputLayout valueWWrapper;
    private AppCompatTextView result;
    private Toolbar toolbar;
    private CalculateArea calculateArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuboid);

        grabUI();
        init();

    }

    private void init() {
        toolbar.setTitle(R.string.cuboid_title);
        setSupportActionBar(toolbar);
        calculateArea = new CalculateArea();
    }

    private void grabUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        valueLWrapper = (TextInputLayout) findViewById(R.id.value_l_wrapper);
        valueHWrapper = (TextInputLayout) findViewById(R.id.value_h_wrapper);
        valueWWrapper = (TextInputLayout) findViewById(R.id.value_w_wrapper);
        result = (AppCompatTextView) findViewById(R.id.result);
    }

    public void volumeCalculate(View view) {
        String valueLText = valueLWrapper.getEditText().getText().toString();
        String valueHText = valueHWrapper.getEditText().getText().toString();
        String valueWText = valueWWrapper.getEditText().getText().toString();

        if (!valueLText.isEmpty() && !valueHText.isEmpty() && !valueWText.isEmpty()) {
            int valueL = Integer.parseInt(valueLText);
            int valueH = Integer.parseInt(valueHText);
            int valueW = Integer.parseInt(valueWText);
            int volume = calculateArea.volumeCuboid(valueL, valueH, valueW);
            switch (volume) {
                case -1:
                    incorrectData(valueLWrapper, R.string.incorrect_data);
                    result.setText("");
                    break;
                case -2:
                    incorrectData(valueHWrapper, R.string.incorrect_data);
                    result.setText("");
                    break;
                case -3:
                    incorrectData(valueWWrapper, R.string.incorrect_data);
                    result.setText("");
                    break;
                default:
                    valueLWrapper.setError("");
                    valueHWrapper.setError("");
                    valueWWrapper.setError("");
                    result.setText(String.format("The volume of the cuboid is %d", volume));
                    break;
            }
        }
        else {
            if (valueLText.isEmpty()) {
                incorrectData(valueLWrapper, R.string.incorrect_data);
            }
            if (valueHText.isEmpty()) {
                incorrectData(valueHWrapper, R.string.incorrect_data);
            }
            if (valueWText.isEmpty()) {
                incorrectData(valueWWrapper, R.string.incorrect_data);
            }
            result.setText("");
        }
    }

    private void incorrectData(TextInputLayout wrapper, int incorrect_data) {
        wrapper.setError(getString(incorrect_data));
    }

}
