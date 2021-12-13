package print.object;

public class Person {
	public String name;
	public int age;
	public Address address;
	public Person sibling;
	
	
	public Person(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public Person getSibling() {
		return sibling;
	}

	public void setSibling(Person sibling) {
		this.sibling = sibling;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
