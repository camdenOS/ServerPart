package se211;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server  {
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverS;
        serverS = new ServerSocket(7890);

        while (true) {
            Socket connSocket = serverS.accept();
            Athread a = new Athread(connSocket);
            a.start();
        }
    }
    }


