class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    public CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() - amount;
            if (newBalance >= 0 || Math.abs(newBalance) <= overdraftLimit) {
                setBalance(newBalance);
                if (newBalance < 0) {
                    System.out.println("Overdraft: Withdrew $" + amount + ". New balance: $" + String.format("%.2f", newBalance));
                } else {
                    System.out.println("Withdrew: $" + amount + ". New balance: $" + String.format("%.2f", newBalance));
                }
            } else {
                System.out.println("Withdrawal failed: exceeds overdraft limit");
            }
        }
    }
    
    @Override
    public String getAccountDetails() {
        return "Checking Account #" + getAccountNumber() + ", Balance: $" + String.format("%.2f", getBalance()) + ", Limit: $" + String.format("%.2f", overdraftLimit);
    }

    public static void main(String[] args) {
        CheckingAccount checking = new CheckingAccount("CA123", 500.0, 200.0);
        System.out.println(checking.getAccountDetails());
        checking.withdraw(600.0);
        System.out.println(checking.getAccountDetails());
        checking.withdraw(200.0);
    }
}