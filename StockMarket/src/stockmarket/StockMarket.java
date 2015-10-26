/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Michael
 */
public class StockMarket {

    static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdin;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Server Connect "+Connect());
 
        //Make this methods
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            stdin = new BufferedReader(new InputStreamReader(System.in));
            out.println("HELO");
            System.out.println("echo: " + in.read());
        }
        catch(Exception e)
        {
            
        }
        
        
        System.out.println("Server Disconnect "+Disconnect());
    }
    public static boolean Connect(){
         try{
            //Connect to the server through the socket
            clientSocket = new Socket("192.168.0.48", 5000);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.print("SquareOne connected");
        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
        return true; 
    }
    
    public static boolean Disconnect()
    {
        try{
            in.close();
            out.close();
            stdin.close();
            clientSocket.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
        return true; 
    }
}
