package example.codeclan.com.shophomework;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/02/2017.
 */

public class CustomerShopTest {

    Shop testShop;
    Customer testCustomer;

    @Before
    public void before() {
        testShop = new Shop();
        testCustomer = new Customer();
        testCustomer.setDefaultMethod(PaymentType.CREDIT_CARD);
        testCustomer.receiveFunds(PaymentType.CREDIT_CARD, 100);
        testCustomer.receiveFunds(PaymentType.DEBIT_CARD, 100);
    }

    @Test
    public void canMakeSaleToCustomer() {
        testShop.makeSale(testCustomer, 25);
        assertEquals(25, testShop.getTotalSales());
        assertEquals(75, testCustomer.getFunds());
    }

    @Test
    public void canMakeSaleToCustomerWithPaymentMethod() {
        PaymentType testMethod = PaymentType.DEBIT_CARD;
        testShop.makeSale(testCustomer, testMethod, 30);
        assertEquals(70, testCustomer.getFunds(testMethod));
    }

    @Test
    public void canGiveRefundToCustomer() {
        testShop.giveRefund(testCustomer, 15);
        assertEquals(-15, testShop.getTotalSales());
        assertEquals(115, testCustomer.getFunds());
    }

    @Test
    public void canGiveRefundToCustomerWithPaymentMethod() {
        PaymentType testMethod = PaymentType.DEBIT_CARD;
        testShop.giveRefund(testCustomer, testMethod, 10);
        assertEquals(110, testCustomer.getFunds(testMethod));
    }

}
