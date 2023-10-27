import java.util.Scanner;

class InterfaceOfAtm {
    String name;
    String userName;
    String password;
    String accountNo;
    double balance = 200000;
    int transactions = 0;
    String transactionHistory = "";

    // User Registration

    public void register() {
        Scanner sc = new Scanner(System.in);                                                                                                      
        System.out.print("Enter your Name : ");
        this.name = sc.nextLine();
        System.out.println("\nEnter the Username : ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter the Password : ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number : ");
        this.accountNo = sc.nextLine();
        System.out.println("\nYour Registration is successfully completed.login to your Account.");
    }

    // User Login

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);                                                                                                     
        while (!isLogin) {
            System.out.print("\nEnter the  Username : ");
            String username = sc.nextLine();
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password : ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogged in successfully");
                        isLogin = true;
                    } else
                        System.out.println("\nPassword is Incorrect");
                }
            } else
                System.out.println("\nUsername not found");
        }
        return isLogin;
    }

    // Withdraw money

    public void withdraw() {
        System.out.println("\nEnter the amount: ");
        Scanner sc = new Scanner(System.in);                                                                                                   
        double amount = sc.nextDouble();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("\nSuccessfully withdrawn");
                String str = "Rs " + amount + " Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else
                System.out.println("\nBalance not sufficient");
        } catch (Exception e) {
        }
    }

    // Deposit

    public void deposit() {
        System.out.println("\nHow much amount do you want to deposit : ");
        Scanner sc = new Scanner(System.in);                                                                                             
        double amount = sc.nextDouble();
        try {
            if (amount <= 100000.00) {
                transactions++;
                balance += amount;
                System.out.println("\nYour money is successfully deposited");
                String str = "Rs " + amount + " deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else
                System.out.println("\nLimit Exceeded to deposit");
        } catch (Exception e) {
        }
    }

    // Transfer

    public void transfer() {
        Scanner sc = new Scanner(System.in);                                                                                                  
        System.out.println("\nEnter recepient name : ");
        String recepient = sc.nextLine();
        System.out.println("\nHow much amount do you want to tansfer : ");
        double amount = sc.nextDouble();
        try {
            if (balance >= amount) {
                if (amount <= 50000.00) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transferred to " + recepient);
                    String str = "Rs " + amount + " transferred to " + recepient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else
                    System.out.println("\nSorry! Limit is Exceeded");
            } else
                System.out.println("\nBalance not sufficient");
        } catch (Exception e) {
        }
    }

    // Check balance

    public void checkBalance() {
        System.out.println("\nRs " + balance);
    }

    // transaction history

    public void transHistory() {
        if (transactions == 0)
            System.out.println("\nEmpty!");
        else
            System.out.println("\n" + transactionHistory);
    }
}

// Interface of ATM

class ATM_Interface {
    public static int takeInput(int lmt) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);                                                                                          
                input = sc.nextInt();
                flag = true;
                if (flag && input > lmt || input < 1) {
                    System.out.println("Select the number between 1 to " + lmt);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Integer value only has to be Entered");
                flag = false;
            }
        }
        return input;
    }

    // main method

    public static void main(String[] args) {
        System.out.println("\n   WELCOME TO SBI ATM   \n");
        System.out.println("1.Register\n2.Exit");
        System.out.print("Select your choice: ");
        int choice = takeInput(2);
        if (choice == 1) {
            InterfaceOfAtm b = new InterfaceOfAtm();
            b.register();
            while (true) {
                System.out.println("\n1.Login\n2.Exit");
                System.out.print("Select your choice: ");
                int ch = takeInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\nWELCOME BACK! " + b.name + "\n\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance");
                            System.out.print("Select your choice : ");
                            int c = takeInput(6);
                            switch (c) {
                                case 1:
                                    b.deposit();
                                    break;
                                case 2:
                                    b.withdraw();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.transHistory();
                                    break;
                                case 5:
                                    b.checkBalance();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("\nIncorrect Choice!");
                            }
                        }
                    }
                } else
                    System.exit(0);
            }
        }
    };
}
