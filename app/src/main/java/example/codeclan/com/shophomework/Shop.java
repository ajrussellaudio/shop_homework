package example.codeclan.com.shophomework;

/**
 * Created by user on 26/02/2017.
 */

public class Shop {

    private int totalSales;

    public Shop() {
        this.totalSales = 0;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void makeSale(int amount) {
        totalSales += amount;
    }

    public void makeSale(Customer customer, int amount) {
        customer.spendFunds(amount);
        makeSale(amount);
    }

    public void makeSale(Customer customer, PaymentType method, int amount) {
        customer.spendFunds(method, amount);
        makeSale(amount);
    }

    public void giveRefund(int amount) {
        totalSales -= amount;
    }

    public void giveRefund(Customer customer, int amount) {
        customer.receiveFunds(amount);
        giveRefund(amount);
    }

    public void giveRefund(Customer customer, PaymentType method, int amount) {
        customer.receiveFunds(method, amount);
        giveRefund(amount);
    }
}
