import java.util.function.Function;


public class EinfachVerketteteListe<T> extends Liste<T> 
{
	private Knoten kopf;
	private class Knoten
	{
		private Knoten next;
		private T value;
		public Knoten(T value) 
		{
			this.value = value;
			this.next = null;
		}
	}
	@Override
	public void insert(T ele) 
	{
		
	}
	@Override
	public void insert(T ele, int pos) 
	{
		
	}
	@Override
	public boolean delete(Function<T, Boolean> fnc) 
	{
		
		return false;
	}
	@Override
	public String toString() 
	{
		String v = "< ";
		Knoten current = kopf;
		while(current != null) 
		{
			v += current.value + " ";
			current = current.next;
		}
		v += ">";
		return v;
	}

}
