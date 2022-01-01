import java.io.*;
import java.net.*;
public class WebClient
{
    public static void main(String[] args)
    {
        String hostName = "www.youtube.com";
        int portNumber = 80;
        try
        {
//            It binds the port at the endpoint
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in =new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            out.println("GET / HTTP/1.2\nHost: www.youtube.com \n\n");
            System.out.println("Request is sent");
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                System.out.println(inputLine);
            }
        }
        catch (UnknownHostException e)
        {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } }}
