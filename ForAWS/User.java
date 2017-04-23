package data;

import java.util.Vector;

public class User {
	private int age;
	private String fname;
	private String lname;
	private String username;
	private String gender;
	//private String type;
	private String description;
	private String image;
	//private HashMap<String, Party> applyparties;
	//private HashMap<String, Party> acceptedparties;
	private Vector<String> hostparties;
	private Vector<String> joinparties;
	
	public User(int age, String fname, String lname, String username, String gender,
			String description, String image, Vector<String> hostparties, Vector<String> joinparties)
	{
		this.age = age;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.gender = gender;
		//this.type = type;
		this.description = description;
		this.image = image;
		this.age = age;
		this.hostparties = hostparties;
		this.joinparties = joinparties;
	}
	
	/*public void applyParty(String id, Party party) {
		applyparties.put(id, party);
		//needs more
	}
	
	public void getAccepted(String id, Party party) {
		acceptedparties.put(id, party);
	}*/
	
	public void hostParty(String partyId)
	{
		hostparties.add(partyId);
	}
	
	public void joinParty(String partyId)
	{
		joinparties.add(partyId);
	}
	
	
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
	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}
	
	/*public HashMap<String, Party> getApplyparties() {
		return applyparties;
	}
	
	public HashMap<String, Party> getAcceptedparties() {
		return acceptedparties;
	}*/
	
	public Vector<String> getHostparties() {
		return hostparties;
	}
	
	public Vector<String> getJoinparties() {
		return joinparties;
	}
	
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
	public void setDescription(String description) {
		this.description=description;
	}
	public void setImage(String image) {
		this.image=image;
	}
	
}
