
public class H34056110_2 {

	public static void main(String[] args)
	{
		double current=1.35;//原始人口為1.35billion
		double future;
		double rate=0.01;//人口成長率從1%開始算起
		
		for(int i=1;i<8;i++)
		{
			future=current*Math.exp(rate*10);//套入題目公式計算
			System.out.printf("When the growth rate is %d%%, the population will be %f billions in ten years.%n",i,future);
			rate=rate+0.01;//接下來討論人口成長率再加1%時的情況
		}
	}

}
