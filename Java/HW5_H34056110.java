package hw5;

public class H34056110 
{
	 public static void main(String[] args)
	 {
		 
		 CarbonFootprint[]CarbonFootprintObjects=new CarbonFootprint[3];
		 
		 CarbonFootprintObjects[0]=new Bicycle(100); //�ǤJ�}�񨮨��{�A�ëإߪ���
		 CarbonFootprintObjects[1]=new Building(200); //�ǤJ�ؿv���ιq�׼ơA�ëإߪ���
		 CarbonFootprintObjects[2]=new Car(300); //�ǤJ�o�Ӷq�A�ëإߪ���
		 
		 System.out.println("CARBONFOOTPRINT REALEASING:");
		 
		 for(CarbonFootprint Current:CarbonFootprintObjects)
		 {
			 System.out.printf("%n%s", Current.toString());
		 }	 
	 }
}
