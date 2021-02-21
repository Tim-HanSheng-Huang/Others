package hw6;

public class BMICalculator 
{
	private String name;
	private double weight;
	private double height;
	
	public BMICalculator(String n,double w,double h)
	{
		name=n;
		weight=w;
		height=h;
	}
	
	public double getBMI()
	{
		return weight/(height*height);
	}
	
	public String getMessage()
	{
		if(this.getBMI()>=24)
		{
			return "overweight (衣帶日漸緊...當勤減餐飯)";
		}
		else if(this.getBMI()<18.5)
		{
			return "underweight (衣帶日已緩...努力加餐飯)";
		}
		else
		{
			return "optimal weight (賢哉汝也！一簞食，一瓢飲)";
		}
	}
	
	public String toString()
	{
		return String.format("%s, your BMI is %f. You are %s",name,getBMI(),getMessage());
	}
	
}

