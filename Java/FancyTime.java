package hw3_2;

public class FancyTime {

	private int hour;
	private int minute;
	private int second;
	private String meridiem;
	
	public FancyTime(int hour,int minute, int second, String meridiem) //第一種類型的建構子
	{
		if(hour<0||hour>12)
			throw new IllegalArgumentException("hour must be 0-12");
		if(minute<0||minute>=60)
			throw new IllegalArgumentException("minute must be 0-59");
		if(second<0||second>=60)
			throw new IllegalArgumentException("second must be 0-59");
		this.hour=hour;
		this.minute=minute;
		this.second=second;
		this.meridiem=meridiem; 
	}
	
	public FancyTime(int hour,int minute,int second) //第二種類型的建構子
	{
		if(hour<0||hour>24)
			throw new IllegalArgumentException("hour must be 0-24");
		if(minute<0||minute>=60)
			throw new IllegalArgumentException("minute must be 0-59");
		if(second<0||second>=60)
			throw new IllegalArgumentException("second must be 0-59");
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	public FancyTime(int hour,int minute) //第三種類型的建構子
	{
		if(hour<0||hour>24)
			throw new IllegalArgumentException("hour must be 0-24");
		if(minute<0||minute>=60)
			throw new IllegalArgumentException("minute must be 0-59");
		this.hour=hour;
		this.minute=minute;
	}
	
	public void Display(int hour,int minute, int second,String meridiem) //第一種類型的輸出函示
	{
		System.out.printf("Time is %02d:%02d:%02d %s",this.hour,this.minute,this.second,this.meridiem);
	}
	
	public void Display(int hour,int minute,int second) //第二種類型的輸出函式
	{
		System.out.printf("Time is %02d:%02d:%02d",this.hour,this.minute,this.second);
	}
	
	public void Display(int hour,int mimute) //第三種類型的輸出函式
	{
		System.out.printf("Time is %02d:%02d",this.hour,this.minute);
	}
}
