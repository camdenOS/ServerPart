package se211;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Athread extends Thread {
    Socket connSocket;

    public Athread(Socket clients) {
        connSocket = clients;
    }

    public void run() {
        while (true) {

            BufferedReader inClient = null;
            try {
                inClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            DataOutputStream outToCLient = null;
            try {
                outToCLient = new DataOutputStream(connSocket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                String megFromClient = null;
                try {
                    megFromClient = inClient.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Recive: " + megFromClient);
                try {
                    outToCLient.writeBytes(megFromClient.toUpperCase() + '\n');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("send: " + megFromClient.toUpperCase() + '\n');
                if (megFromClient.equals("see you again")) {
                    try {
                        connSocket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        connSocket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }


        }
    }

    
}
