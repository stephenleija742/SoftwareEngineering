package panel;

/***
 * stores information about a patient. bunch of getters and setters
 * 
 * @author Stephen's Laptop
 *
 */

public class StaffModel extends UserModel {

	private String appt;
	private String firstname, lastname, password, userName, email, address, phoneNum,
					userMessage, patient;
	private Gateway gateway;

	// eventually all textfield info from view will be passed into constructor
	public StaffModel(String firstName, String lastName, String userName,
			char[] otherPassword, String email, String address, String phoneNum, Gateway g) {
		// TODO enforce better constraints
		this.firstname = firstName;
		this.lastname = lastName;
		this.userName = userName;
		if (otherPassword != null) {
			String tmpPassword = new String(otherPassword);
			this.password = tmpPassword;
		}
		this.email = email;
		this.address = address;
		this.phoneNum = phoneNum;
		this.gateway = g;
	}

	public void setPassword(String otherPassword) {
		password = otherPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String name) {
		firstname = name;
	}

	public void setLastName(String name) {
		lastname = name;
	}

	public String getFirstName() {
		return firstname;
	}

	public String getUserName() {
		return this.userName;
	}

	// for the staff and doctor(maybe?) view
	public String getAppt() {
		return appt;
	}

	public String getLastName() {
		return this.lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getUserType() {
		// TODO Auto-generated method stub
		return 3;
	}

	public void addUser(String name, String password) {
		// TODO Auto-generated method stub
	}
	
	public void setMessage(String message){
		this.userMessage = message;
		gateway.updateMessage(this.userMessage, this.userName);
	}
	
	public String getUserMessage(){
		return this.userMessage;
	}

	@Override
	public void fromUser(String user) {
		this.patient = user;
	}
	
	public String getPatientName(){
		return this.patient;
	}

	@Override
	public void setAppt(String date) {
		// TODO Auto-generated method stub
		
	}
}
