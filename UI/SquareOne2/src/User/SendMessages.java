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
            while(!(tmp = reader.readLine()).equals("STOP"))
            {
                    Send(tmp);
            }
            StockMarket._user.End();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
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
