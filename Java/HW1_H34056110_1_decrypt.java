import java.util.Scanner;

public class H34056110_1_decrypt {
	
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int password=0;
		int encrypted_password;
		int check=0;//�Ψ��ˬd��J�Ʀr�O�_�ŦX�|���
		int multiplier=1000;
			
		do
		{
			System.out.println("Please enter encrypted password");
			encrypted_password=input.nextInt();//��J�Ʀr
			if (encrypted_password>9999)
			{
				System.out.println("You have to enter a four-digit password ");//��J���~
			}
			else
			{
				check=1;
			}
		}while(check!=1);
			
		for(int i=0;i<4;i++)
		{
			password=password+((encrypted_password+3)%10)*multiplier;
			//�N�C��ƨ̷��D�ت��ۤϤ覡�ഫ�A�̫᭼�W�Ҧb��ƪ�����
			encrypted_password=encrypted_password/10;//���H�Q�A���ഫ�U�@�Ӧ��
			multiplier=multiplier/10;//�Ҧb��Ƨ���
		}
		
		if(password<10) {
			System.out.printf("Your decrypted password is : 000%d%n",password);//�Y��J�Ʀr�p��Q�A�e�T��Ƹɹs
		}
		else if (password<100){
			System.out.printf("Your decrypted password is : 00%d%n",password);//�Y��J�Ʀr�p��@�ʡA�e���Ƹɹs
		}
		else if(password<1000) {
			System.out.printf("Your decrypted password is : 0%d%n",password);//�Y��J�Ʀr�p��@�d�A�e�@��Ƹɹs
		}
		else {
			System.out.printf("Your decrypted password is : %d%n",password);
		}
		
	}
}
