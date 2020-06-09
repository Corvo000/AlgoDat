package AllSorts1;

import java.util.Arrays;

public class RadixSort 
{
	public static void main(String[] args) 
	{
		int hello[] = {12,13,11,10,9,8,7,6,5,4,3,2,1,0};
		print(hello);
		radixSort(hello);
		print(hello);
	}
	public static void radixSort(int [] arr) 
	{
		int m = getMax(arr, arr.length); 
        for(int i=1; m/i>0; i*=10) 
            countSort(arr,i); 
	}
	static void countSort(int arr[], int exp) 
    { 
        int tmp[] = new int[arr.length];  
        int i; 
        int count[] = new int[10];  
        for(i=0; i<arr.length; i++) 
            count[(arr[i]/exp)%10]++; 
        for(i=1; i<10; i++) 
        	count[i] += count[i - 1]; 
        for(i=arr.length-1; i>=0; i--) 
        { 
            tmp[count[(arr[i]/exp)%10] - 1] = arr[i]; 
            count[(arr[i]/exp)%10]--; 
        } 
        for(i = 0; i < arr.length; i++) 
            arr[i] = tmp[i]; 
    } 
	static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
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
