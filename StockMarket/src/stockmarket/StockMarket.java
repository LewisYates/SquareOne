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

    public static void main(String[] args) 
    {
            SendMessages send = new SendMessages();
            ReceiveMessages receive = new ReceiveMessages();
            User newUser = new User();
                    
            newUser.Connect();
            newUser.Disconnect();
            
    }
}