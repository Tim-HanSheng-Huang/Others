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
		return 0.13*Milage; //�C�M�}�񨮤@�������Ҩ���0.13����
	}

	@Override
	public String toString()
	{
		return String.format("Bicycle CarbonFootprint : %f kg",getCarbonFootprint());
	}
}
