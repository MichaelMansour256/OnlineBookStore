package project.oop.CS;
public abstract class  Person {
    private static String userName,EMail,Password;
    public Person(String userName, String EMail, String Password) {
        this.userName = userName;
        this.EMail = EMail;
        this.Password = Password;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getEMail() {
        return EMail;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setUserName(String userName) {
        Person.userName = userName;
    }

    public static void setEMail(String EMail) {
        Person.EMail = EMail;
    }

    public static void setPassword(String Password) {
        Person.Password = Password;
    }
    abstract void Insert(String userName, String EMail, String Password);
}
