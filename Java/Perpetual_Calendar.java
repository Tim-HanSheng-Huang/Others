package hw4;

import java.util.Calendar;
import java.util.Scanner;

public class H34056110 {
	  
	public static void main(String[] args) 
	{
		System.out.printf("What kind of calendar do you want? %n1.current month 2.specified month 3.specified year%n");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1)	
		{
			print();
		}
		else if(choice==2)
		{
			System.out.println("please input year");
			int year=input.nextInt();
			System.out.println("please input month");
			int month=input.nextInt();
			if(month>=1&&month<=12)
			{
				print(year,month);
			}
			else
			{
				System.out.println("wrong input!!");
			}
		}
		else if(choice==3)
		{
			System.out.println("please input year");
			int year=input.nextInt();
			print(year);
		}
		else
		{
			System.out.println("wrong input!!");
		}
	}
  
	public static void print() //��X��Ѥ�������
	{
		Calendar now = Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		print(year,month);
	}
	
	public static void printweek(int y,int m,int w) //�H�@�P�@�P���Φ���X
	{
		int [][]print=new int[6][7]; //�H�}�C�s���C�Ӥ몺���A�@�P�@��row
		
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=6;j++)
			{
				print[i][j]=0;
			}
		}
		Calendar d=Calendar.getInstance();
		d.set(y,m-1,1);
		int firstday=d.get(Calendar.DAY_OF_WEEK); //�M��C��Ĥ@�ѬO�P���X�A�Ĥ@�P�p�G���D��������h���L�A�q�U�@�P�}�l�s��
		if(firstday==1)
		{
			allocate(y,m-1,0,0,0,0,0,0,0,print);
		}
		else if(firstday==2)
		{
			allocate(y,m-1,1,0,0,0,0,0,0,print);
		}
		else if(firstday==3)
		{
			allocate(y,m-1,1,1,0,0,0,0,0,print);
		}
		else if(firstday==4)
		{
			allocate(y,m-1,1,1,1,0,0,0,0,print);
		}
		else if(firstday==5)
		{
			allocate(y,m-1,1,1,1,1,0,0,0,print);
		}
		else if(firstday==6)
		{
			allocate(y,m-1,1,1,1,1,1,0,0,print);
		}
		else
		{
			allocate(y,m-1,1,1,1,1,1,1,0,print);
		}
		
		for(int i=0;i<=6;i++)
		{
			int week=w;
			if(print[week][i]==0)
			{
				System.out.print("    "); //�p�G���}�C����0�h�N��D������A�h��X�Ů�
			}
			else
			{
				System.out.printf("%3d ",print[week][i]); //��X��P���
			}
		}
	}
	
	public static void print(int y,int m) //��X���w���
	{
		System.out.printf("     YEAR:%d MONTH:%d%n",y,m);
		System.out.println("SUN MON TUE WED THR FRI SAT");
		int [][]print=new int[6][7]; //�H�}�C�s������A��X
		
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<=6;j++)
			{
				print[i][j]=0;
			}
		}
		Calendar d=Calendar.getInstance();
		d.set(y,m-1,1);
		int firstday=d.get(Calendar.DAY_OF_WEEK);
		if(firstday==1)
		{
			allocate(y,m-1,0,0,0,0,0,0,0,print);
		}
		else if(firstday==2)
		{
			allocate(y,m-1,1,0,0,0,0,0,0,print);
		}
		else if(firstday==3)
		{
			allocate(y,m-1,1,1,0,0,0,0,0,print);
		}
		else if(firstday==4)
		{
			allocate(y,m-1,1,1,1,0,0,0,0,print);
		}
		else if(firstday==5)
		{
			allocate(y,m-1,1,1,1,1,0,0,0,print);
		}
		else if(firstday==6)
		{
			allocate(y,m-1,1,1,1,1,1,0,0,print);
		}
		else
		{
			allocate(y,m-1,1,1,1,1,1,1,0,print);
		}

		
		for(int a=0;a<=5;a++)
		{
			for(int b=0;b<=6;b++)
			{
				if(print[a][b]==0)
				{
					System.out.print("    ");
				}
				else
				{
					System.out.printf("%3d ",print[a][b]);
				}
			}
			System.out.println();
		}
	}

	public static void allocate(int y,int m,int sun,int mon,int tue,int wed,int thr,int fri,int sat,int print[][])
	//�N���w����s�J�۹������}�C��m
	{
		for(int i=1;i<=31;i++)
		{
			Calendar c=Calendar.getInstance();
		    c.set(y, m, i);
		    
		    if(c.get(Calendar.MONTH)+1!=m+1)
		    {
		    	break;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==1)
		    {
		    	print[sun][0]=i;
		    	sun++;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==2)
		    {
		    	print[mon][1]=i;
		    	mon++;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==3)
		    {
		    	print[tue][2]=i;
		    	tue++;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==4)
		    {
		    	print[wed][3]=i;
		    	wed++;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==5)
		    {
		    	print[thr][4]=i;
		    	thr++;
		    }
		    else if(c.get(Calendar.DAY_OF_WEEK)==6)
		    {
		    	print[fri][5]=i;
		    	fri++;
		    }
		    else 
		    {
		    	print[sat][6]=i;
		    	sat++;
		    }
		}
	}
	
	public static void print(int y) //��X���w�~�����
	{
		for(int i=1;i<=12;i=i+3)
		{
			System.out.printf("     YEAR:%d MONTH:%d             YEAR:%d MONTH:%d             YEAR:%d MONTH:%d%n"
									,y,i,y,i+1,y,i+2);
			System.out.println("SUN MON TUE WED THR FRI SAT   "
								+ "SUN MON TUE WED THR FRI SAT   "
								+ "SUN MON TUE WED THR FRI SAT   ");
			
			for(int w=0;w<=5;w++)
			{
				printweek(y,i,w);
				System.out.print("  ");
				printweek(y,i+1,w);
				System.out.print("  ");
				printweek(y,i+2,w);
				System.out.println("");
			}
		}
	}

}
