package myPhonebook;

public class Address {
	private String streetNum;
	private String streetName;
	private String city;
	private String state;
	private String zip;

	public Address(String streetNum, String streetName, String city, String state, String zip) {

		this.streetNum = streetNum;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public void printAddress(String streetNum, String streetName, String city, String state, String zip) {

		System.out.println(streetNum + " " + streetName);
		System.out.println(city + ", " + state + " " + zip);

	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address{" + "streetNum='" + streetNum + '\'' + ", streetName='" + streetName + '\'' + ", city='" + city
				+ '\'' + ", state='" + state + '\'' + ", zip='" + zip + '\'' + '}';
	}
}
