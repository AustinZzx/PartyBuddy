package server;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import data.MangoDriver;
import data.Party;
public class TestServer {
	public static void main (String args[])
	{
		MangoDriver driver = new MangoDriver();
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(8000), 0);
			server.createContext("/update", new MyHandler(driver));
			server.createContext("/refresh",new RefreshHandler(driver));
	        server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        

	}
	

	 static class MyHandler implements HttpHandler {
		 	private MangoDriver driver;
		 	private Gson gson;
		 	public MyHandler(MangoDriver driver)
		 	{
		 		this.driver = driver;
		 		gson = new Gson();
		 	}
	        public void handle(HttpExchange t) throws IOException 
	        {
	        	System.out.println("Test Mgessage Received");
	        	
	        	InputStreamReader in = new InputStreamReader(t.getRequestBody(),"utf-8");
	        	int ch;
			    StringBuilder sb = new StringBuilder();
			    while((ch = in.read()) != -1)
			         sb.append((char)ch);
			    String inputString = sb.toString();
			    System.out.println(t.getRequestMethod()+", "+inputString);
			    
			    JsonElement jelement = new JsonParser().parse(inputString);
			    JsonObject jobject = jelement.getAsJsonObject();
			    String action = jobject.get("action").getAsString();
			    String username = jobject.get("username").getAsString();
			    
			    
			    if(action.toLowerCase().equals("attend"))
			    {
			    	String partyID = jobject.get("partyID").getAsString();
			    	driver.join(username, partyID);
			    }
			    
			    else if(action.toLowerCase().equals("host"))
			    {
			    	String partyID  = jobject.get("partyID").getAsString();
			    	String partyName = jobject.get("partyName").getAsString();
			    	String description = jobject.get("description").getAsString();
			    	String longitude = jobject.get("longitude").getAsString();
			    	String latitude = jobject.get("latitude").getAsString();
			    	Party party = new Party(partyName,description,longitude,latitude,username);
			    	driver.addParty(party);
			    	//TODO 
			    	//send back party ID ?
			    }
			    
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
	        	
	            String response = "From update Server";
	            t.sendResponseHeaders(200, response.length());
	            OutputStream os = t.getResponseBody();

	            os.write(response.getBytes());
	            os.flush();
	            os.close();
	        }
	    }
	 static class RefreshHandler implements HttpHandler {
		 	private MangoDriver driver;
		 	public RefreshHandler(MangoDriver driver)
		 	{
		 		this.driver = driver;
		 	}
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
