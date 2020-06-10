package Bäume;

import java.util.function.Consumer;

public class BinFirst 
{
	BinaryNode<Integer> createTree()
    {
        BinaryNode<Integer> zero = new BinaryNode<Integer>(0);
        BinaryNode<Integer> one = new BinaryNode<Integer>(1);
        BinaryNode<Integer> five = new BinaryNode<Integer>(5);
        BinaryNode<Integer> seven = new BinaryNode<Integer>(7);
        BinaryNode<Integer> eight = new BinaryNode<Integer>(8);
        BinaryNode<Integer> nine = new BinaryNode<Integer>(9);
    
        seven.leftChild = one;
        seven.rightChild = nine;
        nine.leftChild = eight;
        one.leftChild = zero;
        one.rightChild = five;
    
        return seven;
    }
    
    static public void main(String args[])
    {
        BinFirst treeController = new BinFirst();
        BinaryNode<Integer> root = treeController.createTree();
        System.out.println(root);
        System.out.println();
	    Consumer<BinaryNode<Integer>>print = a -> {System.out.println(a.getValue());};    
        root.preOrderTransversal(print);
        System.out.println();
        root.inOrderTransversal(print);
        System.out.println();
        root.postOrderTransversal(print);
        System.out.println();
        root.getHeigth(root);
    }
}

