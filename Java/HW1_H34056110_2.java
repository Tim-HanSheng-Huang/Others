
public class H34056110_2 {

	public static void main(String[] args)
	{
		double current=1.35;//��l�H�f��1.35billion
		double future;
		double rate=0.01;//�H�f�����v�q1%�}�l��_
		
		for(int i=1;i<8;i++)
		{
			future=current*Math.exp(rate*10);//�M�J�D�ؤ����p��
			System.out.printf("When the growth rate is %d%%, the population will be %f billions in ten years.%n",i,future);
			rate=rate+0.01;//���U�ӰQ�פH�f�����v�A�[1%�ɪ����p
		}
	}

}
