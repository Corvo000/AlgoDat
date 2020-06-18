package DatenStrukturQueue;

public class QueueViaArray<T> extends Queue<T> 
{
	T arr[];
	int first=0;
	int last=0;
	public QueueViaArray() 
	{
		
	}
	@Override
	public void put(T value) 
	{
	
	}
	@Override
	public T get() 
	{
		
	}
	@Override
	public boolean isEmpty() 
	{
		
	}
	@Override
	protected void _growIfNeeded() 
	{
	
	}
	@Override
	protected void _shrinkIfNeeded() 
	{
		
	}
	public String toString()  
	{
		String v=" | ";
		for(int i =0;i<arr.length;i++)
			v += arr[i] + " | ";
//		v += "\nLength: " + q.length;
		return v;
	}
}
