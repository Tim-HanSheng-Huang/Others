package hw2_2;
import java.util.Scanner;

public class H34056110__hw2_2 {
	public static void main(String[]args)
	{
		final int number_of_salespeople=4;//�M�w�P����ƶq
		final int number_of_products=5;//�M�w�ӫ~�����ƶq
		int salesperson=0;//��J���P����s��
		int product=0;//��J���ӫ~�s��
		int value=0;//��J����X����
		int[][]sales=new int [number_of_salespeople+1][number_of_products+1];//�P����P�ӫ~���}�C
		
		System.out.println("please input the salesperson, produt, and value");
		Scanner input= new Scanner(System.in);
		salesperson=input.nextInt();

		while(salesperson!=-1)//�Y��J-1�h�N������J
		{
			if(salesperson<number_of_salespeople+1)//�H�K��J���~
			{
				product=input.nextInt();
				value=input.nextInt();	
				sales[salesperson-1][product-1]+=value;//�s�J����������
				sales[number_of_salespeople][number_of_products]+=value;//�p���`����
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
		
		for(int j=0;j<number_of_products;j++)//�p��U�ӫ~�`����
		{
			for(int i=0;i<number_of_salespeople;i++)
			{
				sales[number_of_salespeople][j]+=sales[i][j];
			}
		}
		
		for(int i=0;i<number_of_salespeople;i++)//�p��ӾP����`����
		{
			for(int j=0;j<number_of_products;j++)
			{
				sales[i][number_of_products]+=sales[i][j];
			}
		}
		
		//��X�}�C
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
