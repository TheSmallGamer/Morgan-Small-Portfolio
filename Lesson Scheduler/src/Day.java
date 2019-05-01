/**
 * 
 * @author Jamie Small
 * 
 * This class defines the "Day" with variables such as the day, time, month, and year, along with the name of 
 * the student who's requesting this certain day and time
 *
 */
public class Day 
{
	private int day;
	private String time;
	private String studentName;
	private int month;
	private int year;
	/**
	 * 
	 * @param day - the specific day within a month
	 * @param month - the specific month within a year
	 * @param year - the specific year of the requested date
	 * @param time - the specific time throughout the day requested
	 * @param studentName - the name of the student requesting this certain date and time
	 */
	public Day(int day, int month, int year, String time, String studentName)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.time = time;
		this.studentName = studentName;
	}
	
	
	/**
	 * Getters and setters
	 * Allows the user to retrieve and set values to certain "Day" values
	 */
	public int getDay()
	{
		return day;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public String getStudentName()
	{
		return studentName;
	}
	
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	/**
	 * toString()
	 * print out in the proper form for other classes to utilize
	 */
	public String toString()
	{
		return day + "\t" + month + "\t" + year + "\t" + time + "\t" + studentName;
	}
	
	
}
