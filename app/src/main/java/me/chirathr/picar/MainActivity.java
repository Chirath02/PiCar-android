package me.chirathr.picar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button upButton = (Button) findViewById(R.id.up);

        upButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Pressed
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Released
                }
                return true;
            }
        });

        Button leftButton = (Button) findViewById(R.id.left);

        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Pressed
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Released
                }
                return true;
            }
        });

        Button rightButton = (Button) findViewById(R.id.right);

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Pressed
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Released
                }
                return true;
            }
        });


        Button downButton = (Button) findViewById(R.id.down);

        downButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Pressed
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // Released
                }
                return true;
            }
        });
    }
}
