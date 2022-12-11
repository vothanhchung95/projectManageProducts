/*
Lớp OperationToProduct sẽ chứa các phương thức thức biểu diễn các yêu cầu chức năng của bài toán 
*/
package chung.funix.csd201_as2_chungvtfx17970;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.lang.StringBuilder;



public class OperationToProduct implements Serializable{
    Scanner sc = new Scanner(System.in);
    
    /**
     * Searching and returning the index of product p in the list. If not found return -1.
     * @param p Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */
    public int index(Product p, MyList<Product> list) {
        Node current = list.head;
        int index = 0;
        while(current != null) {            
            if (current.info.equals(p)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }
    
    /**
     * Creating and returning a product with info input from keyboard.
     * @return The product
     */
    public Product createProduct() {
        Product newProduct = new Product();
        newProduct.setBcode();
        newProduct.setTitle();
        newProduct.setQuantity();
        newProduct.setPrice();
        return newProduct;
    }
    
    /**
     * Reading all products from the file and insert them to the list at tail.
     * @param filename The file name of the file
     * @param list The Linked List contains all products that read from file
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public void getAllItemsFromFile(String filename, MyList<Product> list) throws IOException, ClassNotFoundException{
        try (InputStream is = new FileInputStream(filename); 
            ObjectInputStream objectInputStream = new ObjectInputStream(is)) {
            list.clear();
            while(is.available() > 0) {
                list.insertToTail((Product) objectInputStream.readObject());
            }            
            objectInputStream.close();           
        } catch (ClassCastException e) {
            PrintConsole.output("Input your data");
        }
        displayAll(list);
    }
    
    /**
     * Reading all products from the file and insert them to the stack.
     * @param filename The file name of the file
     * @param stack The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String filename, MyStack<Product> stack)throws IOException, ClassNotFoundException {
        try (InputStream is = new FileInputStream(filename); 
            ObjectInputStream objectInputStream = new ObjectInputStream(is)) {
            stack.clear();
            while(is.available() > 0) {
                stack.insertToHead((Product) objectInputStream.readObject());
            }            
            objectInputStream.close();            
        } catch (ClassCastException e) {
            PrintConsole.output("Input your data");
        }
        displayAll(stack);
    }
    
    /**
     * Reading all products from the file and insert them to the queue.
     * @param filename The file name of the file
     * @param queue The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String filename, MyQueue<Product> queue)throws IOException, ClassNotFoundException {
        try (InputStream is = new FileInputStream(filename); 
            ObjectInputStream objectInputStream = new ObjectInputStream(is)) {
            queue.clear();
            while(is.available() > 0) {
                queue.enQueue((Product) objectInputStream.readObject());
            }            
            objectInputStream.close();
            
        } catch (ClassCastException e) {
            PrintConsole.output("Input your data");
        }        
        displayAll(queue); 
    }
    
    /**
     * Adding a product to the list, info of the product input from keyboard.
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list) {
        list.insertToTail(createProduct());        
    }
    
    /**
     * Printing all products of the list to console screen
     * @param list 
     */
    public void displayAll(MyList<Product> list) {
        PrintConsole.output("ID  |  Title  | Quantity |  Price");
        PrintConsole.output("-----------------------------------");
        PrintConsole.output(list.toString());        
    }
        
    /**
     * Printing all products of the stack to console screen
     * @param stack 
     */
    public void displayAll(MyStack<Product> stack) {
        PrintConsole.output("ID  |  Title  | Quantity |  Price");
        PrintConsole.output("-----------------------------------");
        PrintConsole.output(stack.toString());        
    }
    
    /**
     * Printing all products of the stack to console screen
     * @param queue 
     */
    public void displayAll(MyQueue<Product> queue) {
        PrintConsole.output("ID  |  Title  | Quantity |  Price");
        PrintConsole.output("-----------------------------------");
        PrintConsole.output(queue.toString());        
    }
    
    /**
     * Writing all products from the list to the file
     * @param filename Input file name
     * @param list Input Linked list
     */
    public void writeAllItemsToFile(String filename, MyList<Product> list) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        Node current = list.head;
        while(current != null) {            
            os.writeObject(current.getInfo());
            current = current.getNext();            
        }
        PrintConsole.output("Successfully!");
    }
    
    /**
     * Searching product by ID input from keyboard.
     * @param list 
     */
    public void searchByCode(MyList<Product> list) {
        PrintConsole.outputInline("Input ID to search: ");
        String id = sc.nextLine();
        Node<Product> current = list.head;
        while (current != null) {
            Product p = current.getInfo();

            if (p.getBcode().equals(id)) {
                PrintConsole.output(p.toString());
            }
            current = current.getNext();
        }
    }
    
    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list 
     */
    public void deleteByCode(MyList<Product> list) {
        PrintConsole.outputInline("Input the bcode to delete: ");
        String id = sc.nextLine();
        Node<Product> current = list.head;
       
        while (current != null) {
            Product p = current.getInfo();
            if (p.getBcode().equals(id)) {                
                deleteAtPosition(list, index(p, list));
                break;
            }
            
            current = current.getNext();
        }
        PrintConsole.output("Deleted.");
    }
    
    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {
        if(list.head.next == null) {
            return;
        }
        Node<Product> current = list.head;

        while (current.next != null) {
            Node<Product> firstNode = current;
            Node<Product> secondNode = current.next;
            while (secondNode != null) {
                String bCodeFirst = firstNode.getInfo().getBcode();
                String bCodeSecond = secondNode.getInfo().getBcode();
                if (bCodeFirst.compareTo(bCodeSecond) > 0) {                
                    list.swap(firstNode, secondNode);
                }
                secondNode = secondNode.next;
            }            
            current = current.getNext();
        }
        
    }
    

    /**
     * Sorting products in linked list by ID using recursion
     * @param list The Linked list
     * @param i the start index for sorting 
     * @param n length of list
     */
    public void selectionSortRes(MyList<Product> list, int i, int n){        
        Node<Product> current = list.head;
        for (int j = i; j < n - 1; j++) {            
            Node<Product> next = current.getNext();
            if (current.getInfo().getBcode().compareTo(next.getInfo().getBcode()) > 0) {
                
                list.swap(current, next);
            }
            current = current.getNext();
        }        
        if (i < n - 1) {
            selectionSortRes(list, i + 1, n);
        }
    }
    
    /**
     * Adding new product to head of Linked List. The info input from keyboard.
     * @param list The linked list
     */
    public void addFirst(MyList<Product> list) {
        
    }
    
    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     * @param i Input decimal number
     * @return a integer numbers
     */
    public int convertToBinary (int i) {
        PrintConsole.outputInline("Quantity = " + i + " => "); 
        String bi = "";
        while(i > 0){
            int rem = i % 2;
            bi += Character.toString(rem + 48);
            i /= 2;
        }
       
        String strB = new StringBuilder(bi).reverse().toString();
        PrintConsole.output(strB);
        return Integer.parseInt(strB);
    }
    
    /**
     * Deleting the product at position
     * @param list The Linked List
     * @param pos The position of product to be deleted
     */
    public void deleteAtPosition(MyList<Product> list, int pos) {
        Node current = list.head;
        if(pos == 0) {
            list.head = list.head.getNext();
        }
        for(int i = 0; i < pos - 1; i++) {
            if(current.getNext() == null) {
                current.setNext(null);
            }
            current = current.getNext();
        }
        current.setNext(current.next.next);
    }
}
