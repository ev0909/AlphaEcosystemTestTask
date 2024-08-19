public class CreditBonus extends CreditCard {

    // Бонусные баллы в размере 1% от покупок.

    public CreditBonus(double balance) {

        super(balance);
    }

    private final double creditLimit = 10_000;
    private double creditBalance = creditLimit;
    private double balance;
    private double bonus;

    @Override
    public void topUp(double sum) {
        if (creditBalance < creditLimit) {
            double difference = creditLimit - creditBalance;
            if (sum <= difference) {
                creditBalance = creditBalance + sum;
            }
            if (sum > difference) {
                creditBalance = creditBalance + difference;
                balance = balance + sum - difference;
            }
            System.out.printf("Баланс кредитной карты пополнен на: %s%n", sum);
            System.out.println(getInfoFunds());
        } else if (creditBalance >= creditLimit) {
            balance = balance + sum;
            System.out.printf("Баланс кредитной карты пополнен на: %s%n", sum);
            System.out.println(getInfoFunds());
        }
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            balance = balance - sum;
            bonus = bonus + sum / 100; // Расчёт бонус 1% от суммы оплаты
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else if (balance < sum && sum <= (balance + creditBalance)) {
            double difference = sum - balance;
            balance = balance + difference - sum;
            bonus = bonus + sum / 100;
            creditBalance = creditBalance - difference;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else if (balance + creditBalance < sum) {
            System.out.println("ВНИМАНИЕ! Недостаточно средств !");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию !");
            return false;
        } else {
            System.out.println("ВНИМАНИЕ! Недостаточно средств !");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию !");
            return false;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    @Override
    public String getInfoFunds() {
        return "Баланс кредитной карты:" +
                "\nКредитные средства: " + creditBalance +
                "\nСобственные средства: " + balance +
                "\nБонусных баллов: " + bonus;
    }
}

