
import java.util.ArrayList;
/**
 * 
 * @author Jamie Small
 *This class instantiates a Student value, including specific details of each user, and allows the program to print 
 *this user's information to a secure document externally
 */
public class Student 
{
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private ArrayList<String> days = new ArrayList<String>();
	private ArrayList<String> times = new ArrayList<String>();
	
	/**
	 * 
	 * @param firstName - displays the first name of the "Student"
	 * @param lastName - displays the last name of the "Student"
	 * @param email - displays the email address of the "Student"
	 * @param phoneNumber - displays the phone number of the "Student"
	 * @param username - displays the username of the "Student"
	 * @param password - displays the password of the "Student"
	 */
	public Student(String firstName, String lastName, 
			String email, String phoneNumber, String username, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Getters and setters
	 * Allows the users to retrive and set values to certain "Student" values
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String name) 
	{
		firstName = name;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String name) 
	{
		lastName = name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public ArrayList<String> getDays()
	{
		return days;
	}
	
	public void setDays(ArrayList<String> days)
	{
		this.days = days;
	}
	
	public ArrayList<String> getTimes()
	{
		return times;
	}
	
	public void setTimes(ArrayList<String> times)
	{
		this.times = times;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * toString() to print the output properly for the use of other classes
	 */
	public String toString()
	{
		return firstName + "\t" + lastName + "\t" + phoneNumber + "\t" + email + "\t" + username + "\t" + password;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
