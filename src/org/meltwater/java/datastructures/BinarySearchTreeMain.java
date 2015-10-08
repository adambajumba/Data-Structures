package org.meltwater.java.datastructures;

public class BinarySearchTreeMain {

 	public static void main(String[] args) {
 		BinarySearchTree<String> t = new BinarySearchTree<String>();
 		t.add("childOne");
 		t.printTree();
 		System.out.println("Printing if 'childOne' isPresent in tree: " + t.isPresent("childOne")); 
 		t.add("myDaughter");
 		t.add("mySon");
 		t.add("myGrandDaughter");
 		t.add("myGrandSon");
 		t.printTree();
 		System.out.println("Printing if 'myDaughter' isPresent in tree: " + t.isPresent("myDaughter")); 
 		System.out.println("Printing if 'mySon' isPresent in tree: " + t.isPresent("mySon")); 
 		System.out.println("Printing if 'Happy' isPresent in tree: " + t.isPresent("Happy")); 
        t.remove("myGrandSon");
 		System.out.println("removed myGrandSon");
 		t.printTree();
 	}
}
