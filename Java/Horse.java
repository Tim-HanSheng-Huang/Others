package hw11_q8;

public class Horse implements Runnable
{
	private int meter=500;
	private int step=0;
	private String name;

	public static boolean ready=false; //�]�m�@boolean��ready�A��@��j�_�]�˵� 
	
	Horse(String n)
	{
		this.name=n;
	}
	
	public String getname()
	{
		return name;
	}
	
	public void run()
	{
		while(ready==true)
		{
			step+=(int)(java.lang.Math.random()*10);
			if(step>=meter)
				break;
		}
		System.out.printf("FINISHED:%s%n",this.getname());
	}

}
