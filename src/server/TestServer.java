package server;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			server.createContext("/refresh",new RefreshHandler());
	        server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        

	}
	 static class MyHandler implements HttpHandler {
	        public void handle(HttpExchange t) throws IOException 
	        {
	        	System.out.println("Test Mgessage Received");

	        	InputStreamReader in = new InputStreamReader(t.getRequestBody(),"utf-8");
	        	int ch;
			    StringBuilder sb = new StringBuilder();
			    while((ch = in.read()) != -1)
			         sb.append((char)ch);
			    String input = sb.toString();
			    System.out.println(t.getRequestMethod()+", "+input);
			    /*
	        	String qry;
	        	InputStream in = t.getRequestBody();
	        	try {
	        	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	        	    byte buf[] = new byte[4096];
	        	    for (int n = in.read(buf); n > 0; n = in.read(buf)) {
	        	        out.write(buf, 0, n);
	        	    }
	        	    qry = new String(out.toByteArray(), "UTF-8");
	        	    System.out.println(qry);
	        	} finally {
	        	    in.close();
	        	}
	        	*/
	        	
	            String response = "From Test Server";
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();
	            os.write(response.getBytes());
	            os.flush();
	            os.close();
	        }
	    }
	 static class RefreshHandler implements HttpHandler {
	        public void handle(HttpExchange t) throws IOException 
	        {
	        	System.out.println("Refresh Mgessage Received");
	        	
	        	InputStreamReader in = new InputStreamReader(t.getRequestBody(),"utf-8");
	        	int ch;
			    StringBuilder sb = new StringBuilder();
			    while((ch = in.read()) != -1)
			         sb.append((char)ch);
			    String input = sb.toString();
			    System.out.println(t.getRequestMethod()+", "+input);
		
	        	
	            String response = "From Refresh Server";
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();
	            os.write(response.getBytes());
	            os.flush();
	            os.close();
	        }
	    }
}
