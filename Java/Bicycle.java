package hw5;

public class Bicycle implements CarbonFootprint
{
	private double Milage;
	
	public Bicycle (double m)
	{
		Milage = m;
	}

	public double getCarbonFootprint()
	{
		return 0.13*Milage; //每騎腳踏車一公里的碳足跡為0.13公斤
	}

	@Override
	public String toString()
	{
		return String.format("Bicycle CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
