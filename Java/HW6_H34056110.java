package hw6;

import java.util.Scanner;

public class H34056110 
{
	 public static void main(String[] args)
	 {
		 BMICalculator[] BMIArray=new BMICalculator[10];
		 
		 try
		 {
			 for(int i=0;i<5;i++) 
			 {
				Scanner input=new Scanner(System.in);
				
				System.out.println("What's your name?");
				String n=input.nextLine();
				if(n=="0")
					break;
				System.out.println("please input your weight(kg)");
				double w=input.nextDouble();
					if(w<=0) throw new PositiveNumber();
					
				System.out.println("please input your height(m)");
				double h=input.nextDouble();
					if(h<=0) throw new PositiveNumber();
					if(h>=3) throw new ReasonableHeight();
					
				BMIArray[i]=new BMICalculator(n,w,h);
			 }
			 
			 for(int j=0;j<5;j++)
			 {
				 System.out.printf("%n%s", BMIArray[j].toString());
			 }		 
		 }
		 catch(PositiveNumber p)
		 {
			 System.out.println("message:"+p);
		 }
		 catch(ReasonableHeight r)
		 {
			 System.out.println("message:"+r);
		 }
		 


	 }

}
