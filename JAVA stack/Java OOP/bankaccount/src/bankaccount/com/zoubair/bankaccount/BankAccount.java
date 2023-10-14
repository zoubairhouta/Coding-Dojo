package bankaccount.com.zoubair.bankaccount;

public class BankAccount {
    private String userName;
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    private static int numAccounts;
    private static double totalDeposits;

    public BankAccount() {
        userName = "Unknown";
        accountNumber = "000";
        numAccounts++;
    }

    public BankAccount(String name, String acctNum) {
        userName = name;
        accountNumber = acctNum;
        numAccounts++;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static int getNumAccounts() {
        return numAccounts;
    }

    public static double getTotalDeposits() {
        return totalDeposits;
    }

    public void makeDeposit(String account, double amount) {
        if (account == "checking") {
            this.checkingBalance += amount;
            totalDeposits += amount;
        }
        else if (account == "savings") {
            this.savingsBalance += amount;
            totalDeposits += amount;
        }
        return;
    }

    public void makeWithdrawal(String account, double amount) {
        if (account == "checking") {
            double newBalance = this.checkingBalance - amount;
            if (newBalance >= 0.0) {
                this.checkingBalance -= amount;
                totalDeposits -= amount;
            }
            else {
                System.out.println("No can do, Insufficient Funds");
            }
        }
        else if (account == "savings") {
            double newBalance = this.savingsBalance - amount;
            if (newBalance >= 0.0) {
                this.savingsBalance -= amount;
                totalDeposits -= amount;
            }
            else {
                System.out.println("No can do, Insufficient Funds");
            }
        }
        return;
    }

    public void displayAccountInfo(){
        System.out.printf("\n*********************  Account Balances  **********************");
        System.out.printf("\nUser name: %s , Account number: %s\n", this.userName, this.accountNumber);
        System.out.printf("\nChecking Balance: $%.2f , Savings Balance: $%.2f", this.checkingBalance, this.savingsBalance);
        System.out.printf("\n***************************************************************");
    }

}