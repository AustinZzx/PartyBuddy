package data;


import java.util.HashMap;

public class User {
	private int age;
	private String fname;
	private String lname;
	private String username;
	private String gender;
	private String type;
	private String description;
	private String image;

	private HashMap<String, Party> applyparties;
	private HashMap<String, Party> acceptedparties;
	private HashMap<String, Party> hostparties;
	private HashMap<String, Party> joinparties;
	
	public User(int age, String fname, String lname, String username, String gender,
			String type, String description, String image)
	{
		this.age = age;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.gender = gender;
		this.type = type;
		this.description = description;
		this.image = image;
		this.age = age;
	}
	
<<<<<<< HEAD
=======
	public void applyParty(String id, Party party) {
		applyparties.put(id, party);
		//needs more
	}
	
	public void getAccepted(String id, Party party) {
		acceptedparties.put(id, party);
	}
	
	public void hostParty(String id, Party party)
	{
		hostparties.put(id, party);
	}
	
	public void joinParty(String id, Party party)
	{
		joinparties.put(id, party);
	}
	
	
>>>>>>> a084deeb05652df2c59716bf29b7497777fd558f
	public int getAge() {
		return age;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getUsername() {
		return username;
	}
	public String getGender() {
		return gender;
	}
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}
	
<<<<<<< HEAD
=======
	public HashMap<String, Party> getApplyparties() {
		return applyparties;
	}
	
	public HashMap<String, Party> getAcceptedparties() {
		return acceptedparties;
	}
	
>>>>>>> a084deeb05652df2c59716bf29b7497777fd558f
	public void setAge(int age) {
		this.age=age;
	}
	public void setFname(String fname) {
		this.fname=fname;
	}
	public void setLname(String lname) {
		this.lname=lname;
	}
	/*public void setUsername(String username) {
		this.username=username;
	}*/
	public void setGender(String gender) {
		this.gender=gender;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public void setImage(String image) {
		this.image=image;
	}
	
}
