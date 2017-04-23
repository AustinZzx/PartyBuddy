package data;

import java.util.UUID;
import java.util.Vector;

public class Party {
	private String id;
	private String name;
	private String description;
	private String longitude;
	private String latitude;
	private String host;
	Vector<String> attenders;
	
	public Party(String name, String description,String longitude,String latitude, String host)
	{
		id = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.host = host;
		this.attenders = new Vector<String>();
	}
	
	public Party(String id, String name, String description,String longitude,String latitude, String host, Vector<String> attenders)
	{
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	public String getDescription()
	{
		return description;
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
	
	public void setdescription(String description)
	{
		this.description = description;
	}
	
	public void setLocation(String longitude, String latitude)
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
