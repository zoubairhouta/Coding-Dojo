class BankAccount {

    private double checkingBalance;
    private double savingsBalance;





    private static int numberOfAccounts = 0;



    // Getters And Setters
    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

 

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance)
    {
        this.savingsBalance = savingsBalance;
    }


    public static int AccountCount() {
        return numberOfAccounts;
    }

}