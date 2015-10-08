package org.meltwater.java.datastructures;

public abstract class SinglyLinkedList<T> implements Iterable<T> {
	
	/* Objects and Variables */
	BetterArray betterArray = new BetterArray();
	private int count;
	private LinearNode<T> head, tail;
	
	/**
	 * Constructor:
	 * sets count equal to null and head and tail equal to null
	 */
	public SinglyLinkedList() {
		count = 0;
		head = tail = null;
		betterArray = new BetterArray<>();
	}
	
	 /**
     * Adds a T element to the SinglyLinkedList
     *
     * @param element T element to be added
     */
    public void add(T element) {
        betterArray.append(element);
    }
	
    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    public int size() {
    	
    	return count;
    }

	
    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     */
	 public T head () throws EmptyCollectionException {
	    	
	    	if(count == 0)
	    		throw new EmptyCollectionException("Empty List.");
	    	return head.getElement();
	    }

	    /**  
	     * Returns a reference to the last element in this list. 
	     *
	     * @return a reference to the last element in this list
	     */
	    public T tail() {
	    	
	    	if(count == 0)
	    		throw new EmptyCollectionException("Empty List.");
	    	return tail.getElement();
	    }

	
    /**  
     * Removes and returns the specified element from the list. 
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
    	
    	boolean found = false;
    	LinearNode<T> previous;
    	LinearNode<T> current;
    	
    	if (count == 0)
    		throw new EmptyCollectionException("Element Not In List.");
    	
    	previous = null;
    	current = head;
    	
    	while(current != null && !found) {
    		if(element.equals(current.getElement()))
    			found = true;
    		else {
    			previous = current;
    			current = current.getNext();
    		}
    	}
    	
    	if(!found)
    		throw new ElementNotFoundException("Element Not in List.");
    	else {
    		if(count == 1)
    			head = tail = null;
    		else if(current.equals(head))
    			head = current.getNext();
    		else if(current.equals(tail)){
    			tail = previous;
    			tail.setNext(null);
    		}
    		else
    			previous.setNext(current.getNext());
    	}
    	
    	count--;
    	
    	return current.getElement();
    }
   
    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T element) {
    	
    	LinearNode<T> current;
    	current = head;
    	while(current != null && !(current.getElement().equals(element))) {
    		current = current.getNext();
    	}
    	
    	if(current != null)
    		return true;
    	else
    		return false;
    }

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
    	
    	return (count == 0);
    }

    /**  
     * Returns a string representation of the list. 
     *
     * @return a string representation of the list
     */
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	String result;
    	LinearNode<T> current = head;
    	
    	while(current != null) {
    		sb.append(current.getElement() + "\n");
    		current = current.getNext();
    	}    
    	result = sb.toString();
    	return result;
    }
    


}