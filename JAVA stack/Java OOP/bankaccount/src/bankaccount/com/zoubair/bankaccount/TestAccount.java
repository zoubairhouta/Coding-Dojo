package bankaccount.com.zoubair.bankaccount;


public class TestAccount {
    public static void main (String[] args) {

        BankAccount user1 = new BankAccount("Bugs Bunny", "123");
        BankAccount user2 = new BankAccount("Daffy Duck", "456");

        user1.makeDeposit("checking", 200);
        System.out.printf("\nChecking account balance for %s is: $%.2f\n", user1.getUserName(), user1.getCheckingBalance());
        user1.makeDeposit("savings", 500);
        System.out.printf("\nSavings account balance is: $%.2f\n", user1.getSavingsBalance());
        user1.displayAccountInfo();

        user2.makeDeposit("checking", 100);
        System.out.printf("\nChecking account balance for %s is: $%.2f\n", user2.getUserName(), user2.getCheckingBalance());
        user2.makeDeposit("savings", 50);
        System.out.printf("\nSavings account balance is: $%.2f\n", user2.getSavingsBalance());
        user2.displayAccountInfo();

        System.out.printf("\nThe total number of accounts is: %d\n", BankAccount.getNumAccounts());
        System.out.printf("\nThe total amount of deposits is: $%.2f\n", BankAccount.getTotalDeposits());

    }

}