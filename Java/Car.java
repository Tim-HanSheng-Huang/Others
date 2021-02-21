package hw5;

public class Car implements CarbonFootprint
{
	private double FuelConsumption;
	
	public Car(double f)
	{
		FuelConsumption=f;
	}
	
	public double getCarbonFootprint()
	{
		return 0.785*FuelConsumption;//每一公斤的油耗量會產生0.785公斤碳足跡
	}
	
	@Override
	public String toString()
	{
		return String.format("Car CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
