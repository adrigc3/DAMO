package com.example.avaluable_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button change_red, change_blue, change_green, reset;

    private TextView partida;

    private int i=1, x=0, y=2, attempts = 2, verify = 0;


    private View.OnClickListener change_btn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (i == x && i == y) {
            } else {
                if (view.getId() == R.id.btn_red) {
                    changeColor(change_red, i);
                    i = (i + 1) % 3;
                }
                if (view.getId() == R.id.btn_blue) {
                    changeColor(change_blue, x);
                    x = (x + 1) % 3;
                }
                if (view.getId() == R.id.btn_green) {
                    changeColor(change_green, y);
                    y = (y + 1) % 3;
                }
            }
                if (i == x && i == y && verify == 0) {
                    Toast.makeText(view.getContext(), "ENHORABONA!!", Toast.LENGTH_SHORT).show();
                    verify = 1;
                }
            }


    };

    private View.OnClickListener reset_btn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (i == x && i == y){
                partida.setText("Partida: "+ attempts);
                attempts++;
                i = 1;
                x = 0;
                y = 2;
                change_red.setBackgroundColor(Color.RED);
                change_blue.setBackgroundColor(Color.BLUE);
                change_green.setBackgroundColor(Color.GREEN);
                verify = 0;
            }
        }
    };

    private void changeColor(Button button, int colorIndex) {
        switch (colorIndex) {
            case 0:
                button.setBackgroundColor(Color.RED);
                break;
            case 1:
                button.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                button.setBackgroundColor(Color.BLUE);
                break;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change_red = (Button) findViewById(R.id.btn_red);
        change_red.setBackgroundColor(Color.RED);

        change_blue = (Button) findViewById(R.id.btn_blue);
        change_blue.setBackgroundColor(Color.BLUE);

        change_green = (Button) findViewById(R.id.btn_green);
        change_green.setBackgroundColor(Color.GREEN);

        reset = (Button) findViewById(R.id.btn_reset);
        partida = (TextView) findViewById(R.id.txt_partidas);


        change_red.setOnClickListener(change_btn);
        change_green.setOnClickListener(change_btn);
        change_blue.setOnClickListener(change_btn);
        reset.setOnClickListener(reset_btn);


    }
}