/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Computing
 */


public class User {
   
    public static List<String> STK;
    public static List<String> OwnedStocks;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdin;
    public static SendMessages sender;
    public static ReceiveMessages recieve;
    public static int UserID;
    public static float UserMoney = 150000;
    
    public static boolean Connect()
    {
         try{
            STK = new ArrayList<String>();
            //Connect to the server through the socket
            StockMarket.clientSocket = new Socket("192.168.0.48", 5000);
            //StockMarket.clientSocket = new Socket("localhost", 5000);
            System.out.println("Successfully connected to the server");
            out = new PrintWriter(StockMarket.clientSocket.getOutputStream(), true);
            Start();
            sender.Send("REGI");
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
            System.out.println("Disconnected");
        }
        catch (Exception e){
            System.out.println("Disconnected" + e.toString());
            return false;
        }
        return true; 
    }
    
}

