package org.meltwater.java.datastructures;

public class SinglyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    Node<E> iterator;
    int numElements;

    /*
     * constructor for the class
     */
    public SinglyLinkedList() {
        head = tail = null;
        numElements = 0;
        iterator = null;
    }

    /**
     * Gets the size of the Linked List
     * 
     * @return returns the size of the Linked List
     */
    public int numElements() {

        return numElements;
    }

    /**
     * Gets the first node in the Linked List
     * 
     * @return returns the first node in the Linked list
     */
    public Node<E> head() {
        return head;
    }

    /**
     * Gets the last node in the Linked List
     * 
     * @return returns the last node in the Linked list
     */
    public Node<E> tail() {
        return tail;
    }

    /**
     * Checks whether the linked list is empty
     * @return Returns true if the list has no elements, false otherwise
     */
    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add an element at the head of the array
     * 
     * @param element the element to be added to the head of the array
     */
    public void addHead(E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.setNext(head);  
            head = node; 
        }
        numElements++;
    }

    /**
     * Add an element at the tail of the array
     * 
     * @param element the element to be added to the tail of the array
     */
    public void addTail(E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            tail = head = node;
        } else {
            tail.setNext(node);
            tail = node; 
        }
        numElements++;
    }

   
    /**
     * Get the node at a specified position
     * 
     * @param position the index of the element in the array
     * @return returns the element at the specified position
     */
    @SuppressWarnings("rawtypes")
	public Node getNode(int position) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Array is empty! Element does not exist");
        }
        Node<E> actual = head;
        for (int i = 0; i < position; i++) {
            actual = actual.getNext(); 
        }
        return actual;
    }

    /**
     * Insert an element at a specified position
     * 
     * @param i index in the array where to add the element
     * @param element the elements to be added at the specified position
     */
    public void addAtPos(int i, E element) {
        Node<E> node = new Node(element);
        if (isEmpty()) {
            tail = head = node;
        } else {
            Node<E> atual = getNode(i);
            if (atual == head) {
                Node<E> tmp = head;
                head = node;
                head.setNext(tmp);
            } else {
                Node<E> anterior = getNode(i - 1);
                Node<E> proxima = anterior.getNext();
                anterior.setNext(node);
                node.setNext(proxima);
            }
        }
        numElements++;
    }

    /**
     * Remove an element at a specified position in the array
     * 
     * @param position the index location of the element in the array
     * @return returns the removed element
     * @throws UnderFlowException
     */
    @SuppressWarnings("unchecked")
	public E removeAnyPos(int position) throws UnderFlowException {

        Node<E> aux = getNode(position);
        if (isEmpty()) {
            throw new UnderFlowException();
        } else {
            if (aux == head) {
                head = head.getNext();
            } else {
                getNode(position - 1).setNext(getNode(position).getNext());
            }
        }
        numElements--;
        return aux.getElement();
    }

    /**
     * Returns true if the array contains the specified element
     * 
     * @param element the element being searched for in the array
     * @return true if element is present and false otherwise
     */
    public boolean contains(E element) {
        Node<E> atual = head;
        while (atual != null) {
            if (atual.getElement().equals(element)) {
                return true;
            }
            atual = atual.getNext();
        }
        return false;
    }

    /**
     * Insert elem2 after elem1
     * 
     * @param elem1 element one that comes before element 2
     * @param elem2 element 2 that comes after element 1
     * @return false of the array does not exist
     */
    @SuppressWarnings("unchecked")
	public boolean insertAfter(E elem1, Node<E> elem2) {
        Node<E> var = head;
        for (int i = 0; i < numElements; i++) {
            if (var.getElement().equals(elem1)) {
                elem2.setNext(getNode(i + 1).getNext());
                getNode(i).setNext(elem2);
                numElements++;
                return true;
            }
            var = var.getNext();

        }
        return false;
    }
    
    /**
     * Iterator
     * 
     * @return iterator
     */
    public Node<E> next() {
        if (iterator == null) {
            iterator = head;
        } else if (iterator.getNext() == null) {
            iterator = head;
        } else {
            iterator = iterator.getNext();
        }
        return iterator;
    }
    
    /**
     * Reverse Elements in the array
     * 
     */
    public void reverse(){
		Node<E> before = head;
		Node<E> tmp = head.getNext();
		while (tmp != null) {
		    Node<E> next = tmp.getNext();
		    tmp.setNext(before);
		    before = tmp;
		    tmp = next;
		}
		head.setNext(before);
	}
  
    /**
     *  Reverses the array
     * 
     */
    public String toString() {
        String auxiliary;
        Node<E> current = null;
        auxiliary = "[";
        int n = numElements();
        if (n > 0) {
            current = head;
            auxiliary += current.getElement();
        }
        if (n > 1) {
            for (int i = 1; i <= n - 1; i++) {
                current = current.getNext();
                auxiliary += ", " + current.getElement();
            }
        }
        auxiliary += "]";
        return auxiliary;
    }

   
}