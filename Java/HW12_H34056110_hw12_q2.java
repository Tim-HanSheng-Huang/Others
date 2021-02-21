package hw12_q2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class H34056110_hw12_q2 {
	public static void main(String[]args)
	{
		try
		{
			Socket socket=new Socket("140.116.99.26",13);
			
			BufferedReader dis=
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String msg =dis.readLine();
			System.out.println("DATE & TIME : "+msg);
			
			socket.close();
		}
		catch(IOException e)
		{
			System.out.println("wrong");
		}
		

	}

}
