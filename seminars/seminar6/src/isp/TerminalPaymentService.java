package isp;

public class TerminalPaymentService  extends PaymentService implements WebMoneyPayable, CreditCardPayable {


    @Override
    public void payWebMoney(int amount) {
        System.out.printf("Internet pay by web money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount) {
        System.out.printf("Internet pay by credit card %d\n", amount);
    }

}
