public class SplayTree<T extends Comparable<? super T>> {
    
    public SplayNode<T> root;

    SplayTree()
    {
        root = null;
    }
    
    SplayTree(T value)
    {
        root = new SplayNode<T>(value);
    }
    
    public String toString()
    {
        return root.toString();
    }
    public void insertRec(T value)
    {
        root = _insertRec(root, value);
    }
    private SplayNode<T> _insertRec(SplayNode<T> currentNode, T value)
    {
        if (currentNode == null) return new SplayNode<T>(value);
        
        if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _insertRec(currentNode.leftChild, value);
        else
            currentNode.rightChild = _insertRec(currentNode.rightChild, value);  
        
        return currentNode;      
    }
    public Boolean isIn(T value)
    {
        SplayNode<T> currentNode = root;  
        
        while ((currentNode != null) && (value.compareTo(currentNode.getValue()) != 0))
        {
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;            
        }
        
        return (currentNode != null);
    } 
    public void delete(T value)
    {
        root = _delete(root, value);
    }
    
    private SplayNode<T> _delete(SplayNode<T> currentNode, T value)
    {
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.getValue()) == 0)
        {
            if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) return null;
            if (currentNode.leftChild == null) return currentNode.rightChild;
            if (currentNode.rightChild == null) return currentNode.leftChild;

            T replacement = getMinValue(currentNode.rightChild);
            currentNode.setValue(replacement);
            currentNode.rightChild = _delete(currentNode.rightChild, replacement);
        }
        else if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _delete(currentNode.leftChild, value);
        else
            currentNode.rightChild = _delete(currentNode.rightChild, value);
               
        return currentNode;
    }
    
    private T getMinValue(SplayNode<T> forNode)
    {
        while(forNode.leftChild != null)
        {
            forNode = forNode.leftChild;
        }
        return forNode.getValue();
    }
    private SplayNode<T> leftRotation(SplayNode<T> node)
    {
    	SplayNode<T> tmp = node.rightChild;
    	node.rightChild = tmp.leftChild;
    	tmp.leftChild = node;
        return tmp;
    }
    
    private SplayNode<T> rightRotation(SplayNode<T> node)
    {
    	SplayNode<T> tmp = node.leftChild;
    	node.leftChild = tmp.rightChild;
    	tmp.rightChild = node;
        return tmp;
    }
    public void printWayToNodeRec(T value) 
    {
    	if(!isIn(value))
    		return;
    	_printWayToNodeRec(root, value);
    }
    public void _printWayToNodeRec(SplayNode<T> cur,T value) 
    {
    	
    	if(value.compareTo(cur.getValue()) == 0)
    	{
    		System.out.print(cur.getValue());
    		return;
    	}
		else
			System.out.print(cur.getValue() + ",");
    	if(value.compareTo(cur.getValue()) < 0)
    		_printWayToNodeRec(cur.leftChild, value);
    	else		
    		_printWayToNodeRec(cur.rightChild, value);
    	return;
    }
    public void printWayToNode(T value) 
    {
    	//Ausgabe vom Knoten zum ELement
    	if(!isIn(value))
    		return;
    	if(value.compareTo(root.getValue()) == 0)
    		System.out.println(root.getValue());
    	SplayNode<T> cur = root;
    	while(cur != null) 
    	{
    		if(value.compareTo(cur.getValue()) == 0)
    		{
    			System.out.print(cur.getValue());
    			break;
    		}
    		if(value.compareTo(cur.getValue()) < 0)
    		{
    			System.out.print(cur.getValue() + ",");
    			cur = cur.leftChild;
    		}	
    		else 
    		{
    			System.out.print(cur.getValue() + ",");
    			cur = cur.rightChild;
    		}
    	}
    }
    public SplayNode<T> _printRecToRoot(SplayNode<T> cur, T value) 
    {
    	if(value.compareTo(cur.getValue()) ==0) 
    	{
    		System.out.print(cur.getValue() + ",");
    		return cur;
    	}
    	if(value.compareTo(cur.getValue()) < 0)
    		cur.leftChild = _printRecToRoot(cur.leftChild, value);
    	else 
    		cur.rightChild = _printRecToRoot(cur.rightChild, value);
    	if(cur.equals(root))
    		System.out.println(cur.getValue());
    	else	
    		System.out.print(cur.getValue() + ",");
    	return null;
    }
    public void printWayBack(T value) 
    {
    	//Ausgabe vom ELement zum Knoten
    	if(!isIn(value))
    		return;
    	if(value.compareTo(root.getValue()) == 0)
    		System.out.println(root.getValue());
    	 _printRecToRoot(root, value);
    }
}
