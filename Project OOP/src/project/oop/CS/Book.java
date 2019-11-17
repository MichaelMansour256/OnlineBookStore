package project.oop.CS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.table.DefaultTableModel;

public class Book {
    String name,author,cat;
    int price,quentty;
    DefaultTableModel Book;
    BufferedReader r;
    BufferedWriter w;
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCat() {
        return cat;
    }

    public int getPrice() {
        return price;
    }

    public int getQuentty() {
        return quentty;
    }
    public Book() {
    }
    public DefaultTableModel ReadAll(){
        Book=new DefaultTableModel();
        Book.addColumn("Name");
        Book.addColumn("Author");
        Book.addColumn("Cat");
        Book.addColumn("Price");
        Book.addColumn("Quentty");
        try {
            r=new BufferedReader(new FileReader("src/project/oop/books.txt"));
            String[] userData=r.readLine().split("\\*");
            Book.addRow(userData);
            while(userData.length!=0){
                userData=r.readLine().split("\\*");
                Book.addRow(userData);
            }
        } catch (Exception e) {
        }
        return Book;
    }
    public static void InserData(DefaultTableModel d){
        try {
            BufferedWriter w=new BufferedWriter(new FileWriter("src/project/oop/books.txt"));
            for (int i = 0; i < d.getRowCount(); i++) {
                String x=d.getValueAt(i, 0).toString()+"*"+d.getValueAt(i, 1).toString()+"*"+d.getValueAt(i, 2).toString()+"*"+d.getValueAt(i, 3).toString()+"*"+d.getValueAt(i, 4).toString();
                w.write(x);
                w.newLine();
            }
            w.close();
        } catch (Exception e) {
        }
    }
    public static void Insert_Data(String Name, String Author, String Cat,int Price,int Quentty){
       try {
            BufferedWriter w=new BufferedWriter(new FileWriter("src/project/oop/books.txt",true));
            w.write(Name+"*"+Author+"*"+Cat+"*"+Price+"*"+Quentty);
            w.newLine();
            w.close();
     } catch (Exception e) {
     }
    }
    public DefaultTableModel Search(String Word){
        Book=new DefaultTableModel();
        Book.addColumn("Name");
        Book.addColumn("Author");
        Book.addColumn("Cat");
        Book.addColumn("Price");
        Book.addColumn("Quentty");
        try {
            r=new BufferedReader(new FileReader("src/project/oop/books.txt"));
            String[] userData=r.readLine().split("\\*");
            while(userData.length!=0){
                if(userData[0].toLowerCase().contains(Word.toLowerCase())){
                    Book.addRow(new Object[]{userData[0],userData[1],userData[2],userData[3],userData[4]});
                }
                    userData=r.readLine().split("\\*");
            }
        } catch (Exception e) {
        }
        return Book;
    }
}
