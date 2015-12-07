/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

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
                System.out.println(tmp);
                if (tmp.contains("REGI:SUCCESS"))
                {
                    String s = tmp.split(":")[2];
                    StockMarket._user.UserID = Integer.parseInt(s);
                }
                else if(tmp.contains("STK"))
                {
                    StockMarket._user.STK.add(tmp);
                }
                else if(tmp.contains("ACK:BUY"))
                {
                    String[] SplitString = tmp.split(":");
                    StockMarket._user.UserMoney-=Float.valueOf(SplitString[5]);
                    StockMarket._user.OwnedStocks.add(SplitString[4] + ":" + SplitString[3]);
                }
                else if(tmp.contains("ACK:SELL"))
                {
                    
                }
            }
        }
        catch(Exception e)
        { 
        }
    }
    
    String Receive(String s)
    {
        return s;
    }
    
    public int checkStock(String name)
    {
        int quantity = 0;
        for(int i = 0; i < StockMarket._user.OwnedStocks.size() ;i ++)
        {
            String entry = StockMarket._user.OwnedStocks.get(i);
            if (entry.contains (name))
            {
                String[] SplitString = entry.split(":");
                quantity+=Integer.parseInt(SplitString[1]);
            }
        }
        return quantity;
    }
}
