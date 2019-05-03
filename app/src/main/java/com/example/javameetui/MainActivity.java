package com.example.javameetui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int value = 0;

    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private Button btnColour;
    private ConstraintLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        txtValue = (TextView) findViewById(R.id.textValue);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnHide = (Button) findViewById(R.id.btnHide);
        btnColour = (Button) findViewById(R.id.btnColour);

        //Listens for click
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        txtValue.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnColour.setOnClickListener(this);
        myLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        float size;

        //After click

        switch (view.getId()) {

            case R.id.btnAdd:
                value++;
                txtValue.setText("" + value);

                break;

            case R.id.btnTake:
                value--;
                txtValue.setText("" + value);

                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText("" + value);

                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);

                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);

                break;

            case R.id.myLayout:

                int color1 = Color.TRANSPARENT;
                Drawable background = myLayout.getBackground();
                if (background instanceof ColorDrawable) {
                    color1 = ((ColorDrawable)background).getColor();
                }

                break;


            case R.id.btnColour:
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                txtValue.setTextColor(color);
                btnColour.setBackgroundColor(color);

                break;


            case R.id.btnHide:
                if (txtValue.getVisibility() == View.VISIBLE) {
                    txtValue.setVisibility(View.INVISIBLE);

                    btnHide.setText("SHOW");
                } else {
                    txtValue.setVisibility(View.VISIBLE);

                    btnHide.setText("HIDE");

                    break;
                }

        }
    }

}

