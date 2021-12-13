package print.object;

public class Address {
	public String city;
	public int zipCode;
	
	public Address(String city, int zipCode) {
		super();
		this.city = city;
		this.zipCode = zipCode;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}
