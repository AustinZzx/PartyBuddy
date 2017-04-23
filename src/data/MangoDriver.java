package data;

import java.util.Vector;

import com.mongodb.*;

public class MangoDriver {
	private Mongo mg;
	private DB db;
	private DBCollection userCollection, partyCollection;
	private DBCursor userCursor, partyCursor;
	
	public MangoDriver()
	{
		mg = new Mongo("localhost", 27017);
		db = mg.getDB("hackcu");
		userCollection = db.getCollection("Users");
		partyCollection = db.getCollection("Party");
		userCursor = userCollection.find();
		partyCursor = partyCollection.find();
	}
	
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
	
	public Vector<Party> getUserJoinParty(User u)
	{
		Vector<Party> result = new Vector<Party>();
		Vector<String> joinparties = u.getJoinparties();
		for(int i=0;i<joinparties.size();++i)
		{
			result.add(getParty(joinparties.get(i)));
		}
		return result;
	}
	
	public Vector<Party> getUserHostParty(User u)
	{
		Vector<Party> result = new Vector<Party>();
		Vector<String> joinparties = u.getHostparties();
		for(int i=0;i<joinparties.size();++i)
		{
			result.add(getParty(joinparties.get(i)));
		}
		return result;
	}
	
	public Vector<User> getPartyAttenders(Party p)
	{
		Vector<User> result = new Vector<User>();
		Vector<String> joinparties = p.getAttenders();
		for(int i=0;i<joinparties.size();++i)
		{
			result.add(getUser(joinparties.get(i)));
		}
		return result;
	}
	
	public void join(String username, String partyID)
	{	
		////////////////Update PartyCollection///////////////////////////
		//new party member list
		BasicDBList newAttenders = new BasicDBList();
		
		BasicDBObject query = new BasicDBObject("id", partyID);
		
		DBCursor c = partyCollection.find(query);
		if(c.hasNext())
		{
			BasicDBObject obj = (BasicDBObject) c.next();
			BasicDBList oldAttenders = (BasicDBList) obj.get("attenders");
			for (Object o : oldAttenders)
			{
				newAttenders.add(o);
			}
		}
		
		BasicDBObject newMember = new BasicDBObject("username", username);
		newAttenders.add(newMember);
		
		
		BasicDBObject newPartyObj = new BasicDBObject();
		newPartyObj.put("attenders", newAttenders);
				
		BasicDBObject update = new BasicDBObject();

		update.append("$set", newPartyObj);
		//Update the collection
		partyCollection.update(query, update);
		///////////////////////////////////////////////////////
		
		////Update userCollection/////////////////////////////
		BasicDBList newParties = new BasicDBList();
		
		BasicDBObject userQuery = new BasicDBObject("username", username);
		
		DBCursor cc = partyCollection.find(userQuery);
		if(cc.hasNext())
		{
			BasicDBObject obj = (BasicDBObject) cc.next();
			BasicDBList oldParties = (BasicDBList) obj.get("joinparties");
			for (Object o : oldParties)
			{
				newParties.add(o);
			}
		}
		BasicDBObject newParty = new BasicDBObject("id", partyID);
		newParties.add(newParty);	
		
		BasicDBObject newUserObj = new BasicDBObject();
		newUserObj.put("joinparties", newParties);
				 
		BasicDBObject update1 = new BasicDBObject();
	
		update1.append("$set", newUserObj);
		//Update the collection
		partyCollection.update(userQuery, update1);	
	}
	
	public void Host(User u, Party p)
	{
		p.addAttender(u);
		addParty(p);
	}
}
