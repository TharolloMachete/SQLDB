package za.co.sqldb.model;

import java.util.List;

public class PhoneBook {

	private String name;
	private String phoneNumber;
	private List<PhoneBook> phoneBookList;
	
	public PhoneBook(){}
	
	public PhoneBook(String _name, String _phoneNumber){
		this.name = _name;
		this.phoneNumber = _phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String _phoneNumber) {
		this.phoneNumber = _phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}
	
	@Override
	public String toString() {
		return "Name : " + name + " - Phone Number : " + phoneNumber;
	}

	public List<PhoneBook> getPhoneBookList() {
		return phoneBookList;
	}

	public void setPhoneBookList(List<PhoneBook> phoneBooklist) {
		this.phoneBookList = phoneBooklist;
	}
}
