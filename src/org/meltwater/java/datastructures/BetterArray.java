package org.meltwater.java.datastructures;

public class BetterArray<E> {
	
	 private E[] array;
	 private E[] newArray;


	@SuppressWarnings("unchecked")
	public BetterArray() {
		 array = (E[]) new Object[0];
	     newArray = null;
	}
	
	 /**
     * Gets the size of the ArrayList
     *
     * @return Returns the size of the ArrayList
     */
    public int size() {
        return array.length;
    }
	
	/**
     * Adds an element to the end of the ArrayList.
     *
     * @param element the element to be added to the end of the ArrayList
     */
    @SuppressWarnings("unchecked")
	public void append(E element) {
        if (!isEmpty()) {
            newArray = (E[]) new Object[array.length + 1];
            for (int i = 0; i < size(); i++) {
                newArray[i] = array[i];
            }
            newArray[newArray.length - 1] = element;
            array = newArray;
            newArray = null;
        } else {
            array = (E[]) new Object[1];
            array[0] = element;
        }
    }
    
    /**
     * Adds multiple elements to the end of the ArrayList
     *
     * @param elements the elements in the order in which they are to be added to the end of the ArrayList
     */
    @SuppressWarnings("unchecked")
	public void append(E... elements) {
        for (int i = 0; i < elements.length; i++) {
            append(elements[i]);
        }
    }
    
    /**
     * Inserts an element at a certain position in the BetterArray
     * @param position the position in the BetterArray where the new element will be added
     * @param element the element to be added at the specified position in the BetterArray
     * @return Returns true if the element was successfully added and false if otherwise
     */
    public boolean insert(int position, E element) {
        boolean status = false;
        if (position == size()) {
            append(element);
            status = true;
        } else if (position > size()) {
            status = false;
        } else {
            addInMiddle(position, element);
        }
        return status;
    }
    
    @SuppressWarnings("unchecked")
	private void addInMiddle(int position, E element) {
        newArray = (E[]) new Object[array.length + 1];
        boolean positionReached = false;
        for (int i = 0; i < newArray.length; i++) {
            if ((i + 1) > position && positionReached == false) {
                newArray[i] = element;
                positionReached = true;
            } else {
                if (positionReached) {
                    newArray[i] = array[i - 1];
                } else {
                    newArray[i] = array[i];
                }
            }
        }
        array = newArray;
    }
    
    /**
     * Shifts the specified element to the beginning of the ArrayList
     *
     * @param element the element to be shifted to the beginning of the ArrayList
     */
    public void shift(E element) {
        insert(0, element);
    }

    /**
     * Gets the index of the first appearance of the element
     *
     * @param element the element whose index is to be returned
     * @return Returns the index of the element and -1 if the element is not found
     */
    public int index(E element) {
        int elementPresent = -1;
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(element)) {
                elementPresent = i;
                break;
            }
        }

        return elementPresent;
    }

    /**
     * Checks whether an element is present in the ArrayList
     *
     * @param element the element to check for in the ArrayList
     * @return Returns <b>true</b> if the element is found and <b>false</b> if otherwise
     */
    public boolean contains(E element) {
        if (index(element) != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets the element at the index provided
     *
     * @param index the position to get the element
     * @return Returns the element at position index
     * @throws ArrayIndexOutOfBoundsException Throws an ArrayIndexOutOfBoundsException when the index passed is greater than size of the ArrayList
     */
    public E get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }

    /**
     * Removes the element at the specified index
     *
     * @param index the position at which to remove the element
     * @throws ArrayIndexOutOfBoundsException Throws an ArrayIndexOutOfBoundsException when the index passed is greater than size of the ArrayList
     */
    @SuppressWarnings("unchecked")
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
        newArray = (E[]) new Object[size() - 1];
        boolean indexReached = false;
        for (int i = 0; i < newArray.length; i++) {
            if (i >= index && !indexReached) {
                newArray[i] = array[i + 1];
                indexReached = true;
            } else {
                if (indexReached) {
                    newArray[i] = array[i + 1];
                } else {
                    newArray[i] = array[i];
                }
            }
        }
        array = newArray;
        newArray = null;
    }

    /**
     * Removes an element from the ArrayList
     *
     * @param element the element to be removed from the ArrayList
     * @throws ArrayIndexOutOfBoundsException Throws an ArrayIndexOutOfBoundsException when the index passed is greater than size of the ArrayList
     */
    @SuppressWarnings("unchecked")
	public void removeElement(E element) throws ArrayIndexOutOfBoundsException {
        newArray = (E[]) new Object[size() - 1];
        boolean indexReached = false;
        for (int i = 0; i < newArray.length; i++) {
            if (array[i].equals(element) && !indexReached) {
                newArray[i] = array[i + 1];
                indexReached = true;
            } else {
                if (indexReached) {
                    newArray[i] = array[i + 1];
                } else {
                    newArray[i] = array[i];
                }
            }
        }
        array = newArray;
        newArray = null;
    }
    
    /**
     * Checks whether or not the ArrayList is empty
     *
     * @return Returns true if ArrayList is empty and false if otherwise
     */
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Remove all occurrences of the elements in the ArrayList
     */
    @SuppressWarnings("unchecked")
	public void clear(){
        array = (E[]) new Object[0];
    }
    

    /**
     * Creates a String representation of elements in the ArrayList
     *
     * @return Returns a string representation of elements in the ArrayList
     */
    public String toString() {
        String elementString = "[";
        for (int i = 0; i < size(); i++) {
            if (i != size() - 1) {
                elementString += array[i] + ", ";
            } else {
                elementString += array[i];
            }
        }
        elementString += "]";

        return elementString;
    }
    
    /**
     * Reverses the elements in the BetterArray
     */
    public void reverse(){
		if(size() <= 1) return;
		int start = 0;
		int end = size()-1;
		
		while (start < end) {
			E temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			
			start++; end--;
		}
    }

}

