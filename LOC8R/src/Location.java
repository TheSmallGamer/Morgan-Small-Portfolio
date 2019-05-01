
public class Location 
{
	private String name;
	private String address;
	private String businessType;
	private double latitude;
	private double longitude;
	
	public Location(String n, String a, String t, double lat, double lon, int r, boolean f, boolean s)
	{
		name = n;
		address = a;
		businessType = t;
		latitude = lat;
		longitude = lon;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	public String getBusinessType()
	{
		return businessType;
	}
	public double getLatitude()
	{
		return latitude;
	}
	public double getLongitude()
	{
		return longitude;
	}
	
	
	
}
