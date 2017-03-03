package me.chirathr.picar;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by chirath on 26/2/17.
 */


public class Server {

    MainActivity activity;
    ServerSocket serverSocket;
    String message = "";
    static final int socketServerPORT = 8080;
    String msgReply;
    Socket socket;
    OutputStream outputStream;

    public Server(MainActivity activity) {
        this.activity = activity;
    }

    public void connect() {
        try {
            // create ServerSocket using specified port
            serverSocket = new ServerSocket(socketServerPORT);


            // block the call until connection is created and return
            // Socket object
            socket = serverSocket.accept();

            message = socket.getInetAddress() + ":"
                    + socket.getPort() + "\n";

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    activity.msg.setText(message);
                }
            });


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public void setMsg(String msg) {
//        msgReply = msg;
//        try {
//            outputStream = socket.getOutputStream();
//            PrintStream printStream = new PrintStream(outputStream);
//            printStream.print(msgReply);
//            printStream.close();
//
//            message += "replayed: " + msgReply + "\n";
//
//            activity.runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    activity.msg.setText(message);
//                }
//            });
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            message += "Something wrong! " + e.toString() + "\n";
//        }
//
//        activity.runOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                activity.msg.setText(message);
//            }
//        });
//    }



    public int getPort() {

        return socketServerPORT;
    }

    public void onDestroy() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip += "Server running at : "
                                + inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong1! " + e.toString() + "\n";
        }
        return ip;
    }
}