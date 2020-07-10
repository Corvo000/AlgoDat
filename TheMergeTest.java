public class TheMergeTest 
{
	public static void main(String[] args) 
	{
		int [] arr1 = new int[] {2,4,7,3,4,52};
		int [] arr2 = new int[] {1,2,3,4,5,6,51};
		int[] arr3 = mergeIter(arr1,arr2);
		System.out.println(Arrays.toString(arr3));
		int[] arr4 = mergeRec(arr1, arr2);
		System.out.println(Arrays.toString(arr4));
	}
	public static int[] mergeIter(int arr1[], int arr2[]) 
	{
		int erg[] = new int[arr1.length+arr2.length];
		int l0 = 0;
		int l1 = arr1.length-1;
		int r0 = 0;
		int r1 = arr2.length-1;
		int i = l0;
		int j = r0;
		int idx=0;
		while((i<=l1)&&(j<=r1))
			if(arr1[i] < arr2[j])
				erg[idx++] = arr1[i++];
			else
				erg[idx++] = arr2[j++];
		while(i<=l1)
			erg[idx++] = arr1[i++];
		while(j<=r1)
			erg[idx++] = arr2[j++];
		return erg;
	}
	public static int[] mergeRec(int arr1[], int arr2[]) 
	{
		int [] erg = new int[arr1.length+arr2.length];
		_mergus(arr1,arr2,erg,0,0,0); 
		return erg;		
	}
	public static void _mergus(int arr1[], int arr2[], int[]erg, int idx1, int idx2, int idxErg) 
	{
		if(idxErg > erg.length)
			return;
		if(idx1 > arr1.length-1)
		{
			_mergus42(arr2,erg,idx2,idxErg);
			return;
		}
		if(idx2 > arr2.length-1)
		{
			_mergus41(arr1,erg,idx1,idxErg);
			return;
		}
		if(arr1[idx1] < arr2[idx2])
			erg[idxErg++] = arr1[idx1++];
		else
			erg[idxErg++] = arr2[idx2++];
		_mergus(arr1,arr2,erg,idx1,idx2,idxErg);
	}
	public static void _mergus41(int arr1[], int[]erg, int idx1, int idxErg) 
	{
		if(idx1 > arr1.length-1)
			return;
		erg[idxErg++] = arr1[idx1++];
		_mergus41(arr1,erg,idx1,idxErg);
	}
	public static void _mergus42(int arr2[], int[]erg, int idx2, int idxErg) 
	{
		if(idx2 > arr2.length-1)
			return;
		erg[idxErg++] = arr2[idx2++];
		_mergus41(arr2,erg,idx2,idxErg);
	}
}
