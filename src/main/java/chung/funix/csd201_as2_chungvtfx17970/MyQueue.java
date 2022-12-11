/*
Lớp MyQueue chứ thông tin và các hành vi cơ bản của queue  
*/
package chung.funix.csd201_as2_chungvtfx17970;


public class MyQueue<T> {
    Node<T> head; // Head node contains front node in the queue
    Node<T> tail; // Tail node contains last node in the queue
    
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    /**
     * enQueue an item
     * @param item will be add to queue
     */
    public void enQueue (T item) {
        Node newNode = new Node(item);
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = tail.next;
    }
    
    public void clear() {
        this.head = null;
    }
    
    /**
     * Overriding to convert this node to String
     * @return String
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
