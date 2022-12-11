/*
Lớp Product chứa thông tin và hành vi cần thiết cho sản phẩm
*/
package chung.funix.csd201_as2_chungvtfx17970;

import java.io.Serializable;
import java.util.Scanner;


public class Product implements Serializable{
    
    public transient Scanner sc = new Scanner(System.in);
    
    private String bcode;
    private String title;
    private int quantity;
    private double price;
    
    /**
     * Default constructor
     */
    public Product() {

    }
    
    /**
     * Constructor method to initialize a product
     * @param bcode
     * @param title
     * @param quantity
     * @param price 
     */
    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    
    /**
     * method to setBcode for Product
     */
    public void setBcode() {
       
        PrintConsole.outputInline("Input new ID: ");
        this.bcode = sc.nextLine();
    }

    /**
     * method to setTitle for Product
     */
    public void setTitle() {
        PrintConsole.outputInline("Input Product's Name: ");
        this.title = sc.nextLine();
    }

    /**
     * method to setQuantity for Product
     */
    public void setQuantity() {
        PrintConsole.outputInline("Input Product's quantity: ");
        this.quantity = sc.nextInt();
    }

    /**
     * method to setPrice for Product
     */
    public void setPrice() {
        PrintConsole.outputInline("Input Product's price: ");
        this.price = sc.nextDouble();
    }

    /**
     * method to getBcode for Product
     */
    public String getBcode() {
        return bcode;
    }


    /**
     * method to getTitle for Product
     */    
    public String getTitle() {
        return title;
    }

    /**
     * method to getQuantity for Product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * method to getPrice for Product
     */    
    public double getPrice() {
        return price;
    }

    
    /**
     * Overriding to convert this node to String
     */
    @Override
    public String toString() {
        return bcode + "  |  " + title + "  |  " + quantity + "  |  " + price;
    }    
}
