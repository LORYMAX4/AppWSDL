package appwsdl;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    
    public Client ()
    {
        try
        {        
            socket = new Socket("websrv.cs.fsu.edu", 80);
            out = new PrintWriter(socket.getOutputStream(), true);
        }
        catch(Exception e)
        {
            System.out.println("Errore: "+e);
        }
    }
    
    public void send ()
    {
        try
        {
            out.println("POST /~engelen/calcserver.cgi HTTP/1.1");
            out.println("Host: websrv.cs.fsu.edu");
            out.println("Connection: Keep-Alive");
            out.println("Content-Type: text/xml; charset=utf-8");
            out.println("<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:calc\">\n" +
                        "<soapenv:Header/>\n" +
                        "<soapenv:Body>\n" +
                        "<urn:add soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                        "<a xsi:type=\"xsd:double\">?</a>\n" +
                        "<b xsi:type=\"xsd:double\">?</b>\n" +
                        "</urn:add>\n" +
                        "</soapenv:Body>\n" +
                        "</soapenv:Envelope>");
            out.println();
            out.flush();
            System.out.println("xml: ");
            Scanner in = new Scanner(socket.getInputStream());
            String ln;
            while(in.hasNext())
            {
                ln = in.nextLine();
                System.out.println(ln);
            } 
        }
        catch(Exception e)
        {
            System.out.println("Errore: "+e);
        }
    }
    
    public void close ()
    {
        try
        {
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println("Errore: "+e);
        }
    }
}