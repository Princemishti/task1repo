class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
    
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: $" + String.format("%.2f", interest) + ". New balance: $" + String.format("%.2f", getBalance()));
    }
    
    @Override
    public String getAccountDetails() {
        return "Savings Account #" + getAccountNumber() + ", Balance: $" + String.format("%.2f", getBalance()) + ", Rate: " + (interestRate * 100) + "%";
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 1000.0, 0.05);
        System.out.println(savings.getAccountDetails());
        savings.applyInterest();
        System.out.println(savings.getAccountDetails());
    }
}
