package me.chirathr.picar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainActivity extends AppCompatActivity {

    OutputStream outputStream;
    static final int socketServerPORT = 8080;
    static final String socketServerIP = "192.168.43.1";
    final BlockingQueue<String> queue = new LinkedBlockingQueue<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread running = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("Done", "Done");

                try {
                    // create ServerSocket using specified port

                    ServerSocket serverSocket = new ServerSocket(socketServerPORT);

                    // block the call until connection is created and return Socket object

                    Socket socket = serverSocket.accept();

                    Log.e("Done", "Done");


                    outputStream = socket.getOutputStream();

                    PrintStream printStream = new PrintStream(outputStream);

                    while (true) {
                        try {
                            String data = queue.take();
                            printStream.print(data);
                            Log.e("Done", data);
                            //handle the data
                            if(data.equals("Exit")) {
                                break;
                            }
                        } catch (InterruptedException e) {
                            System.err.println("Error occurred:" + e);
                        }
                    }

                    printStream.close();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        running.start();


        Button upButton = (Button) findViewById(R.id.up);

        upButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String text = "";
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Context context = getApplicationContext();
                    text = "w.key-down";
                    queue.offer(text);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Context context = getApplicationContext();
                    text = "w.key-up";
                    queue.offer(text);
                }
                return true;
            }
        });

        Button leftButton = (Button) findViewById(R.id.left);

        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    queue.offer("a.key-down");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    queue.offer("a.key-up");
                }
                return true;
            }
        });

        Button rightButton = (Button) findViewById(R.id.right);

        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    queue.offer("d.key-down");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    queue.offer("d.key-up");
                }
                return true;
            }
        });


        Button downButton = (Button) findViewById(R.id.down);

        downButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    queue.offer("s.key-down");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    queue.offer("s.key-up");
                }
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        queue.offer("Exit");
        super.onDestroy();
    }
}
