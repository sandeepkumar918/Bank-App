import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Name,Password,Balance to create an Account");

        String name=sc.nextLine();
        String password=sc.nextLine();
        double balance=sc.nextDouble();
        SBIUser user=new SBIUser(name,balance,password);

        String message=user.addMoney(100000);
        System.out.println(message);

        System.out.println("Enter Amount You want to withdraw");
        double money=sc.nextDouble();
        System.out.println("Enter Your Password");
        sc.nextLine();
        String pass=sc.nextLine();
        System.out.println(user.withdrawMoney(50000,pass));

        System.out.println(user.calculateInterest(10));
    }
}