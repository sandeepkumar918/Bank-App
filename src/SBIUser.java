import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{
   private String name;
   private String accountNo;
   private double balance;
   private String password;
   private static double rateOfInterest;

    @Override
    public double checkBalance() {
        return balance;
    }

    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        //bank is innitialize
        this.rateOfInterest=6.5;
        this.accountNo=String.valueOf(UUID.randomUUID());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public String addMoney(int amount) {
        balance+=amount;
        return "Your new balance is: "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enterPassword) {
        if(Objects.equals(enterPassword,password)){
            if(amount>balance){
                return "Sorry Insufficient Money";
            }else{
                balance=balance-amount;
                return "Collect your Cash";
            }
        }else{
            return "Wrong password";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
