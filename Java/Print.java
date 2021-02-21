package hw11_q3;

public class Print implements Runnable
{
	
	private String word;
	
	public Print(String w)
	{
		this.word=w;
	}
	public String getword()
	{
		return word;
	}
	public void run()
	{
		System.out.printf("%s",this.getword());
	}
}
