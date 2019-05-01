import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactBook {
	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);
		TreeMap<String,Contact> ContactDB= new TreeMap<>();

		//Search, Add, Delete, Sort
		try 
		{
			Scanner file = new Scanner(new File("ContactFile.txt"));
			while(file.hasNextLine())
			{
			
				String contactLine = file.nextLine();
				String[] entryParts = contactLine.split("\\t");
				String firstName = entryParts[0];
				String lastName = entryParts[1];
				String address = entryParts[2];
				String number = entryParts[3];
				String email = entryParts[4];
				
				ContactDB.put(firstName, new Contact(firstName, lastName, address, number, email));
				
			}
			file.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: The file could not be found");
		}
		
		for(Entry<String, Contact> entry : ContactDB.entrySet()) {
			  String key = entry.getKey();
			  Contact value = entry.getValue();

			  System.out.println(key + " : " + value.Contact);
			}
		System.out.println("\n\n-----------------------------------\n\n");
		while(true)
		{
			System.out.println("Press 1 to search by name, 2 to add, 3 to delete, 4 to sort alphabetically");
			int Action= scan.nextInt();
			if(Action==1) {
				System.out.println("Type the name of the contact you want to see");
				String name2search= scan.next();
				Contact c=searchContact(ContactDB, name2search);
				if(!(c==null)){
				System.out.println(c.Contact);
				}
				else {
					System.out.println("That contact does not exist");
				}
			}
			else if(Action==2) {
				System.out.println("What is the First name?");
				String fn=scan.next();
				System.out.println("What is the Last name?");
				String ln=scan.next();
				System.out.println("What is their number?");
				String n=scan.next();
				System.out.println("What is the email?");
				String e=scan.next();
				System.out.println("What is the address?");
				String a=scan.next();
				addContact(ContactDB, fn, ln, n, e, a);
			}
			else if(Action==3) {
				System.out.println("Who do you want to delete from your contact list?");
				String n=scan.next();
				deleteContact(ContactDB, n);
			}
			else if(Action==4) {
				for(Entry<String, Contact> entry : ContactDB.entrySet()) {
					  String key = entry.getKey();
					  Contact value = entry.getValue();
					  
					  System.out.println(key + " : " + value.Contact);
					}
			}
			else{
				System.out.println("Not an option, enter 1,2,3 or 4");
			}
		}
	}
	
	public static void deleteContact(TreeMap <String, Contact> T, String Name)
	{
		T.remove(Name);
		
	}
	public static void addContact(TreeMap <String, Contact> T, String fn, String ln, String n, String e,String a ) {
		T.put(fn, new Contact(fn,ln,a,n,e));
	}

	public static Contact searchContact(TreeMap <String, Contact> T,String Name) {
		if(T.containsKey(Name))
		{
			Contact c= T.get(Name);
			return c;
		}
		else {
			return null;
		}
	}

}
