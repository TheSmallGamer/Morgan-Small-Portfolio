import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class WahootSession 
{
	private static WahootSession theSession;
	private User myUser;
	private Map<String, Quiz> allQuizzes;  //TreeMap<title, quiz>  \\
	private Map<String, User> allUsers;   //HashMap<username, user>	\\
	private Map<String, Game> allGames;  //HashMap<quiz title, game> \\
	
	private WahootSession()
	{
		
	}
	public static void main(String[] args) 
	{
		
	}
	public WahootSession getSession()
	{
		if(theSession == null){     theSession = new WahootSession();     }
		return theSession;
	}
	private void loadUsers() 
	{
		
	}
	private void loadQuizzes()
	{
		
	}
	public Map<String, User> getUsers()
	{
		return null;
	}
	public User getUser(String user)
	{
		return null;
	}
	public AbstractUser guest()
	{
		//user has clicked Guest
		return null;
	}
	public AbstractUser register()
	{
		//user has clicked Register
		return null;
	}
	public AbstractUser login()
	{
		//user has clicked Login
		return null;
	}
	public void saveUsers()
	{
		
	}
	public Map<String, Quiz> getQuizzes()
	{
		return null;
	}
	public Quiz getQuiz(String title)
	{
		return null;
	}
	public void saveQuizzes()
	{
		
	}
	private void loadGames()
	{
		
	}
	public Map<String, Game> getGames()
	{
		return null;
	}
	public void saveGames()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
