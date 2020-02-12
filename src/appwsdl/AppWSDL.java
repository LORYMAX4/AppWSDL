package appwsdl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AppWSDL 
{

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Client op = new Client();
        op.operazione("add");
        op.operazione("sub");
        op.operazione("mul");
        op.operazione("div");
        op.operazione("pow");
    }
}