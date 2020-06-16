package BinarySearchTree;

import java.util.Random;
import java.util.Arrays;

public class SortedArray {
    private int aArray[];
    private int aSize;
    private Random dice;

    final private int MAXVALUE = 21;
    
    SortedArray()
    {
        aSize = 42;
		aArray = new int[42];
        
        dice = new Random(4221);	
		
		for (int i=0; i<aSize; i+=1)
			aArray[i] = dice.nextInt(MAXVALUE);
        Arrays.sort(aArray);
    }
        
    int getAnyValue()
    {
        return aArray[dice.nextInt(aSize)];
    }
    
    // #####.    #####.    #####.    #####.    #####.    #####.    ######
    
    Boolean findFastInArrayRec(int aValue)
    {
        return false;
    }
    
    Boolean findInArray(int aValue)
    {
    	//O( n )
    	for(int i=0;i<aSize;i++)
    		if(aArray[i] == aValue) 
    			return true;
        return false;
    }

    Boolean findFastInArray(int aValue)
    {
    	int l, r, m;
    	l = 0;
    	r = aSize-1;
    	m = (r+l)/2;
    	while(l < r) 
    	{
    		if(aValue == aArray[m])
    			return true;
    		if(aValue < aArray[m])
    			r = m-1;
    		else 
    			l = m+1;
    		m = (r+l)/2;
    	}
        return aArray[l] == aValue;
    }
    
    public static void main(String args[])
    {
        SortedArray myArray = new SortedArray();
        System.out.println(myArray.findInArray(4));
        System.out.println(myArray.findFastInArray(5));
        System.out.println(myArray.findFastInArray(myArray.getAnyValue()));
    }
}
