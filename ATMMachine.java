


import java.util.Scanner;

class ATM {

    private final int PIN = 6700;
    private float balance;
    int wrongPinCount=0;
    private Scanner sc = new Scanner(System.in); // single Scanner for the whole class

    public void checkPin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();
      
       

        

        if (enteredPin == PIN) {
            menu();

        } else if(enteredPin != PIN ) {

            wrongPinCount ++;
            // System.out.println("attempt: " + wrongPinCount);

            if (wrongPinCount >= 3) {
                System.out.println("Maximum attempts exceeded. Card blocked.");
                 return;
                
            }else {
                System.out.println("Enter Valid PIN");
                checkPin();
            }
                 

            
            
        } 
        

    }

    public void menu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");


        int option = sc.nextInt();

        switch (option) {
            case 1 :
                checkBalance();      
                break;

            case 2 :
                 withdrawMoney(); 
                 break;

            case 3 :
                depositMoney(); 
                break;

            case 4 : {
                System.out.println("Thank you for using ATM!");
                return; //exit menu
            }
            default : {
                System.out.println("Invalid Choice. Try again.");
                menu();
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your Current Balance: ₹" + balance);
        menu();
    }

    public void withdrawMoney() {

        System.out.print("Enter Amount to Withdraw: ");
        float amount = sc.nextFloat();

        if (amount > balance ) {
            System.out.println("Insufficient Balance!");

        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful: ₹" + amount);
            System.out.println("Remaining Balance: ₹" + balance);
        }
        menu();
    }

    public void depositMoney() {

        System.out.print("Enter Amount to Deposit: ");
        float deposit = sc.nextFloat();


        if (deposit <= 0) {
            System.out.println("Enter a valid amount");
            
        }else{
            balance += deposit;
            System.out.println("Deposit Successful: ₹" + deposit);
            System.out.println("Updated Balance: ₹" + balance);
            menu();

        }

       
    }
}


public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}
