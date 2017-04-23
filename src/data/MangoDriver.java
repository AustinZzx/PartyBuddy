package data;

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
		document.put("type",u.getType());
		document.put("description",u.getDescription());
		document.put("image",u.getImage());
		BasicDBList hostparties;
		
		//document.put("hostparties",);
		
		
		userCollection.insert(document);
	}
	/*
	public User retrieveUser(String username)
	{
		var cursor = db.users.find( { name: 2 } ); 
		
	}*/
}
