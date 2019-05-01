import java.io.IOException;

public class Firewall {

	public static void enableDisableRD() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\"
				+ "OneDrive\\Desktop\\CyberPatriotProject\\CyberPatriot Windows Script\\src\\resources\\Remote Desktop.bat\"");
	}
	
	public static void auditPolicies() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject\\"
				+ "CyberPatriot Windows Script\\src\\resources\\Audit Policies.bat\"");
	}
	
	public static void activate() throws IOException
	{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject\\"
				+ "CyberPatriot Windows Script\\src\\resources\\Activate Firewall.bat\"");
	}

	public static void disableServices() throws IOException{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject\\"
				+ "CyberPatriot Windows Script\\src\\resources\\Unnecessary Services.bat\"");
	}
	
	public static void disableFeatures() throws IOException{
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:\\Users\\jamie\\OneDrive\\Desktop\\CyberPatriotProject\\"
				+ "CyberPatriot Windows Script\\src\\resources\\disableServices.bat\"");
	}

}
