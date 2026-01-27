
class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber,String accountHolderName){
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        this.balance=0.0;

    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName=accountHolderName;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance+=amount;
            System.out.println("Success  Deposited: $"+amount);
        }else{
            System.out.println(" error Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount){
        if (amount <0){
            System.out.println(" error Withdrawal amount must be positive.");
        }
        else if(amount > balance){
            System.out.println(" error Insufficient funds.");
            }else{
                balance-=amount;
                System.out.println("Success Withdrawn: $"+amount);
            }
            }
            
    public String getAccountDetails(){
        return "Account Number: "+accountNumber+"\n"+
               "Account Holder: "+accountHolderName+"\n"+
               "Balance: $"+String.format("%.2f",balance);
    }
    public static void main(String[] args){
        BankAccount account=new BankAccount("7777","Jon Snow");
        System.out.println(account.getAccountDetails());
        account.deposit(500);
        account.withdraw(200);
        System.out.println(account.getAccountDetails());
    }


}