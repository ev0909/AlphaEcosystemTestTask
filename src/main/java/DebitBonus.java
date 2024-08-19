public class DebitBonus extends DebitCard {

    // Бонусные баллы в размере 1% от покупок.

    public DebitBonus(double balance) {

        super(balance);
    }

    private double balance;
    private double cashback;

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        System.out.printf("Баланс дебетовой карты: " + balance +
                "\nБонусных баллов: " + cashback);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            cashback = cashback + sum / 100;
            balance = balance - sum;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else {
            System.out.println("Недостаточно средств !");
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

        return "Баланс дебетовой карты: " + balance +
                "\nБонусных баллов: " + cashback;
    }
}

