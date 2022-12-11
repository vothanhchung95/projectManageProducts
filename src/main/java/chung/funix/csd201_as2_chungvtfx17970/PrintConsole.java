/*
Lớp PrintConsole giúp lưu lại dữ liệu trên console vào file console_output.txt
 */
package chung.funix.csd201_as2_chungvtfx17970;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter pw is variable to print console to text file
 * @author Vo Thanh Chung
 */
public class PrintConsole {
    public static File file = new File("console_output.txt");
    public static FileWriter fw ;
    public static PrintWriter pw; 
    static {
        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * constructor of PrintConsole
     * @throws IOException when create new File Writer
     */
    public PrintConsole() throws IOException {
        this.fw = new FileWriter(file);
    }
    
    /**
     * Print to console and save it to file at the same time
     * @param msg the String will be print
     */
    public static void output(String msg) {
        pw.println(msg);
        System.out.println(msg);
        pw.flush();
    }

    /**
     * Print to console and save it to file at the same time
     * @param msg the String will be print
     */
    public static void outputInline(String msg) {
        pw.print(msg);
        System.out.print(msg);
        pw.flush();
    }
}
