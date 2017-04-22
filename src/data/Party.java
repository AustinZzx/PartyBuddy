package data;

import java.util.Vector;

public class Party {
	private String name;
	private String location;
	private int longitude;
	private int latitude;
	private User host;
	Vector<User> attenders;
	
	public Party(String name, String location,int longitude,int latitude, User host)
	{
		this.name = name;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.host = host;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String location()
	{
		return location;
	}
	
	public int getLongitude()
	{
		return longitude;
	}
	
	public int getLatitude()
	{
		return latitude;
	}
	
	public User getHost()
	{
		return host;
	}
	
	public Vector<User> getAttenders()
	{
		return attenders;
	}
	

}
