public class DebitCardCashback extends DebitCard {

    // Потенциальный кэшбэк 5% от покупок при условии трат больше 5000 тыс.

    public DebitCardCashback(double balance) {

        super(balance);
    }

    private double balance;
    private double cashBack;

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        System.out.printf("Баланс дебетовой карты пополнен на: %s%n", sum);
        System.out.printf("Баланс дебетовой карты: %s%n", balance);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            if (sum > 5000) {
                cashBack = cashBack + sum * 5 / 100;
            }
            balance = balance - sum;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else {
            System.out.println("ВНИМАНИЕ ! Недостаточно средств !");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию!");
            return false;
        }
    }

    @Override
    public double getBalance() {

        return balance;
    }

    @Override
    public String getInfoFunds() {

        return "Баланс дебетовой карты: " + balance +
                "\nКешбэк: " + cashBack;
    }
}
