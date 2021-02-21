import java.util.Scanner;

public class H34056110_1_encrypt {
	
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int password;
		int encrypted_password=0;
		int check=0;//ノㄓ浪琩块计琌才计
		int multiplier=1000;
			
		do
		{
			System.out.println("Please enter password");
			password=input.nextInt();//块计
			if (password>9999)
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
			encrypted_password=encrypted_password+((password%10+7)%10)*multiplier;
			//盢–计ㄌ肈ヘ璶―锣传┮计计
			password=password/10;//埃传锣传计
			multiplier=multiplier/10;//┮计э跑
		}
		
		if(encrypted_password<10) {
			System.out.printf("Your encrypted password is : 000%d%n",encrypted_password);//璝块计玡计干箂
		}
		else if (encrypted_password<100){
			System.out.printf("Your encrypted password is : 00%d%n",encrypted_password);//璝块计κ玡ㄢ计干箂
		}
		else if(encrypted_password<1000) {
			System.out.printf("Your encrypted password is : 0%d%n",encrypted_password);//璝块计玡计干箂
		}
		else {
			System.out.printf("Your encrypted password is : %d%n",encrypted_password);
		}
		
	}
}
