package hw2_2;
import java.util.Scanner;

public class H34056110__hw2_2 {
	public static void main(String[]args)
	{
		final int number_of_salespeople=4;//決定銷售員數量
		final int number_of_products=5;//決定商品種類數量
		int salesperson=0;//輸入的銷售員編號
		int product=0;//輸入的商品編號
		int value=0;//輸入的售出價格
		int[][]sales=new int [number_of_salespeople+1][number_of_products+1];//銷售員與商品的陣列
		
		System.out.println("please input the salesperson, produt, and value");
		Scanner input= new Scanner(System.in);
		salesperson=input.nextInt();

		while(salesperson!=-1)//若輸入-1則代表結束輸入
		{
			if(salesperson<number_of_salespeople+1)//以免輸入錯誤
			{
				product=input.nextInt();
				value=input.nextInt();	
				sales[salesperson-1][product-1]+=value;//存入對應的元素
				sales[number_of_salespeople][number_of_products]+=value;//計算總價格
				System.out.println("Please input the salesperson, produt, and value.(Enter -1 to end input)");
				salesperson=input.nextInt();
			}
			else
			{
				System.out.println("wrong input!");
				System.out.println("Please input the salesperson, produt, and value.(Enter -1 to end input)");
				salesperson=input.nextInt();
			}
		}
		
		for(int j=0;j<number_of_products;j++)//計算各商品總價格
		{
			for(int i=0;i<number_of_salespeople;i++)
			{
				sales[number_of_salespeople][j]+=sales[i][j];
			}
		}
		
		for(int i=0;i<number_of_salespeople;i++)//計算個銷售員總價格
		{
			for(int j=0;j<number_of_products;j++)
			{
				sales[i][number_of_products]+=sales[i][j];
			}
		}
		
		//輸出陣列
		System.out.printf("%12s%10s%10s%10s%10s%10s%10s%n"," ","product1","product2","product3","product4","product5","total");
		for(int i=0;i<number_of_salespeople;i++)
		{
			System.out.printf("%s%d","salesperson",i+1);
			for(int j=0;j<number_of_products+1;j++)
			{
				System.out.printf("%10d",sales[i][j]);
			}
			System.out.printf("%n");
		}
		System.out.printf("%12s","total");
		for(int i=0;i<=number_of_products;i++)
		{
			System.out.printf("%10d",sales[number_of_salespeople][i]);
		}
	}
}
