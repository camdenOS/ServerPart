package se211;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTwo {
    public static void main(String[] args) {
        try {
            Socket socket= new Socket("localhost",7890);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

            BufferedReader userType= new BufferedReader(new InputStreamReader(System.in));


            while(true) {
                String str = userType.readLine() + '\n';
                outToServer.writeBytes(str);
                System.out.println("send : " + str);

                String inMeg = inFromServer.readLine();
                System.out.println(inMeg);

                if (str.equals("see you again\n") ) {
                    socket.close();
                    System.out.println("server connection termtinated");
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
