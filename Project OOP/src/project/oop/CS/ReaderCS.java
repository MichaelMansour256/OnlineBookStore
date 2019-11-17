package project.oop.CS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.table.DefaultTableModel;

public class ReaderCS extends Person {
    DefaultTableModel Book;
    BufferedReader r;
    static String Phone,Adress,Card_Number; 

    public String getPhone() {
        return Phone;
    }

    public String getAdress() {
        return Adress;
    }

    public String getCard_Number() {
        return Card_Number;
    }
    public String getCard_userName() {
        return super.getUserName();
    }
    public String getCard_EMail() {
        return super.getEMail();
    }
    public String getCard_Password() {
        return super.getPassword();
    }
    public ReaderCS(String userName, String EMail, String Password,String Phone,String Adress,String Card_Number) {
        super(userName, EMail, Password);
        this.Phone=Phone;
        this.Adress=Adress;
        this.Card_Number=Card_Number;
    }
    @Override
     void Insert(String userName, String EMail, String Password){
        Person.setUserName(userName);
        Person.setEMail(EMail);
        Person.setPassword(Password);
    }
    public static void Insert_Data(String userName, String EMail, String Password,String Phone,String Adress,String Card_Number){
        Person.setUserName(userName);
        Person.setEMail(EMail);
        Person.setPassword(Password);
        ReaderCS.Phone=Phone;
        ReaderCS.Adress=Adress;
        ReaderCS.Card_Number=Card_Number;
                try {
          BufferedWriter w=new BufferedWriter(new FileWriter("src/project/oop/user.txt",true));
          w.write(Person.getUserName()+"*"+Person.getPassword()+"*"+"U*"+Person.getEMail()+"*"+Phone+"*"+Card_Number+"*"+Adress);
          w.newLine();
          w.close();
      } catch (Exception e) {
      }
    }
    public DefaultTableModel ReadAll(){
        Book=new DefaultTableModel();
        Book.addColumn("UserName");
        Book.addColumn("Password");
        Book.addColumn("Type");
        Book.addColumn("Email");
        Book.addColumn("Phone");
        Book.addColumn("Payment Number");
        Book.addColumn("Addres");
        
        try {
            r=new BufferedReader(new FileReader("src/project/oop/user.txt"));
            String[] userData=r.readLine().split("\\*");
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
          BufferedWriter w=new BufferedWriter(new FileWriter("src/project/oop/user.txt"));
          w.write("1*1*A*@gmail*01210666209*Card123*12St Wkkk");
          w.newLine();
          for (int i = 0; i < d.getRowCount(); i++) {
              String x=d.getValueAt(i, 0).toString()+"*"+d.getValueAt(i, 1).toString()+"*"+d.getValueAt(i, 2).toString()+"*"+d.getValueAt(i, 3).toString()+"*"+d.getValueAt(i, 4).toString()+"*"+d.getValueAt(i, 5).toString()+"*"+d.getValueAt(i, 6).toString();
              w.write(x);
              w.newLine();
          }
          w.close();
      } catch (Exception e) {
      }
  }
    public static void UpdateInfo(String newline){
        String lineToRemove=AdminCS.m.getCard_userName()+"*"+AdminCS.m.getCard_Password()+"*U*"+AdminCS.m.getCard_EMail()+"*"+AdminCS.m.getPhone()+"*"+AdminCS.m.getCard_Number()+"*"+AdminCS.m.getAdress();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/project/oop/user.txt"));
            String Lines="";
            String currentLine=reader.readLine();
            while(currentLine !=null) {
                Lines+= currentLine+"/";
                currentLine=reader.readLine();
            }
            reader.close(); 
            String[] Users=Lines.split("\\/");
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/project/oop/user.txt"));
            for (int i = 0; i < Users.length; i++) {
                if(Users[i].equals(lineToRemove)){
                    writer.write(newline);
                    writer.newLine();
                }
                else{
                    writer.write(Users[i]);
                    writer.newLine();
                }
            }
            writer.close();
            String[] UpdatedData=newline.split("\\*");
            AdminCS.m=new ReaderCS(UpdatedData[0], UpdatedData[3], UpdatedData[1],UpdatedData[4],UpdatedData[6],UpdatedData[5]);
        } catch (Exception e) {
        }
    }
}
