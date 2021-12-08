
package com.mycompany.clientudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientUDP {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException{
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Client Started...");
        
        // send
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number");
        String msg = sc.nextLine();
        
        //String msg = "Hey! I am Client..";
        byte b[] = msg.getBytes();
        InetAddress ia = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(b, b.length, ia, 3456);
        ds.send(dp);
        System.out.println("Packets Send...");
        
        // receive
        byte b1[] = new byte[1000];
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);
        String str = new String(dp1.getData());
        System.out.println("Received: " + str);
        ds.close();
        
        
        
    }
    
}
