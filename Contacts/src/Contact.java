
public class Contact {
//phone, email, address, first and last
public String FirstName;
public String LastName;
public String Address;
public String Number;
public String Email;
public String Contact;

public Contact(String f,String l,String a,String n,String e) 
{
	FirstName=f;
	LastName=l;
	Address=a;
	Number=n;
	Email=e;
	Contact = LastName + " \t" + Address + " \t" + Number + " \t" + Email;
}

public String getFirstName() {
	return FirstName;
}

public void setFirstName(String firstName) {
	FirstName = firstName;
}

public String getLastName() {
	return LastName;
}

public void setLastName(String lastName) {
	LastName = lastName;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getNumber() {
	return Number;
}

public void setNumber(String number) {
	Number = number;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}


}
