package org.meltwater.java.datastructures;


public class Set<T> {

    BetterArray<T> betterArray;

    public Set() {
        betterArray = new BetterArray<>();
    }

    /**
     * Adds a T element to the Set
     *
     * @param element T element to be added
     */
    public void add(T element) {
        if (!contains(element)) {
            betterArray.append(element);
        }
    }
    

    /**
     * Adds a T element at a certain position
     *
     * @param position the position at which the element should be added into the set
     * @param element  the element of type T to be added at the position
     * @throws ArrayIndexOutOfBoundsException Throws an ArrayIndexOutOfBoundsException when the index passed is greater than size of the LinkedList
     */
    public void add(int position, T element) throws ArrayIndexOutOfBoundsException {
        betterArray.insert(position, element);
    }

    /**
     * Clears all elements from the Set
     */
    public void clear() {
        betterArray.clear();
    }

    /**
     * Checks if the element of type T is in the Set
     *
     * @param element the element to find in the Set
     * @return returns true if the element was found and false if otherwise
     */
    public boolean contains(T element) {
        return betterArray.contains(element);
    }

    /**
     * @return Returns true if the LinkedList is empty and false is otherwise
     */
    public boolean isEmpty() {
        return betterArray.isEmpty();
    }

    /**
     * @return Returns a String of LinkNodes in the Set
     */
    public String toString() {
        String theElements = "[";
        for (int i = 0; i < size(); i++) {
            if (i != size() - 1) {
                theElements += betterArray.get(i) + ", ";
            } else {
                theElements += betterArray.get(i);
            }
        }
        theElements += "]";
        return theElements;
    }

	private int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
