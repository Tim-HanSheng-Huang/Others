package hw5;

public class H34056110 
{
	 public static void main(String[] args)
	 {
		 
		 CarbonFootprint[]CarbonFootprintObjects=new CarbonFootprint[3];
		 
		 CarbonFootprintObjects[0]=new Bicycle(100); //傳入腳踏車里程，並建立物件
		 CarbonFootprintObjects[1]=new Building(200); //傳入建築物用電度數，並建立物件
		 CarbonFootprintObjects[2]=new Car(300); //傳入油耗量，並建立物件
		 
		 System.out.println("CARBONFOOTPRINT REALEASING:");
		 
		 for(CarbonFootprint Current:CarbonFootprintObjects)
		 {
			 System.out.printf("%n%s", Current.toString());
		 }	 
	 }
}
