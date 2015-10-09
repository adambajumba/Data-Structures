package org.meltwater.java.datastructures;


public class Stack<T> {

    T[] array;
    T[] newArray;

    /**
     * pushes an element to the bottom of the Stack
     *
     * @param element the element to be pushed into the Stack
     * takes O(n)
     */
    public void push(T element) {
        if (array == null) {
            array = (T[]) new Object[1];
            array[0] = element;
        }
        else {
            newArray = (T[]) new Object[array.length + 1];
            for (int i = 0; i < size(); i++) {
                newArray[i] = array[i];
            }
            newArray[size()] = element;
            array = newArray;
            newArray = null;
        }
    }
    
    /**
     * Removes the top element from the Stack
     */
    public void pop() {
        remove(size() - 1);
    }
    
    /**
    *Returns the top element in a stack but does not remove it.
    *
    * @return the first value of the Stack
    */
   public T peek() {
       return array[size() - 1];
   }

    /**
     * Remove element from a position
     *
     * @param position the position at which to remove the element
     */
    @SuppressWarnings("unchecked")
	public void remove(int position) {
        newArray = (T[]) new Object[size() - 1];
        boolean positionReached = false;
        for (int i = 0; i < newArray.length; i++) {
            if (i == position && !positionReached) {
                newArray[i] = array[i + 1];
                positionReached = true;
            }else{
                if(positionReached){
                    newArray[i] = array[i + 1];
                }else{
                    newArray[i] = array[i];
                }
            }
        }
        array = newArray;
        newArray = null;
    }

    /**
     * Checks if the element is present in the Stack
     *
     * @param element the element to check for in the Stack
     * @return true if the element is found and false if otherwise
     */
    public boolean contains(T element) {
        boolean elementFound = false;
        for(int i = 0; i < size(); i++){
            if(array[i] == element){
                elementFound = true;
                break;
            }
        }
        return elementFound;
    }

    /**
     * Check if the stack is empty
     *
     * @return true if the Stack is empty and false if otherwise
     */
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Clears all elements from the Stack
     */
    @SuppressWarnings("unchecked")
	public void clear() {
        array = (T[]) new Object[0];
    }

    /**
     *Return the size of the stack
     *
     * @return returns the size of the Stack
     */
    public int size() {
        return array.length;
    }

    /**
     *
     * @return a String representation of the Stack
     */
    public String toString() {
        String stringElements = "[";
        if(array == null){
            stringElements = "Stack has no elements";
        }else{
            for (int i = 0; i < size(); i++) {
                if (i != size() - 1) {
                    stringElements += array[i] + ", ";
                } else {
                    stringElements += array[i];
                }
            }
            stringElements += "]";
        }

        return stringElements;
    }

}