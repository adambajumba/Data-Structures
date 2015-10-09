package org.meltwater.java.datastructures;
/**
 * 
 * @author Izzoe
 *
 * @param <T>
 */

public class BinarySearchTree<T> {

    private BetterArray<BinarySearchTree<T>> children = new BetterArray<>();
    private BinarySearchTree<T> parent = null;
    private T element = null;

    public BinarySearchTree(T element) {
        this.element = element;
    }

    public BinarySearchTree(T element, BinarySearchTree<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public BetterArray<BinarySearchTree<T>> getChildren() {
        return children;
    }

    public void setParent(BinarySearchTree<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        BinarySearchTree<T> child = new BinarySearchTree<T>(data);
        child.setParent(this);
        this.children.append(child);
    }

    public void addChild(BinarySearchTree<T> child) {
        child.setParent(this);
        this.children.append(child);
    }

    /**
     * 
     * @return returns the base
     */
    public T getElement() {
        return this.element;
    }

    /**
     * 
     * @param element element to be changed
     */
    public void setElement(T element) {
        this.element = element;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if (this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }
} 