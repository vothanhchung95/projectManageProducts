/*
Lớp Node để quản lý thông tin và hành vi của mỗi node trong danh sách 
*/
package chung.funix.csd201_as2_chungvtfx17970;


/**
 * Generic version of the Node class.
 * @param <T> the type of the value
 */
public class Node<T> {
    T info; // The info of this node
    Node next; // The next node
    
    /**
     * Default constructor
     */
    public Node() {
    }
    
    /**
     * Constructor with info
     * @param info The info of this node
     */
    public Node(T info) {
        this.info = info;
    }
    
    /**
     * Constructor with info and next node
     * @param info The info of this node
     * @param next The next Node of this node
     */
    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    /**
     * Overriding to convert this node to String
     */
    @Override
    public String toString() {
        return info.toString();
    }
    
    /**
     * Get info of this node
     */
    public T getInfo() {
        return info;
    }
    
    /**
     * set info of this node
     */
    public void setInfo(T info) {
        this.info = info;
    }
    
    /**
     * get next Node
     */
    public Node getNext() {
        return next;
    }
    
    /**
     * set next Node
     */
    public void setNext(Node next) {
        this.next = next;
    }
    

}
