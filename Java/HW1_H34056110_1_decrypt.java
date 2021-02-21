import java.util.Scanner;

public class H34056110_1_decrypt {
	
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int password=0;
		int encrypted_password;
		int check=0;//ノㄓ浪琩块计琌才计
		int multiplier=1000;
			
		do
		{
			System.out.println("Please enter encrypted password");
			encrypted_password=input.nextInt();//块计
			if (encrypted_password>9999)
			{
				System.out.println("You have to enter a four-digit password ");//块岿粇
			}
			else
			{
				check=1;
			}
		}while(check!=1);
			
		for(int i=0;i<4;i++)
		{
			password=password+((encrypted_password+3)%10)*multiplier;
			//盢–计ㄌ酚肈ヘはよΑ锣传程┮计计
			encrypted_password=encrypted_password/10;//埃传锣传计
			multiplier=multiplier/10;//┮计э跑
		}
		
		if(password<10) {
			System.out.printf("Your decrypted password is : 000%d%n",password);//璝块计玡计干箂
		}
		else if (password<100){
			System.out.printf("Your decrypted password is : 00%d%n",password);//璝块计κ玡ㄢ计干箂
		}
		else if(password<1000) {
			System.out.printf("Your decrypted password is : 0%d%n",password);//璝块计玡计干箂
		}
		else {
			System.out.printf("Your decrypted password is : %d%n",password);
		}
		
	}
}
