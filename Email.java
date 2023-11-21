package emailapp;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
public class Email {
    public Scanner scan = new Scanner(System.in); // scanner class
    // Setting variables as private
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailcapacity= 500 ;
    private  String alter_email ;
    // Constructor to receive first name , last name
    public Email(String fname,String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);
        // Calling Methods
        this.dept = this.setDept();
        this.password = this.genetrate_password(8); // Password plus it's length
        this.email = this.generate_email();
    }
    // Generating the email method
    private String generate_email(){
        return this.fname.toLowerCase() + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }
    // Asking for dept
    private String setDept(){
        System.out.println("Department codes \n 1) Sales \n 2) Development \n 3) Accounting \n 0) None");
        boolean flag = false ;
        do{
            System.out.println(" Enter department code: " );
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    return " sales";
                case 2:
                    return " Development";
                case 3:
                    return " Accounting";
                case 0 :
                    return  " None ";
                default:
                    System.out.println("Invalid choice please choose it again ");
            }
        }
        while (!flag);
        return  null ;
    }
    // Generate Random password method
    private  String genetrate_password(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars+ Small_chars + numbers + symbols ;
        String password = "";
        for(int i=0 ; i< length ; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    // change password method
    public  void set_password(){
        boolean flag = false;
        do{
            System.out.println(" Do you want to change password?(Y/N)");
            char choice = scan.next().charAt(0);
            if(choice=='Y' || choice=='y'){
                flag = true;
                System.out.println(" Enter current password:");
                String cpassword = scan.next();
                if(cpassword.equals(this.password)){
                    System.out.println(" Enter new password: ");
                    this.password= scan.next();
                    System.out.println(" Password changed successfully.");
                }
                else{
                    System.out.println(" Incorrect password");
                }
            }
            else if(choice == 'N'|| choice =='n'){
                flag = true ;
                System.out.println(" Password changed option is cancelled.");
            }
            else{
                System.out.println(" Enter valid choice. (Y/N) ");
            }
        }
        while(!flag);
    }
    // set mailbox capacity  method
    public void set_mailCap(){
        System.out.println(" Current capacity= "+ this.mailcapacity + "MB");
        System.out.println(" Enter new mailbox capacity: ");
        this.mailcapacity = scan.nextInt();
        System.out.println(" Mailbox capacity is successfully changed to " + this.mailcapacity );
    }
    // set alternate email
    public void alternate_email(){
        System.out.println(" Enter new alternate email: ");
        this.alter_email = scan.next();
        System.out.println(" Alternate email is set to "+ this.alter_email);
    }
    // Display user info method
    public void getInfo(){
        System.out.println(" New: "+ this.fname + " " + this.lname);
        System.out.println(" Department: " + this.dept);
        System.out.println(" Email: " + this.email);
        System.out.println(" Password: " + this.password);
        System.out.println(" Mailbox Capacity: " + this.mailcapacity + "MB");
        System.out.println(" Alternate email: "+  this.alter_email);
    }
    // store in file
    public void storefile(){
        try{
            FileWriter in = new FileWriter("E:\\20 Java Projects\\Project1_Email Administration System\\info.txt");
            in.write(" First name : " + this.fname);
            in.append(" \n Last name: " + this.lname);
            in.append(" \n Email: " + this.email);
            in.append(" \n Password : " + this.password);
            in.append(" \n Email Box Capacity : " + this.mailcapacity);
            in.append(" \n Alternate Email : " + this.alter_email);
            in.close();
            System.out.println(" Data Stored.");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    // reading file method
    public void  read_file(){
        try{
            FileReader f1 = new FileReader("E:\\20 Java Projects\\Project1_Email Administration System\\info.txt");
            int i ;
            while((i=f1.read())!= -1){
                System.out.print((char)i);
            }
            System.out.println();
            f1.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

