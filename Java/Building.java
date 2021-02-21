package hw5;

public class Building implements CarbonFootprint
{
	private double ElectricityConsumption;
	
	public Building(double e)
	{
		ElectricityConsumption = e;
	}
	
	public double getCarbonFootprint()
	{
		return 0.625*ElectricityConsumption; //建築物中每使用一度電會產生0.625公斤的碳足跡
	}
	
	@Override
	public String toString()
	{
		return String.format("Building CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
