

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;


public class MongoTest {
	public static void main(String[] args)
	{
		
		Mongo mongo = null;
		DB db = null;
		DBCollection table = null;
		
		mongo = new Mongo("localhost", 27017);
		System.out.println("a new mongo created!");
		
		//get the connections 
		db = mongo.getDB("testdb");
		System.out.println("the name of the db is :" + db.getName());
		
		table = db.getCollection("testcoll");
		System.out.println("the name of the table is :" + table.getName());
		
		
		table.drop();
		
		//List all databases
		System.out.println("Databases:");
		List<String> dbs = mongo.getDatabaseNames();
		for(String dbset : dbs)
		{
			System.out.println(dbset);
		}
		
		//Collections from a database
		System.out.println("\nCollections: ");
		db = mongo.getDB("local");
		System.out.println("Here db name again " + db.getName());
		Set<String> tables = db.getCollectionNames();
		for(String coll : tables)
		{
			System.out.println("here is set tables");
			System.out.println(coll);
		}
		
		//create documents and insert
		BasicDBObject document = new BasicDBObject();
		document.put("name", "Andre");
		document.put("age", 34);
		System.out.println();
		
		BasicDBObject document2 = new BasicDBObject();
		document2.put("name", "Ben");
		document2.put("age", 19);
		
		table.insert(document);
		table.insert(document2);
		
		//data of collections are output
		System.out.println("\nDatan der Collection");
		BasicDBObject searchQuery = new BasicDBObject();
		
		DBCursor cursor = table.find(searchQuery);
		
		while(cursor.hasNext())
		{
			System.out.println("here is cursor.next");
			System.out.println(cursor.next());
		}
		
		//update
		BasicDBObject query = new BasicDBObject();
		query.put("name", "Andre");
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", "Andre-updated");
		
		BasicDBObject updateObj = new BasicDBObject();
		updateObj.put("$set", newDocument);
		
		table.update(query, updateObj);
		
		//data of collectiosn are output
		System.out.println("\nDaten der Coleection:");
		searchQuery = new BasicDBObject();
		
		while(cursor.hasNext())
		{
			System.out.println("here is cursor.next again");
			System.out.println(cursor.next());
		}
	}
}
