package server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class client {
	public static void main(String args[]) throws MalformedURLException
	{
		URL url = new URL("http://localhost:8000/test");
		HttpURLConnection urlConnection = null;
		try {
			urlConnection = (HttpURLConnection) url.openConnection();
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
