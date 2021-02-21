package hw2_1;
import java.util.Scanner;
public class H34056110__hw2_1 {
	
	static boolean[] seat= {false,false,false,false,false,false,false,false,false,false};//記錄座位目前狀況
	static int first_class_seat=0;//記錄頭等艙安排順序
	static int economy_seat=5;//記錄經濟艙安排順序
	static int seat_check=0;//檢查座位是否被坐滿
	
	public static void assign_First_class()//若選擇頭等艙
	{
		Scanner input= new Scanner(System.in);
		if(seat[first_class_seat]==false)//如果此艙等有空位
		{
			System.out.printf("Your seat number is : %d%n",(first_class_seat+1));//輸出座位
			seat[first_class_seat]=true;//記錄此座位已有人
			first_class_seat++;//下一位選擇此艙等的人安排在下一個位置
			seat_check++;//有人的座位數量加一
			if(first_class_seat>=5)
			{
				first_class_seat=4;//以免超出陣列範圍
			}
		}
		else
		{
			System.out.println("This section is full.Do you want to change your class?(1 for yes and 2 for no)");
			//此艙等已無座位，詢問是否換艙等
			int reply=input.nextInt();
			if(reply==1&& (seat_check<9) )
			{
				assign_Economy();//更換至經濟艙
			}
			else
			{
				System.out.println("Next flight leaves in 3 hours");//不更換艙等
			}}}
	
	public static void assign_Economy()//若選擇經濟艙
	{
		Scanner input= new Scanner(System.in);
		if(seat[economy_seat]==false)//如果此艙等有空位
		{
			System.out.printf("Your seat number is : %d%n",(economy_seat+1));//輸出座位
			seat[economy_seat]=true;//記錄此座位已有人
			economy_seat++;//下一位選擇此艙等的人安排在下一個位置
			seat_check++;//有人的座位數量加一
			if(economy_seat>=10)
			{
				economy_seat=9;//以免超出陣列範圍
			}
		}
		else
		{
			System.out.println("This section is full.Do you want to change your class?(1 for yes and 2 for no");
			//此艙等已無座位，詢問是否換艙等
			int reply=input.nextInt();
			if(reply==1&&(seat_check<9))
			{
				assign_First_class();//更換至頭等艙
			}
			else
			{
				System.out.println("Next flight leaves in 3 hours");//不更換艙等
			}}}

	public static void main(String[]args)
	{	
		do 
		{
			Scanner input= new Scanner(System.in);
			int airplane_class;	
			System.out.println("Please type your airplane class.( 1 for First Class and 2 for Economy)");
			airplane_class=input.nextInt();
			
			if(airplane_class==1)//若選擇頭等艙
			{
				assign_First_class();
			}
			else if(airplane_class==2)//若選擇經濟艙
			{
				assign_Economy();
			}
			else
			{
				System.out.println("wrong input");
			}
			
			System.out.print("Current situation : ");//輸出目前座位情況
			for(int i=0;i<=9;i++)
			{
				if(seat[i]==false)
					System.out.print(" V ");
				else
					System.out.print(" X ");
			}
			System.out.println(" ");
			
		}while(seat_check<=9);
		
		System.out.println("This plane is full.Next flight leaves in 3 hours");//飛機已做滿，無法繼續輸入
	}
}
