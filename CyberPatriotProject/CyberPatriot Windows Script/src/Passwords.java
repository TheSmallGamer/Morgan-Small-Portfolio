import java.io.IOException;

public class Passwords 
{
	public static void setPasswordPolicies() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\"
				+ "CyberPatriotProject\\CyberPatriot Windows Script\\src\\resources\\PasswordPolicies.bat\"");
	}
	
	public static void setPasswordsToExpire() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject"
				+ "\\CyberPatriot Windows Script\\src\\resources\\Set Passwords Expire.bat\"");
	}
	
	public static void turnOffAutoLogin() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"CHANGE\"");
	}
}
















