package data;

import java.util.Vector;

import com.mongodb.*;

public class MangoDriver {
	private Mongo mg;
	private DB db;
	private DBCollection userCollection, partyCollection;
	
	public void addUser(User u)
	{
		BasicDBObject document = new BasicDBObject();
		document.put("age",u.getAge());
		document.put("fname",u.getFname());
		document.put("lname",u.getLname());
		document.put("username",u.getUsername());
		document.put("gender",u.getGender());
		document.put("description",u.getDescription());
		document.put("image",u.getImage());
		BasicDBList hostparties = new BasicDBList();
		Vector<String> hostpar = u.getHostparties();
		for (int i=0;i<hostpar.size();++i) {
		    hostparties.add(hostpar.get(i));
		}
		document.put("hostparties",hostparties);
		BasicDBList joinparties = new BasicDBList();
		Vector<String> joinpar = u.getJoinparties();
		for (int i=0;i<joinpar.size();++i) {
		    hostparties.add(joinpar.get(i));
		}
		document.put("joinparties",joinparties);
		userCollection.insert(document);
	}
	
	public User getUser(String username)
	{
		BasicDBObject query = new BasicDBObject("username", username);
		BasicDBObject answer = (BasicDBObject)userCollection.find(query).next();
		int age = (int)answer.get("age");
		String fname = (String)answer.get("fname");
		String lname = (String)answer.get("lname");
		String gender = (String)answer.get("gender");
		String description = (String)answer.get("description");
		String image = (String)answer.get("image");
		BasicDBList joinparties = (BasicDBList)answer.get("joinparties");
		BasicDBList hostparties = (BasicDBList)answer.get("hostparties");
		Vector<String> joinpar = new Vector<String>();
		for(int i=0;i<joinparties.size();++i)
		{
			String temp = (String)joinparties.get(i);
			joinpar.add(temp);
		}
		Vector<String> hostpar = new Vector<String>();
		for(int i=0;i<hostparties.size();++i)
		{
			String temp = (String)hostparties.get(i);
			hostpar.add(temp);
		}
		User u = new User(age,fname,lname,username,gender,description,image,hostpar,joinpar);
		return u;
	}
	
	public void addParty(Party p)
	{
		BasicDBObject document = new BasicDBObject();
		document.put("id",p.getId());
		document.put("name",p.getName());
		document.put("location",p.getLocation());
		document.put("longitude",p.getLongitude());
		document.put("latitude",p.getLatitude());
		document.put("host",p.getHost());
		BasicDBList attendies = new BasicDBList();
		Vector<String> attenders = p.getAttenders();
		for (int i=0;i<attenders.size();++i) {
			attendies.add(attenders.get(i));
		}
		document.put("attenders",attendies);
		partyCollection.insert(document);
	}
	
	public Party getParty(String partyid)
	{
		BasicDBObject query = new BasicDBObject("id", partyid);
		BasicDBObject answer = (BasicDBObject)userCollection.find(query).next();
		String name = (String)answer.get("name");
		String location = (String)answer.get("location");
		String longitude = (String)answer.get("longitude");
		String latitude = (String)answer.get("latitude");
		String host = (String)answer.get("host");
		BasicDBList attendies = (BasicDBList)answer.get("attenders");
		Vector<String> attenders = new Vector<String>();
		for(int i=0;i<attendies.size();++i)
		{
			String temp = (String)attendies.get(i);
			attenders.add(temp);
		}
		Party p = new Party(partyid,name,location,longitude,latitude,host,attenders);
		return p;
	}
	
}
