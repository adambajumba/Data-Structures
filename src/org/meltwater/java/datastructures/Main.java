package org.meltwater.java.datastructures;
/**
 * 
 * @author Izzoe
 *Main Class implementation for various data structures
 */

public class Main {

public static void main(String[] args) {
		
	    /**
	     * Program to test the Improved Array
	     */
	    
		System.out.println("            This is an improved Array");
		System.out.println("****************************************************");
		
        BetterArray<Integer> advancedArray = new BetterArray<>();
        advancedArray.append(15);
        advancedArray.append(27);
        advancedArray.append(39);
        advancedArray.append(51);

        advancedArray.append(1, 2, 3, 4, 5, 6);

        advancedArray.append(10, 11, 12, 13);

        advancedArray.shift(100);

        advancedArray.insert(9, 150);

        System.out.println("The Values in the array :=> " + advancedArray.toString());

        System.out.println("\nThe index of 150 :=> " + advancedArray.index(150));

        advancedArray.remove(9);

        System.out.println("\nRemove value at index 4 :=> " + advancedArray.toString());

        advancedArray.removeElement(100);

        System.out.println("\nRemove element 10 :=> " + advancedArray.toString());
        
        System.out.println("Is the Array Empty? " + advancedArray.isEmpty()); 
        
        System.out.println("Does the Array contain 5? " + advancedArray.contains(5)); 
        
        advancedArray.reverse();
        
        System.out.println("The Reversed Array is: " + advancedArray.toString()); 
        
        System.out.println("The size of the array is: " + advancedArray.size()); 
        
        
        /**
         * Program to test Singly Linked List
         */
        System.out.println("            This is for a Singly Linked List");
		System.out.println("****************************************************");
		
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        
        linkedList.addHead(5);
        
        linkedList.addHead(10);
        
        linkedList.addHead(15);
        
        linkedList.addTail(20);
        
        linkedList.addTail(25);
        
        System.out.println("The new Array is: " +linkedList.toString());
        
        System.out.println("The number of elements is: " +linkedList.numElements());
        
        linkedList.reverse();
        
        System.out.println("The reverse of elements is: " +linkedList.toString());

        
        /*
        *Test Program for Stack Implementation
         */
        System.out.println("            This is for a Stack");
		System.out.println("****************************************************");

		Stack<Integer> stackImplement = new Stack<>();

        stackImplement.push(10);
        stackImplement.push(20);
        stackImplement.push(30);
        stackImplement.push(40);
        stackImplement.push(50);
      

        System.out.println("\nThe elements in the stack are: " + stackImplement.toString());
        System.out.println("\nIs the Stack empty? : " + stackImplement.isEmpty());

        stackImplement.pop();
        System.out.println("\nPopped from Stack : " + stackImplement.toString());
        stackImplement.pop();
        System.out.println("\nPopped from Stack : " + stackImplement.toString());

        stackImplement.remove(30);
        System.out.println("\nRemove element at position 3 :=> " + stackImplement.toString());

        System.out.println("\nDoeas the Stack contain 4?  " + stackImplement.contains(4));
     
        System.out.println("\nPeek from Stack :=> " + stackImplement.peek());
        System.out.println("\nCurrent Stack :=> " + stackImplement.toString());

        stackImplement.clear();
        System.out.println("\nClear the Stack :=> " + stackImplement.toString());
        System.out.println("\nIs Stack empty : " + stackImplement.isEmpty());
        
        
        /**
         * The Queue Class implementation
         */
      
        System.out.println("            This is for a Queue");
      	System.out.println("****************************************************");

        Queue<Integer> queues = new Queue<>();

        queues.push(10);
        queues.push(20);
        queues.push(30);
        queues.push(40);
        

        System.out.println("\nThe elements in the Queue are: " + queues.toString());
        System.out.println("\nIs Queue empty? " + queues.isEmpty());

        queues.pop();
        System.out.println("\nPop from Queue :=> " + queues.toString());

        queues.remove(2);
        System.out.println("\nRemove element at position 4 :=> " + queues.toString());

        System.out.println("\nQueue contains 4 :=> " + queues.contains(4));
        System.out.println("\nQueue contains 5 :=> " + queues.contains(5));
        
        queues.clear();
        System.out.println("\nClear Queue :=> " + queues.toString());
        System.out.println("\nIs Queue empty : " + queues.isEmpty());
        
        /**
         * The Set Programs implementation
         */
      
        System.out.println("            This is for a Set");
      	System.out.println("****************************************************");

        
        Set<Integer> setImp = new Set<>();
        System.out.println("\nIs set empty :=> " + setImp.isEmpty());

      
        System.out.println("\nAdd 11, 22, 32, 43");
        System.out.println("\nSet :=> " + setImp.toString());

        setImp.add(3);
        System.out.println("\nAdd 35 to the set :=> " + setImp.toString() + " (3 since it's already in the Set)");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


      
	}


}
