package hw11_q3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H34056110_hw11_q3
{
	public static void main(String[] args) 
	{
		ExecutorService executorService=Executors.newCachedThreadPool();
		
		executorService.execute(new Print("��"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("�H"));
		executorService.execute(new Print("�A"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("�H"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("��"));
		executorService.execute(new Print("��"));
		
		executorService.shutdown();
	}

}

