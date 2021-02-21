package hw10_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class H34056110_hw10_1
{
	public static void main(String args[])throws IOException
	{
		char numberLetters[][] = 
			{
	            {'0','0','0'},{'1','1','1'},{'A','B','C'},
	            {'D','E','F'},{'G','H','I'},{'J','K','L'},
	            {'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'}
	        };
		
		String phonenumber;
		System.out.println("please input a seven-digit number (NO zero or one)");
		Scanner input = new Scanner (System.in);
		phonenumber = input.next();
		char[] word = new char [7];
		
		char[] phonenumberarray = phonenumber.toCharArray ();
		if(phonenumberarray.length!=7)
		{
			System.out.println("You need to input a seven-digit number.Terminating.");
			System.exit(0);
		}
		for(int i=0;i<7;i++)
		{
			if(phonenumberarray[i]=='0'||phonenumberarray[i]=='1')
			{
				System.out.println("You can not input 0 or 1.Terminating.");
				System.exit(0);
			}
		}
		
		int [] digit = new int [phonenumberarray.length];
		for (int i = 0; i < phonenumberarray.length; i++)
        {
            digit[i] = Integer.parseInt(String.valueOf(phonenumberarray[i]));
        }

		FileWriter fw=new FileWriter("PhoneNumberCorresponding.txt");
		for(int p0=0;p0<3;p0++)
		{
			word[0]=numberLetters[digit[0]][p0];
			for(int p1=0;p1<3;p1++)
			{
				word[1]=numberLetters[digit[1]][p1];
				for(int p2=0;p2<3;p2++)
				{
					word[2]=numberLetters[digit[2]][p2];
					for(int p3=0;p3<3;p3++)
					{
						word[3]=numberLetters[digit[3]][p3];
						for(int p4=0;p4<3;p4++)
						{
							word[4]=numberLetters[digit[4]][p4];
							for(int p5=0;p5<3;p5++)
							{
								word[5]=numberLetters[digit[5]][p5];
								for(int p6=0;p6<3;p6++)
								{
									word[6]=numberLetters[digit[6]][p6];
									for(int i=0;i<7;i++)
									{
										fw.write(word[i]);
									}
									fw.write(" ");
								}
							}
						}
					}
				}
			}
		}
		fw.close();
		System.out.println("The file was created successfully.Please check the file in the folder.");
	}
}

