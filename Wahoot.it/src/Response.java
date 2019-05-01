public class Response 
{
	private Game myGame;
	private AbstractUser myUser;
	private int myQuestion;
	private String myAnswer;
	private int myDuration;
	private int myTimeStamp;
	
	public Response(Game g, AbstractUser u, int q, String answer, 
			int duration, int timeStamp)
	{
		myGame = g;
		myUser = u;
		myQuestion = q;
		myAnswer = answer;
		myDuration = duration;
		myTimeStamp = timeStamp;
	}
	public Game getGame()
	{
		return myGame;
	}
	public AbstractUser getUser()
	{
		return myUser;
	}
	public int getQuestion()
	{
		return myQuestion;
	}
	public String getAnswer()
	{
		return myAnswer;
	}
	public int getDuration()
	{
		return myDuration;
	}
	public int getTimeStamp()
	{
		return myTimeStamp;
	}
	
	
}

