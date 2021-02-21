package hw11_q8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H34056110_hw11_q8
{
	
	public static void main(String[] args) 
	{
		ExecutorService executorService=Executors.newCachedThreadPool();
		Horse Horse1=new Horse("Horse1");
		Horse Horse2=new Horse("Horse2");
		Horse Horse3=new Horse("Horse3");
		Horse Horse4=new Horse("Horse4");
		Horse Horse5=new Horse("Horse5");
		
		Horse.ready=true; //鳴槍起跑，將ready的boolean改成true
		
		executorService.execute(Horse1);
		executorService.execute(Horse2);
		executorService.execute(Horse3);
		executorService.execute(Horse4);
		executorService.execute(Horse5);
		
		executorService.shutdown();

	}


	

}
