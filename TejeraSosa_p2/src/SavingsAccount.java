public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount() {
        savingsBalance = 0.0;
    }

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        this.savingsBalance += (annualInterestRate * this.savingsBalance) / 12.0;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }


}
