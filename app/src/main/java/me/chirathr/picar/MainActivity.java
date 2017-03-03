package me.chirathr.picar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Server server;
    TextView infoip, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoip = (TextView) findViewById(R.id.infoip);
        msg = (TextView) findViewById(R.id.msg);
        server = new Server(this);
//        server.connect();
//        infoip.setText(server.getIpAddress() + ":" + server.getPort());

        Button upButton = (Button) findViewById(R.id.up);

        upButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Context context = getApplicationContext();
                    String text = "a.key-down";

                    //server.setMsg(text);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Context context = getApplicationContext();
                    String text = "a.key-up";

//                    server.setMsg(text);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        server.onDestroy();
    }
}
