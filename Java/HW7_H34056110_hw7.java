package hw7;
import javax.swing.JOptionPane;

public class H34056110_hw7
{
	
	public static void main(String[]args)
	{
		try
		{
			String firstNumber=JOptionPane.showInputDialog("please input your weight(kg)");
			double weight=Double.parseDouble(firstNumber);
			if(weight<=0)	
				throw new PositiveNumber();
			
			String secondNumber=JOptionPane.showInputDialog("please input your height(m)");			
			double height=Double.parseDouble(secondNumber);
			if(height<=0)	
				throw new PositiveNumber();
			
			double bmi=weight/(height*height);
			
			if(bmi>=24)
			{
				JOptionPane.showMessageDialog(null,String.format("Your BMI is %f %n��a�麥��...��Դ��\��",bmi),
					"CALCULATE YOUR BMI !", JOptionPane.PLAIN_MESSAGE);
			}
			else if(bmi<18.5)
			{
				JOptionPane.showMessageDialog(null,String.format("Your BMI is %f %n��a��w�w...�V�O�[�\��",bmi),
					"CALCULATE YOUR BMI !", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,String.format("Your BMI is %f %n��v���]�I�@°���A�@�]��",bmi),
					"CALCULATE YOUR BMI !", JOptionPane.PLAIN_MESSAGE);
			}				
		}
		catch(PositiveNumber p)
		{
			JOptionPane.showMessageDialog(null,"Message:"+p,"WRONG!!!", JOptionPane.PLAIN_MESSAGE);
		}		
	}
}

class PositiveNumber extends Throwable
{
	public PositiveNumber() {};
	
	public String toString()
	{
		return "Your weight or height should be a positive number.";
	}
		
}