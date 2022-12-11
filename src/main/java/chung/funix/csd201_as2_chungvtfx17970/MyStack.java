/*
Lớp MyStack chứa thông tin và các hành vi cơ bản của stack 
*/
package chung.funix.csd201_as2_chungvtfx17970;


public class MyStack<T> {
    Node<T> head; // Head node contains front node in the stack
    
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
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (this.head == null);
    }
    
    /**
     * Deleting all items in the list
     */
    public void clear() {
        this.head = null;
    }
    
    /**
     * Overriding to convert this node to String
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

