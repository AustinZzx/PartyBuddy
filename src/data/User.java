package data;

import java.util.Vector;

public class User {
	private int age;
	private String fname;
	private String lname;
	private String username;
	private String gender;
	private String type;
	private String description;
	private String image;
	private Vector<Party> applyparties;
	private Vector<Party> acceptedparties;
	
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
	
	public void requestJoin(Party party) {
		applyparties.add(party);
	}
	
	public void getAccepted(Party party) {
		acceptedparties.add(party);
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
	public String getType() {
		return type;
	}
	public String getDescription() {
		return description;
	}
	public String getImage() {
		return image;
	}
	
	public Vector<Party> getApplyparties() {
		return applyparties;
	}
	
	public Vector<Party> getAcceptedparties() {
		return acceptedparties;
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
