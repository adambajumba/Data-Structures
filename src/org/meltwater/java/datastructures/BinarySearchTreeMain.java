package org.meltwater.java.datastructures;

public class BinarySearchTreeMain {

 	public static void main(String[] args) {
 		BinarySearchTree<String> t = new BinarySearchTree<String>();
 		//t.add("hi");
 		t.printTree();
 		System.out.println("Printing if 'hi' isPresent in tree: " + t.isPresent("hi")); 
 		t.add("bello");
 		t.add("helloe");
 		t.add("z");
 		t.add("a");
 		t.printTree();
 		System.out.println("Printing if 'bello' isPresent in tree: " + t.isPresent("bello")); 
 		System.out.println("Printing if 'bellos' isPresent in tree: " + t.isPresent("bell")); 
 		System.out.println("Printing if 'z' isPresent in tree: " + t.isPresent("z")); 
        t.remove("bello");
 		System.out.println("removed z");
 		t.printTree();
 	}
}
