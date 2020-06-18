public class MergeSort 
{
	public static void main(String[] args) 
	{
		int hello[] = {12,13,11,10,9,8,7,6,5,4,3,2,1,0};
		print(hello);
		//MergeSortByDF(hello, 0, hello.length-1);
		MergeSortIter(hello);
		print(hello);
	}
	public static void MergeSortByDF(int [] arr, int l, int r) 
	{
		if((r-l) >=1) 
		{
			MergeSortByDF(arr, l, ((l+r)/2));
			MergeSortByDF(arr, ((l+r)/2)+1, r);
			combine(arr, l, ((l+r)/2), r);
		}
	}
	public static void MergeSortIter(int[] array) 
	{
		int current;
	    int leftStart;
	    int arraySize = array.length - 1;
	    for (current = 1; current <= arraySize; current = 2 * current) {
	        for (leftStart = 0; leftStart <= arraySize; leftStart += 2 * current) {

	            int mid = leftStart + current - 1;
	            int right = getMin(leftStart + 2 * current - 1, arraySize);

	            combine(array, leftStart, mid, right);
	        }

	    }
	}
	public static int getMin(int left, int right) {
	    if (left <= right) {
	        return left;
	    } else {
	        return right;
	    }
	}
	public static void combine(int[]arr,int l, int m,int r) 
	{
		int[] tmp = new int[arr.length];
		int l0 = l;
		int l1 = m;
		int r0 = m+1;
		int r1 = r;
		int idx=0;
		int i = l0; 
		int j = r0;
		while(i<=l1 && j<=r1)
			if(arr[i] < arr[j])
				tmp[idx++] = arr[i++];
			else
				tmp[idx++] = arr[j++];
		while(i <=l1)
			tmp[idx++] = arr[i++];
		while(j<=r1)
			tmp[idx++] = arr[j++];
		idx=0;
		for(int k=l0;k<=r1;k++)
			arr[k] = tmp[idx++];
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
