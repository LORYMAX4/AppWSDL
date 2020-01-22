package appwsdl;

public class AppWSDL
{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.send();
        client.close();
    }
}