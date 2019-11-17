package project.oop.CS;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class AdminCS extends Person {
    public static ReaderCS m;
    public AdminCS(String userName, String EMail, String Password) {
        super(userName, EMail, Password);
    }
    void Insert(String userName, String EMail, String Password){
        super.setUserName(userName);
        super.setEMail(EMail);
        super.setPassword(Password);
    } 
    public String Login(String UserName,String Password){
        try{
        BufferedReader r=new BufferedReader(new FileReader("src/project/oop/user.txt"));
            String[] userData=r.readLine().split("\\*");
            while(userData.length!=0){
             if(userData[0].equals(UserName)&&userData[1].equals(Password)){
                JOptionPane.showMessageDialog(null, "Welcome","Inform",JOptionPane.INFORMATION_MESSAGE);
                if(userData[2].equals("A")){
                    Insert(UserName, userData[3], Password);
                }
                else
                    m=new ReaderCS(UserName, userData[3], Password,userData[4],userData[6],userData[5]);
                return userData[2];
             }
             userData=r.readLine().split("\\*");
            }
            return "Null";
        }
    catch(Exception e){
    return "d";
    }
   }
}
