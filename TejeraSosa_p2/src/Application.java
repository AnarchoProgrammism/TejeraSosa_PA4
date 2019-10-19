public class Application {

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(0.04);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());


        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println(saver1.getSavingsBalance());
        System.out.println(saver2.getSavingsBalance());

    }
}
