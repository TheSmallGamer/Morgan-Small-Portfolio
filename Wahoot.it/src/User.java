import java.util.List;

public class User extends AbstractUser
{
	private String myUsername;
	private String myPassword;
	private List<Quiz> myQuizzes;
	
	public User(String userName, String password)
	{
		super(userName);
	}
	
	public User(String[] userData)
	{
		super(userData);
	}
	
	public String getUsername()
	{
		return null;
	}
	
	public void setPassword(String password)
	{

	}
	
	public boolean authenticate(String password)
	{
		return false;
	}
	
	public List<Quiz> getQuizzes()
	{
		return null;
	}
	
	public List<Quiz> getQuiz(String title)
	{
		return null;
	}
	
	public void addQuiz(Quiz q)
	{
		
	}
	
	public String toTSV()
	{
		return null;
	}
	
	public void saveUser()
	{
		
	}
}

























