import java.util.Map;
import java.util.Queue;

public abstract class AbstractUser 
{
	private String myScreenName;
	private Queue<Game> myHistory;
	private int myCurrentScore;
	private int myCurrentStreak;
	
	public AbstractUser(String username)
	{
		
	}
	
	public AbstractUser(String[] userData)
	{
		
	}
	
	public String getScreenName()
	{
		return null;	
	}
	
	public Queue<Game> getGames()
	{
		return null;
	}
	
	public int getScore()
	{
		return -1;
	}
	
	public int getStreak()
	{
		return -1;
	}
	
	public void addGame(Game g)
	{
		
	}
	
	public int addToScore(int i)
	{
		return -1;
	}
	
	public int addToStreak(int i)
	{
		return -1;
	}
	
	public void resetScore()
	{
		
	}
	
	public void resetStreak()
	{
		
	}
	
	public String toTSV()
	{
		 return null;
	}
}








































