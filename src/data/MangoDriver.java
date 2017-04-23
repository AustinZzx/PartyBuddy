package data;

import com.mongodb.*;

public class MangoDriver {
	private Mongo mg;
	private DB db;
	private DBCollection userCollection, partyCollection;
	
	public void addUser(User u)
	{
		userCollection.insert( { name: u.getUsername(), age: u.getUsername() } );
	}
	public User retrieveUser(String username)
	{
		var cursor = db.users.find( { name: 2 } ); 
		
	}
}
