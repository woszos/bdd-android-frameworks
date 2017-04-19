package com.wojtek.bddaplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CircleActivity extends AppCompatActivity {

    private TextInputLayout radiusWrapper;
    private AppCompatTextView result;
    private Toolbar toolbar;
    private CalculateArea calculateArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        grabUI();
        init();

    }

    private void init() {
        toolbar.setTitle(R.string.area_of_a_circle);
        setSupportActionBar(toolbar);
        calculateArea = new CalculateArea();
    }

    private void grabUI() {
        radiusWrapper = (TextInputLayout) findViewById(R.id.radius_wrapper);
        result = (AppCompatTextView) findViewById(R.id.result);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void radiusCalculate(View view) {
        String radiusText = radiusWrapper.getEditText().getText().toString();
        try {
            if (!radiusText.isEmpty()) {
                int radius = Integer.parseInt(radiusText);
                double resultCalculate = calculateArea.areaOfCircle(radius);
                if (resultCalculate != -1.0) {
                    radiusWrapper.setError("");
                    result.setText(String.format("Area of circle is %.2f", resultCalculate));
                }
                else {
                    result.setText("");
                    radiusWrapper.setError(getString(R.string.radius_must_be_non_negative));
                }
            }
            else {
                throw new Exception("Radius is empty");
            }
        }
        catch (Exception e) {
            result.setText("");
            radiusWrapper.setError(getString(R.string.incorrect_data));
        }

    }

}
