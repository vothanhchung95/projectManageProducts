/*
Lớp MyList chứa thông tin và hành vi cơ bản của một danh sách móc nối 
*/
package chung.funix.csd201_as2_chungvtfx17970;



public class MyList <T> {

    Node<T> head; // Head node, default is null
    Node<T> tail; // Tail node, default is null
    
    /**
     * Default constructor
     */
    public MyList() {
    }
    
    /**
     * Constructor with head and tail
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
    
    /**
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    /**
     * Returning the length of this list
     * @return The length of this list
     */
    public int length() {
        int length = 0;
        Node current = this.head;
        
        while (current != null) {
            length ++;
            current = current.getNext();
        }
        return length;
    }
    
    /**
     * Insert an item to the head of this list
     * @param item The item to be inserted
     */
    public void insertToHead (T item) {
        Node newNode = new Node(item);
        newNode.setNext(this.head);
        this.head = newNode;
    }
    
    /**
     * Insert an item to the tail of this list
     * @param item The item to be inserted
     */
    public void insertToTail (T item) {
        Node newNode = new Node(item);
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.setNext(newNode);
        this.tail = newNode;
    }
    
    
    /**
     * Insert an item at position to this list
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        
    }
    
    /**
     * Deleting the tail of this list
     */
    public void deleteTail() {
        if (this.head == null) {
            this.head = null;
        }
        if (this.head.getNext() == null) {
            this.head = null;
        }
        
        Node current = this.head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.next = null;
    }
    
    /**
     * Searching and deleting an item from this list by comparing the ID of items
     * @param item The item to be deleted
     */
    public void deleteElement(Product item) {

    }
    
    /**
     * Swapping two nodes [firstNode] and [secondNode]
     * @param firstNode
     * @param secondNode 
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T info = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = info;
    }
    
    /**
     * Deleting all items in the list
     */
    public void clear() {
        this.head = null;
    }
    
    
    /**
     * 
     * @return String description of class
     */
    @Override
    public String toString() {
        String result = "";
        Node current = this.head;        
        while(current != null) {            
            result += current.toString() + "\n";
            current = current.getNext();            
        }
        return result;
    }
    
    
}
