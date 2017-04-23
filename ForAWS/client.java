package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class client {
	public static void main(String args[]) throws MalformedURLException
	{
		URL url = new URL("http://localhost:8000/update");
		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
		    urlConnection.setChunkedStreamingMode(0);
		    OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
		    out.write("From client".getBytes());
		    out.flush();
		    
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   try {
		     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		     int ch;
		     StringBuilder sb = new StringBuilder();
		     while((ch = in.read()) != -1)
		         sb.append((char)ch);
		     System.out.println(sb.toString());
		     
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		     urlConnection.disconnect();
		   }
	}
}
