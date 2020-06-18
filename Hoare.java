public class QuiclSortByHoare 
{
	public static void main(String[] args) 
	{
		int hello[] = {12,13,11,10,9,8,7,6,5,4,3,2,1,0};
		print(hello);
		quickSortByHoare(hello, 0, hello.length-1);
		print(hello);
	}
	public static void quickSortByHoare(int [] arr, int l, int r) 
	{
		if(l<r) 
		{
			int p = _getPivot(arr, l, r);
			quickSortByHoare(arr, l, p);
			quickSortByHoare(arr, p+1, r);
		}
	}
	public static int _getPivot(int[]arr,int l, int r) 
	{
		int p=arr[l];
		int le=l-1;
		int re =r+1;
		while(true)
		{
			do 
			{
				le++;
			}while(arr[le] < p);
			do 
			{
				re--;
			}while(arr[re] > p);
			if(le<re)
				swap(arr, le, re);
			else
				return re;
		}
	}
	public static void swap(int[] array,int i, int j) 
    {
    	int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
    }
	public static void print(int[] arr) 
	{
		System.out.print("<");
		for(int i=0;i<arr.length;i++)
			System.out.print(" " + arr[i]);
		System.out.print(" >");
		System.out.println();
	}
}
