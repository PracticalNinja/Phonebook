package myPhonebook;

public class Person {

	private String phoneNum;
	private String firstName;
	private String lastName;
	private String middleName;
	private Address address;
	private String birthday;
	private String email;

	public Person() {

	}

	public Person(String phoneNum, String firstName, String lastName, String middleName, String birthday, String email) { 
		
		this.phoneNum = phoneNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	    this.birthday = birthday; 
	    this.email = email;
	}

	public void addAddress(String streetNum, String streetName, String city, String state, String zip) {

		Address temp = new Address(streetNum, streetName, city, state, zip);
		address = temp;
	}

	public Address getAddress() {
		return this.address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFullName() {
		return firstName + " " + middleName + " " + lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		return this.getFullName().equalsIgnoreCase(person.getFullName())
				&& this.getPhoneNum().equals(person.getPhoneNum());
	}

	@Override
	public String toString() {
		return "Person{" + "phoneNum: '" + phoneNum + '\'' + ", firstName: '" + firstName + '\'' + ", lastName='"
				+ lastName + '\'' + ", middleName='" + middleName + '\'' + ", address=" + address + ", birthday='"
				+ birthday + '\'' + ", email='" + email + '\'' + '}';
	}
}
