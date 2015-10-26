/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Michael
 */
public class StockMarket {

    Socket clientSocket;
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        try{
            //Connect to the server through the socket
            clientSocket = new Socket("192.168.0.48", 5000);
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            out.printf("hello");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
}
