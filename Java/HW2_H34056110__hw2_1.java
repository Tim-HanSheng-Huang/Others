package hw2_1;
import java.util.Scanner;
public class H34056110__hw2_1 {
	
	static boolean[] seat= {false,false,false,false,false,false,false,false,false,false};//�O���y��ثe���p
	static int first_class_seat=0;//�O���Y�����w�ƶ���
	static int economy_seat=5;//�O���g�ٿ��w�ƶ���
	static int seat_check=0;//�ˬd�y��O�_�Q����
	
	public static void assign_First_class()//�Y����Y����
	{
		Scanner input= new Scanner(System.in);
		if(seat[first_class_seat]==false)//�p�G���������Ŧ�
		{
			System.out.printf("Your seat number is : %d%n",(first_class_seat+1));//��X�y��
			seat[first_class_seat]=true;//�O�����y��w���H
			first_class_seat++;//�U�@���ܦ��������H�w�Ʀb�U�@�Ӧ�m
			seat_check++;//���H���y��ƶq�[�@
			if(first_class_seat>=5)
			{
				first_class_seat=4;//�H�K�W�X�}�C�d��
			}
		}
		else
		{
			System.out.println("This section is full.Do you want to change your class?(1 for yes and 2 for no)");
			//�������w�L�y��A�߰ݬO�_������
			int reply=input.nextInt();
			if(reply==1&& (seat_check<9) )
			{
				assign_Economy();//�󴫦ܸg�ٿ�
			}
			else
			{
				System.out.println("Next flight leaves in 3 hours");//���󴫿���
			}}}
	
	public static void assign_Economy()//�Y��ܸg�ٿ�
	{
		Scanner input= new Scanner(System.in);
		if(seat[economy_seat]==false)//�p�G���������Ŧ�
		{
			System.out.printf("Your seat number is : %d%n",(economy_seat+1));//��X�y��
			seat[economy_seat]=true;//�O�����y��w���H
			economy_seat++;//�U�@���ܦ��������H�w�Ʀb�U�@�Ӧ�m
			seat_check++;//���H���y��ƶq�[�@
			if(economy_seat>=10)
			{
				economy_seat=9;//�H�K�W�X�}�C�d��
			}
		}
		else
		{
			System.out.println("This section is full.Do you want to change your class?(1 for yes and 2 for no");
			//�������w�L�y��A�߰ݬO�_������
			int reply=input.nextInt();
			if(reply==1&&(seat_check<9))
			{
				assign_First_class();//�󴫦��Y����
			}
			else
			{
				System.out.println("Next flight leaves in 3 hours");//���󴫿���
			}}}

	public static void main(String[]args)
	{	
		do 
		{
			Scanner input= new Scanner(System.in);
			int airplane_class;	
			System.out.println("Please type your airplane class.( 1 for First Class and 2 for Economy)");
			airplane_class=input.nextInt();
			
			if(airplane_class==1)//�Y����Y����
			{
				assign_First_class();
			}
			else if(airplane_class==2)//�Y��ܸg�ٿ�
			{
				assign_Economy();
			}
			else
			{
				System.out.println("wrong input");
			}
			
			System.out.print("Current situation : ");//��X�ثe�y�챡�p
			for(int i=0;i<=9;i++)
			{
				if(seat[i]==false)
					System.out.print(" V ");
				else
					System.out.print(" X ");
			}
			System.out.println(" ");
			
		}while(seat_check<=9);
		
		System.out.println("This plane is full.Next flight leaves in 3 hours");//�����w�����A�L�k�~���J
	}
}
