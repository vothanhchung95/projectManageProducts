package chung.funix.csd201_as2_chungvtfx17970;

import java.io.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;



public class AS2_Main implements Serializable{
    public static String filename = "data.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException, InputMismatchException {

        Scanner sc = new Scanner(System.in);
        MyList<Product> list = new MyList<>();
        MyStack<Product> stack = new MyStack<>();
        MyQueue<Product> queue = new MyQueue<>();
        OperationToProduct op = new OperationToProduct();        
        while (true) {            
            PrintConsole.output("Choose one of this options:");
            PrintConsole.output("Product list:");
            PrintConsole.output("1. Load data from file and display");
            PrintConsole.output("2. Input & add to the end.");        
            PrintConsole.output("3. Display data");
            PrintConsole.output("4. Save product list to file.");
            PrintConsole.output("5. Search by ID");
            PrintConsole.output("6. Delete by ID");
            PrintConsole.output("7. Sort by ID.");
            PrintConsole.output("8. Convert to Binary");
            PrintConsole.output("9. Load to stack and display");
            PrintConsole.output("10. Load to queue and display.");
            PrintConsole.output("0. Exit");
            PrintConsole.output("");
            PrintConsole.outputInline("Choice: ");
            String choice = sc.nextLine();
            PrintConsole.output("");

            if ("0".equals(choice)) {
                PrintConsole.output("Thanks!!!");
                break;
            }
            switch (choice) {
                case "1":
                    op.getAllItemsFromFile(filename, list);
                    PrintConsole.output("");
                    break;
                case "2":
                    op.addLast(list);
                    PrintConsole.output("");
                    break;
                case "3":
                    op.displayAll(list);
                    PrintConsole.output("");
                    break;
                case "4":
                    op.writeAllItemsToFile(filename, list);
                    PrintConsole.output("");
                    break;
                case "5":
                    op.searchByCode(list);
                    PrintConsole.output("");
                    break;
                case "6":
                    op.deleteByCode(list);
                    PrintConsole.output("");
                    break;
                case "7":
                    op.selectionSortRes(list, 0, list.length());
                    PrintConsole.output("");
                    break;
                case "8":
                    op.convertToBinary(list.head.getInfo().getQuantity());
                    PrintConsole.output("");
                    break;
                case "9":
                    op.getAllItemsFromFile(filename, stack);
                    PrintConsole.output("");
                    break;
                case "10":
                    op.getAllItemsFromFile(filename, queue);
                    PrintConsole.output("");
                    break;
                default:
                    PrintConsole.output("**Invalid choice. Try again.**");
                    PrintConsole.output("");
            }            
        }        
    }
}
