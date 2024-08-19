public class DebitCardDeposits extends DebitCard {

    // Накопление в размере 0.005% от суммы пополнений.

    public DebitCardDeposits(double balance) {

        super(balance);
    }

    private double balance;
    private double deposit;

    @Override
    public void topUp(double sum) {
        deposit = deposit + (sum / 100 * 0.005);
        balance = balance + sum;
        System.out.printf("Баланс дебетовой карты пополнен на: %s%n", sum);
        System.out.println(getInfoFunds());
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            balance = balance - sum;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else {
            System.out.println("ВНИМАНИЕ ! Недостаточно средств !");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию !");
            return false;
        }
    }

    @Override
    public double getBalance() {

        return balance;
    }

    @Override
    public String getInfoFunds() {

        return "Баланс на дебетовой карте: " + balance +
                "\nКэшбэк: " + deposit;
    }
}
