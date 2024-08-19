public abstract class BankCard {

    private double balanse;

    public BankCard(double balanse) {
        this.balanse = balanse;
    }

    public abstract void topUp(double sum);

    public abstract boolean pay(double sum);

    public abstract double getBalance();

    public abstract String getInfoFunds();
}
