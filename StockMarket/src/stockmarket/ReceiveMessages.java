/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Computing
 */
public class ReceiveMessages extends Thread
{
    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(StockMarket.clientSocket.getInputStream()));
            String tmp;
            while(!(tmp = in.readLine()).equals(null))
            {
                if (tmp.contains("REGI:SUCCESS"))
                {
                    StockMarket._user.UserID = Integer.parseInt(tmp.split(":")[2]);
                    System.out.println(tmp);
                }
                else 
                    System.out.println(tmp);
            }
        }
        catch(Exception e)
        { 
        }
    }
    
    String Receive()
    {
        return "";
    }
}
