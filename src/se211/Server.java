package se211;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server extends Thread{



    public static void main(String[] args) {
        ServerSocket serverS;

            try {
                serverS = new ServerSocket(7890);
                while(true){
                    Socket connSocket = serverS.accept();
                    BufferedReader inClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
                    DataOutputStream outToCLient = new DataOutputStream(connSocket.getOutputStream());
                    while(true){
                        String megFromClient = inClient.readLine();

                        System.out.println("Recive: " + megFromClient);
                        outToCLient.writeBytes(megFromClient.toUpperCase() + '\n');
                        System.out.println("send: " + megFromClient.toUpperCase() + '\n');
                        if(megFromClient.equals("see you again")){
                            connSocket.close();
                            serverS.close();
                            break;
                        }
                    }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }


