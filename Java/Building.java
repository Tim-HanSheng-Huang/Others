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
		return 0.625*ElectricityConsumption; //�ؿv�����C�ϥΤ@�׹q�|����0.625���窺�Ҩ���
	}
	
	@Override
	public String toString()
	{
		return String.format("Building CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
