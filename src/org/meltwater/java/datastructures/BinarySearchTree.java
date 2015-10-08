package org.meltwater.java.datastructures;

public class BinarySearchTree<E extends Comparable<? super E>> {

   
    private int size;
    private BSTNode<E> root;

    public BinarySearchTree () {
        this.root = null;
        size = 0;
    }

    /*
     * Add an element to it's proper place
     * @param value: the new value to be added to the tree
     */
    public void add (E value){
        if (value == null)
            throw new IllegalArgumentException("Value passed is null");
        root = recursiveAdd(root, value);
    }

    /*
     * Recursive helper for add method
     * @param node represents the next node to evaluate
      @param value:value to add
     */
    private BSTNode<E> recursiveAdd(BSTNode<E> node, E value) {
        if (node == null) {
            BSTNode<E> newNode = new BSTNode<E>(null, null, value);
            this.size++;
            return newNode;
        }
        int comparison = value.compareTo(node.getValue());        
        if (comparison > 0) 
            node.setRight(recursiveAdd(node.getRight(), value));
        else if (comparison < 0) 
            node.setLeft(recursiveAdd(node.getLeft(), value));
        else 
            return node;
        return node;
    }

    /*
     *Remove an element from the tree if the element is present
     *@param value: value to remove from tree if present
     */
    public void remove (E value) {
        if (value == null)
            throw new IllegalArgumentException("Value passed is null");
        root = recursiveRemove(root, value);
    }

    /*
     *Recursive helper for remove method
     * @param node: represents the next node to evaluate
     *@param value: value to remove
     */
    private BSTNode<E> recursiveRemove(BSTNode<E> node, E value) {
        if (node == null)
            return null;
        int comparison = value.compareTo(node.getValue());
        if (comparison > 0) 
            node.setRight(recursiveRemove(node.getRight(), value));
        else if (comparison < 0)
            node.setLeft(recursiveRemove(node.getLeft(), value));
        else { // comparison == 0
            size--;
            if (node.getRight() == null && node.getLeft() == null)
                node = null;
            else if (node.getRight() == null) // now that left is not null
                node = node.getLeft(); // return the left node and bypass current node
            else if (node.getLeft() == null)
                node = node.getRight();
            else {
                node.setValue(largest(node.getLeft()));
                node.setLeft(recursiveRemove(node.getLeft(), node.getValue()));
                size++;
            }
        }
        return node;        
    }

    /*
     *getMax returns the largest value searching downwards from current node
     *@param temp:search for largest below temp node
     */
    private E largest (BSTNode<E> temp) {
        while (temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getValue();
    }

    /*
     *isPresent check if node is present
     *@param vlaue: the value to check if present in tree or not
     */
    public boolean isPresent(E value) {
        if (value == null)
            throw new IllegalArgumentException("Value passed is null");
        BSTNode<E> temp = root;
        while(temp != null) {
            int diff = value.compareTo(temp.getValue());
            if (diff == 0)
                return true;
            else if (diff < 0)
                temp = temp.getLeft();
            else
                temp = temp.getRight();
        }
        return false;
    }

    
    // print tree method for testing purposes only
    public void printTree() {
        printTree(root, "");
    }
    
    // print helper
    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getValue());
            printTree(n.getLeft(), spaces + "  ");
        }
    }
  // nested class for Node
  private static class BSTNode<E extends Comparable<? super E> > {

  	// data memebers
  	private E myData;
  	private BSTNode<E> myLeft;
  	private BSTNode<E> myRight;

  	/*
  	 Default Constructor
  	 */
  	public BSTNode () {
  		this(null); 		
  	}

  	/*
  	 *One-arg Constructor with data value
  	 *@param data: initial value of objects myData field
  	 */
  	public BSTNode (E data){
  		this(null, null, data);
  	}

  	/*
  	 *multiple-arg Constructor with data value and child nodes
  	 *@param leftNode: left child node
  	 *@param rightNode: right child node
  	 *@param data:initial value of objects myData field
  	 */
  	public BSTNode (BSTNode<E> leftNode, BSTNode<E> rightNode, E data) {
  		this.myData = data;
  		myLeft = leftNode;
  		myRight = rightNode;
  	}

    /*
     return value stored in the node
     */
     public E getValue () {
        return this.myData;
     }

    /*
     *Set the data of the node
     * @param newData: the new value of the node
     */
    public void setValue(E data) {
        this.myData = data;
    }

    /*
     * return the left child node
     */
    public BSTNode<E> getLeft () {
        return this.myLeft;
    }

    /*
     *return the right child node
     */
    public BSTNode<E> getRight () {
        return this.myRight;
    }
    
    /*
     *set the right child node
     *@param newRight:  new myRight node
     */
    public void setRight (BSTNode<E> newRight) {
        this.myRight = newRight;
    }

    /*
      set the left child node
      @param newLeft:
            new myLeftnode
     */
    public void setLeft (BSTNode<E> newLeft) {
        this.myLeft = newLeft;
    }
  } 
  
 

}


 