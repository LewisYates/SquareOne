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
public class StockMarket 
{
    public static Socket clientSocket;
    public static User _user;
    
    public static void main(String[] args) 
    {
        try{
            //clientSocket = new Socket("localhost",5000);
            clientSocket = new Socket("192.168.0.48", 5000);
            System.out.println("Successfully connected to the server");
        }
        catch (Exception e)
        {
            System.out.println(e);
            return;
        }
        
        _user = new User();

        _user.Connect();
        _user.Start();
    }
}