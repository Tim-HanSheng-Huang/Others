package hw3_2;
import java.util.Scanner;
public class H34056110_3_2 {
	public static void main(String[] args)
	{
		System.out.println("please choose output formats. ( 1: 12hour format / 2: 24hour format / 3: 24hour format but no second ");
		Scanner input= new Scanner(System.in);
		int choice=input.nextInt();
		
		if(choice==1)//�Y��ܲĤ@��
		{
			System.out.println("what time is it ? (hour,minute,second,meridiem)");
			int hour=input.nextInt();
			int minute=input.nextInt();
			int second=input.nextInt();
			String meridiem=input.next();
			
			FancyTime time=new FancyTime(hour,minute,second,meridiem);
			time.Display(hour,minute,second,meridiem);
		}
		else if(choice==2)//��ܲĤG��
		{
			System.out.println("what time is it ? (hour,minute,second)");
			int hour=input.nextInt();
			int minute=input.nextInt();
			int second=input.nextInt();
			FancyTime time=new FancyTime(hour,minute,second);
			time.Display(hour,minute,second);
		}
		else if(choice==3) //��ܲĤT��
		{
			System.out.println("what time is it? (hour,minute)");
			int hour=input.nextInt();
			int minute=input.nextInt();
			FancyTime time=new FancyTime(hour,minute);
			time.Display(hour,minute);
		}
	}
}
