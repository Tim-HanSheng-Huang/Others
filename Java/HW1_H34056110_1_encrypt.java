import java.util.Scanner;

public class H34056110_1_encrypt {
	
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int password;
		int encrypted_password=0;
		int check=0;//�Ψ��ˬd��J�Ʀr�O�_�ŦX�|���
		int multiplier=1000;
			
		do
		{
			System.out.println("Please enter password");
			password=input.nextInt();//��J�Ʀr
			if (password>9999)
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
			encrypted_password=encrypted_password+((password%10+7)%10)*multiplier;
			//�N�C��ƨ��D�حn�D�ഫ�A�A���W�Ҧb��ƪ�����
			password=password/10;//���H�Q�A���ഫ�U�@�Ӧ��
			multiplier=multiplier/10;//�Ҧb��Ƨ���
		}
		
		if(encrypted_password<10) {
			System.out.printf("Your encrypted password is : 000%d%n",encrypted_password);//�Y��J�Ʀr�p��Q�A�e�T��Ƹɹs
		}
		else if (encrypted_password<100){
			System.out.printf("Your encrypted password is : 00%d%n",encrypted_password);//�Y��J�Ʀr�p��@�ʡA�e���Ƹɹs
		}
		else if(encrypted_password<1000) {
			System.out.printf("Your encrypted password is : 0%d%n",encrypted_password);//�Y��J�Ʀr�p��@�d�A�e�@��Ƹɹs
		}
		else {
			System.out.printf("Your encrypted password is : %d%n",encrypted_password);
		}
		
	}
}
