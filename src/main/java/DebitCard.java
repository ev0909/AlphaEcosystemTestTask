public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    private double balance;

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        System.out.printf("Баланс дебетовой карты пополнен на: %s%n", sum);
        System.out.printf("Остаток на дебетовой карте: %s%n", balance);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
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
        return String.format("Баланс дебетовой карты: %s", balance);
    }
}
