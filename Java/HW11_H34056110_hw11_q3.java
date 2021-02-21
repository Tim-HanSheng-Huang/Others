package hw11_q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H34056110_hw11_q3
{
	public static void main(String[] args) 
	{
		ExecutorService executorService=Executors.newCachedThreadPool();
		
		executorService.execute(new Print("時"));
		executorService.execute(new Print("時"));
		executorService.execute(new Print("示"));
		executorService.execute(new Print("時"));
		executorService.execute(new Print("人"));
		executorService.execute(new Print("，"));
		executorService.execute(new Print("時"));
		executorService.execute(new Print("人"));
		executorService.execute(new Print("自"));
		executorService.execute(new Print("不"));
		executorService.execute(new Print("識"));
		
		executorService.shutdown();
	}

}

