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

/**
 *
 * @author Computing
 */


public class User {
   
     static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdin;
    
    public static boolean Connect()
    {
         try{
            //Connect to the server through the socket
            clientSocket = new Socket("192.168.0.48", 5000);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            //out.print("SquareOne connected");
            //out.print("HELP");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
         
        //Make this methods
        try{
            
            stdin = new BufferedReader(new InputStreamReader(System.in));
            out.println("HELP");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String tmpStr;
            while((tmpStr = in.readLine()) != null)
            {
                System.out.println(tmpStr);
            }
            
        }
        catch(Exception e)
        { 
        }  
                System.out.println("Debug1");
        
       return true; 
    }

    public static boolean Disconnect()
    {
        try{
            in.close();
            stdin.close();
            out.close();
            clientSocket.close();
        }
        catch (Exception e){
            System.out.println("Disconnected" + e.toString());
            return false;
        }
        return true; 
    }
    
}

