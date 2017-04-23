package data;

import java.util.HashMap;
import java.util.Map.Entry;
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
		    hostparties.add(hostpar[i]);
		}
		document.put("hostparties",hostparties);
		BasicDBList joinparties = new BasicDBList();
		Vector<String> joinpar = u.getJoinparties();
		for (int i=0;i<joinpar.size();++i) {
		    hostparties.add(joinpar[i]);
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
}
