package org.meltwater.java.datastructures;



public class Queue<T> {

    T[] array;
    T[] newArray;

    /**
     * pushes an element to the back of the queue
     *
     * @param element the element to be pushed to the end of the queue
     */
    @SuppressWarnings("unchecked")
	public void push(T element) {
        if (array == null) {
            array = (T[]) new Object[1];
            array[0] = element;
        } else {
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
    *
    * @return the first element in the queue
    */
   public T peek() {
       return array[0];
   }
   
   /**
    * Removes the first value from the queue
    */
   public void pop() {
       remove(0);
   }


    /**
     * Remove an element from a position in the queue
     *
     * @param position the position at which to remove the element in the queue
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
     * Checks if the element is present in the queue
     *
     * @param element the element to check for in the queue
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
     *Checks if the queue is empty or not
     * @return true if the queue is empty and false if otherwise
     */
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Clears all elements from the queue
     */
    @SuppressWarnings("unchecked")
	public void clear() {
        array = (T[]) new Object[0];
    }

    /**
     *
     * @return the size of the queue
     */
    public int size() {
        return array.length;
    }

    /**
     *
     * @return a String representation of the queue
     */
    public String toString() {
        String stringElements = "[";
        if(array == null){
            stringElements = " has no elements";
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
