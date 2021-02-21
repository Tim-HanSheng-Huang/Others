package hw12_q1;

import java.net.InetAddress;
import java.util.Scanner;

public class H34056110_hw12_q1 {
	

	public static void main(String[]args)
	{
		System.out.println("please input the IP addresses");
		Scanner input=new Scanner(System.in);
		String address = input.nextLine();
		
		try
		{
			InetAddress IP =InetAddress.getByName(address);
			
			System.out.println("IP:"+IP.getHostAddress());
			System.out.println("Hostname:"+IP.getHostName());
			System.out.println(IP);
		}
		catch (Exception e)
		{
			System.out.printf("the domain of %s can not find",address);
		}
		

	}

}
