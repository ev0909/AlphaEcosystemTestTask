import java.util.Scanner;


public class BankCards {

    public static void main(String[] args) {

        double balance = 0;
        double sum = 0;

        Scanner scanner = new Scanner(System.in);

        DebitCard debitCard = new DebitCard(balance);
        CreditCard creditCard = new CreditCard(balance);
        DebitCardCashback debitCardCashback = new DebitCardCashback(balance);
        CreditCardCashback creditCardCashback = new CreditCardCashback(balance);
        DebitBonus debitBonus = new DebitBonus(balance);
        CreditBonus creditBonus = new CreditBonus(balance);
        DebitCardDeposits debitCardDeposits = new DebitCardDeposits(balance);
        CreditCardDeposits creditCardDeposits = new CreditCardDeposits(balance);

        while (true) {
            menu();
            int input = scanner.nextInt();
            if (input == 0) {
                System.out.println("Выход !");
                break;
            } else if (input == 1) {
                System.out.println("Сумма пополнения дебетовой карты?");
                sum = scanner.nextDouble();
                debitCard.topUp(sum);
            } else if (input == 2) {
                System.out.println(debitCard.getInfoFunds());
            } else if (input == 3) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                debitCard.pay(sum);
            } else if (input == 4) {
                System.out.println("Сумма пополнения кредитной карты?");
                sum = scanner.nextDouble();
                creditCard.topUp(sum);
            } else if (input == 5) {
                System.out.println(creditCard.getInfoFunds());
            } else if (input == 6) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                creditCard.pay(sum);
            } else if (input == 7) {
                System.out.println("Сумма пополнения дебетовой карты?");
                sum = scanner.nextDouble();
                debitBonus.topUp(sum);
            } else if (input == 8) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                debitBonus.pay(sum);
            } else if (input == 9) {
                System.out.println(debitBonus.getInfoFunds());
            } else if (input == 10) {
                System.out.println("Сумма пополнения дебетовой карты?");
                sum = scanner.nextDouble();
                debitCardCashback.topUp(sum);
            } else if (input == 11) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                debitCardCashback.pay(sum);
            } else if (input == 12) {
                System.out.println(debitCardCashback.getInfoFunds());
            } else if (input == 13) {
                System.out.println("Сумма пополнения дебетовой карты?");
                sum = scanner.nextDouble();
                debitCardDeposits.topUp(sum);
            } else if (input == 14) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                debitCardDeposits.pay(sum);
            } else if (input == 15) {
                System.out.println(debitCardDeposits.getInfoFunds());
            } else if (input == 16) {
                System.out.println("Сумма пополнения кредитной карты?");
                sum = scanner.nextDouble();
                creditBonus.topUp(sum);
            } else if (input == 17) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                creditBonus.pay(sum);
            } else if (input == 18) {
                System.out.println(creditBonus.getInfoFunds());
            } else if (input == 19) {
                System.out.println("Сумма пополнения кредитной карты?");
                sum = scanner.nextDouble();
                creditCardCashback.topUp(sum);
            } else if (input == 20) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                creditCardCashback.pay(sum);
            } else if (input == 21) {
                System.out.println(creditCardCashback.getInfoFunds());
            } else if (input == 22) {
                System.out.println("Сумма пополнения кредитной карты?");
                sum = scanner.nextDouble();
                creditCardDeposits.topUp(sum);
            } else if (input == 23) {
                System.out.println("Сумма оплаты?");
                sum = scanner.nextDouble();
                creditCardDeposits.pay(sum);
            } else if (input == 24) {
                System.out.println(creditCardDeposits.getInfoFunds());
            } else {
                System.out.println("Такой операции нет !");
            }
        }
    }

    private static void menu() {

        System.out.println("\nЧто вы хотите сделать? ");

        System.out.println("1 - Пополнить дебетовую карту");
        System.out.println("2 - Получить информацию о балансе дебетовой карты");
        System.out.println("3 - Оплатить дебетовой картой");

        System.out.println("4 - Пополнить кредитную карту");
        System.out.println("5 - Получить информацию о балансе кредитной карты");
        System.out.println("6 - Оплатить кредитной картой");

        System.out.println("7 - Пополнить дебетовую карту. Бонус 1%");
        System.out.println("8 - Оплатить дебетовой картой. Бонус 1%");
        System.out.println("9 - Получить информацию о балансе дебетовой карты. Бонус 1%");

        System.out.println("10 - Пополнить дебетовую карту. Кешбэк 5%");
        System.out.println("11 - Оплатить дебетовой картой. Кешбэк 5%");
        System.out.println("12 - Получить информацию о балансе дебетовой карты. Кешбэк 5%");

        System.out.println("13 - Пополнить дебетовую карту. Накопление в размере 0.005%");
        System.out.println("14 - Оплатить дебетовой картой. Накопление в размере 0.005%");
        System.out.println("15 - Получить информацию о балансе дебетовой карты. Накопление в размере 0.005%");

        System.out.println("16 - Пополнить кредитную карту. Бонус 1%");
        System.out.println("17 - Оплатить кредитной картой. Бонус 1%");
        System.out.println("18 - Получить информацию о балансе кредитной карты. Бонус 1%");

        System.out.println("19 - Пополнить кредитную карту. Кэшбэк 5%");
        System.out.println("20 - Оплатить кредитной картой. Кэшбэк 5%");
        System.out.println("21 - Получить информацию о балансе кредитной карты Кешбэк 5%");

        System.out.println("22 - Пополнить кредитную карту. Накопление в размере 0.005%");
        System.out.println("23 - Оплатить кредитной картой. Накопление в размере 0.005%");
        System.out.println("24 - Получить информацию о балансе кредитной карты. Накопление в размере 0.005%");

        System.out.println("0 - Выход");
    }
}
