import java.io.IOException;

public class AccountPolicies {

	public static void disableBIAccounts() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\"
				+ "CyberPatriotProject\\CyberPatriot Windows Script\\src\\resources\\DisableAdminGuest.bat\"");
	}
	
	public static void opnUsrsLst() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject\\"
				+ "CyberPatriot Windows Script\\src\\resources\\listShares.bat\"");
	}
	
}
