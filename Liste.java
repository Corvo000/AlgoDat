public abstract class Liste<T> 
{
	public abstract void insert(T ele);
	public abstract void insert(T ele,int pos);
	public abstract boolean delete(Function<T,Boolean>fnc);
	public abstract String toString();
}
