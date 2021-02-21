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
			return "overweight (��a�麥��...��Դ��\��)";
		}
		else if(this.getBMI()<18.5)
		{
			return "underweight (��a��w�w...�V�O�[�\��)";
		}
		else
		{
			return "optimal weight (��v���]�I�@°���A�@�]��)";
		}
	}
	
	public String toString()
	{
		return String.format("%s, your BMI is %f. You are %s",name,getBMI(),getMessage());
	}
	
}

