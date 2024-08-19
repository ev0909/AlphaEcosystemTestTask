public class CreditCardDeposits extends CreditCard {

    // Накопление в размере 0.005% от суммы пополнений.

    public CreditCardDeposits(double balance) {
        super(balance);
    }

    private final double creditLimit = 10_000;
    private double creditBalance = creditLimit;
    private double balance;
    private double deposit;

    @Override
    public void topUp(double sum) {
        if (creditBalance < creditLimit) {
            double difference = creditLimit - creditBalance;
            if (sum <= difference) {
                creditBalance = creditBalance + sum;
                deposit = deposit + sum * 0.005 / 100;
            }
            if (sum > difference) {
                creditBalance = creditBalance + difference;
                balance = balance + sum - difference;
                deposit = sum * 0.005 / 100;
            }
            System.out.printf("Баланс кредитной карты пополнен на: %s%n", sum);
            System.out.println(getInfoFunds());
        } else if (creditBalance >= creditLimit) {
            balance = balance + sum;
            deposit = deposit + sum * 0.005 / 100;
            System.out.printf("Баланс кредитной карты пополнен на: %s%n", sum);
            System.out.println(getInfoFunds());
        }
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            balance = balance - sum;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else if (balance < sum && sum <= (balance + creditBalance)) {
            double difference = sum - balance;
            balance = balance + difference - sum;
            creditBalance = creditBalance - difference;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
            System.out.println(getInfoFunds());
            return true;
        } else if (balance + creditBalance < sum) {
            System.out.println("ВНИМАНИЕ! Недостаточно средств");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию");
            return false;
        } else {
            System.out.println("ВНИМАНИЕ! Недостаточно средств");
            System.out.println(getInfoFunds());
            System.out.println("Пополните баланс карты и повторите операцию");
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
                "\nКэшбэк: " + deposit;
    }
}
