/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author Computing
 */


public class User {
   
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdin;
    static SendMessages sender;
    static ReceiveMessages recieve;
    public static int UserID;
    
    public static boolean Connect()
    {
         try{
            //Connect to the server through the socket
            out = new PrintWriter(StockMarket.clientSocket.getOutputStream(), true);
            //out.print("SquareOne connected");
            //out.print("HELP");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
       return true; 
    }
    
    public static void Start()
    {
        sender = new SendMessages();
        Thread sendThread = new Thread(sender);
        sendThread.start();
        
        recieve = new ReceiveMessages();
        Thread receiveThread = new Thread(recieve);
        receiveThread.start();
    }
    
    public static void End()
    {
        Disconnect();
    }

    public static boolean Disconnect()
    {
        try{
            /*in.close();
            stdin.close();
            out.close();*/
            StockMarket.clientSocket.close();
        }
        catch (Exception e){
            System.out.println("Disconnected" + e.toString());
            return false;
        }
        return true; 
    }
    
}

