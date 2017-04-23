package data;

import java.util.UUID;
import java.util.Vector;

public class Party {
	private String id;
	private String name;
	private String location;
	private String longitude;
	private String latitude;
	private String host;
	Vector<String> attenders;
	
	public Party(String name, String location,String longitude,String latitude, String host, Vector<String> attenders)
	{
		id = UUID.randomUUID().toString();
		this.name = name;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.host = host;
		this.attenders = attenders;
	}
	
	public Party(String id, String name, String location,String longitude,String latitude, String host, Vector<String> attenders)
	{
		this.id = id;
		this.name = name;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
		this.host = host;
		this.attenders = attenders;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public String getLongitude()
	{
		return longitude;
	}
	
	public String getLatitude()
	{
		return latitude;
	}
	
	public String getHost()
	{
		return host;
	}
	
	public Vector<String> getAttenders()
	{
		return attenders;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setGeoLocation(String longitude, String latitude)
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public boolean hasAttender(String username)
	{
		return attenders.contains(username);
	}
	
	public void addAttender(User user)
	{
		attenders.add(user.getUsername());
	}
	
	public void removeAttender(String username)
	{
		attenders.remove(username);
	}
}
