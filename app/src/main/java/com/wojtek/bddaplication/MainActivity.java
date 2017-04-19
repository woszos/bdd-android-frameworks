package com.wojtek.bddaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatImageButton circleButton;
    private AppCompatImageButton squareButton;
    private AppCompatImageButton cuboidButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grabUI();
        setSupportActionBar(toolbar);
        setListener();

    }

    private void setListener() {
        circleButton.setOnClickListener(this);
        squareButton.setOnClickListener(this);
        cuboidButton.setOnClickListener(this);
    }

    private void grabUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        circleButton = (AppCompatImageButton) findViewById(R.id.circle_button);
        squareButton = (AppCompatImageButton) findViewById(R.id.square_button);
        cuboidButton = (AppCompatImageButton) findViewById(R.id.cuboid_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.circle_button:
                intent = new Intent(getApplicationContext(), CircleActivity.class);
                break;
            case R.id.square_button:
                intent = new Intent(getApplicationContext(), SquareActivity.class);
                break;
            case R.id.cuboid_button:
                intent = new Intent(getApplicationContext(), CuboidActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
