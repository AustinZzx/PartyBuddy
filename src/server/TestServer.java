package server;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
public class TestServer {
	public static void main (String args[])
	{
		 HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/test", new MyHandler());
	        server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        

	}
	 static class MyHandler implements HttpHandler {
	        public void handle(HttpExchange t) throws IOException 
	        {
	            String response = "String";
	            System.out.println("Here");
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();
	            os.write(response.getBytes());
	            os.close();
	        }
	    }
}
