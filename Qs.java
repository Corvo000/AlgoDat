public class Qs 
{
	public static void main(String args[])
    {
		Integer [] test = new Integer[100];
		for(int i=0;i<test.length;i++)
			test[i] = (int) (Math.random() * 10000);
		new Klausur(test);
		for(int i=0;i<test.length;i++)
			System.out.println(test[i] + ",");
		System.out.println();
    }
}
