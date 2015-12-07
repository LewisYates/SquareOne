/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
import java.io.*;

/**
 *
 * @author Computing
 */
public class SendMessages extends Thread
{
    public void run()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String tmp;             
            while(!(tmp = reader.readLine()).equals(""))
            {
                String[] SplitString = tmp.split(":");
                if(tmp.contains("DISP"))
                {
                    StockMarket._user.STK.clear();
                    Send(tmp+":"+StockMarket._user.UserID);
                }
                else if(tmp.contains("BUY"))
                {
                    if (StockMarket._user.UserMoney > ((findCompanyCost(SplitString[1]))*Float.valueOf(SplitString[2])))
                    {
                        Send(tmp+":"+StockMarket._user.UserID);
                    }
                    else
                    {
                        System.out.println("Unable to purchase stocks. Insufficeint funds! YOU MUST CONSTRUCT ADDITIONAL PYLONS!");
                    }
                }
                else
                {
                Send(tmp);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public float findCompanyCost(String name)
    {
        for(int i = 0; i < StockMarket._user.STK.size() ;i ++)
        {
            String entry = StockMarket._user.STK.get(i);
            if (entry.contains (name))
            {
                String[] SplitString = entry.split(":");
                return Float.valueOf(SplitString[2]);
            }
        }
        return(0);
    }
    
    public void Send(String message)
    {
        try{
            PrintWriter out = new PrintWriter(StockMarket.clientSocket.getOutputStream(), true);
            out.println(message);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
