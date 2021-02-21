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
		return 0.785*FuelConsumption;//�C�@���窺�o�Ӷq�|����0.785����Ҩ���
	}
	
	@Override
	public String toString()
	{
		return String.format("Car CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
