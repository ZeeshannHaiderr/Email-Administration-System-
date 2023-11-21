package emailapp;
import  java.util.*;
public class EmailApp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter first name : ");
        String f_name = scan.next();
        System.out.println(" Enter last name: ");
        String l_name = scan.next();

        // creating object for email class
        Email em1 = new Email(f_name,l_name);
        int choice = -1 ;
        do{
            System.out.println("\n *********\n Enter your choice \n 1) Show Info \n 2) Change password \n 3) Change " +
                    "Email Mailbox Capacity\n 4) Set alternate email \n 5) Store data in file \n 6) Display data from file" +
                    "\n 7) Exit ");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println(" Thank you for using this application.");
                    break;
                default:
                    System.out.println(" Invalid choice please enter valid choice(1-7): ");
            }
        }
        while(choice!=7);
    }
}
