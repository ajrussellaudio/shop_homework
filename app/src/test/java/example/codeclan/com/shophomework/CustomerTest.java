package example.codeclan.com.shophomework;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/02/2017.
 */

public class CustomerTest {

    private Customer testCustomer;

    @Before
    public void before() {
        this.testCustomer = new Customer();
    }

    @Test
    public void fundsStartEmpty() {
        assertEquals( 0, testCustomer.getFunds(PaymentType.CREDIT_CARD) );
    }

    @Test
    public void canReceiveFunds() {
        testCustomer.receiveFunds(PaymentType.CREDIT_CARD, 100);
        assertEquals( 100, testCustomer.getFunds(PaymentType.CREDIT_CARD) );
    }

    @Test
    public void canSetDefaultPaymentMethod() {
        testCustomer.setDefaultMethod(PaymentType.CREDIT_CARD);
        assertEquals(PaymentType.CREDIT_CARD, testCustomer.getDefaultMethod());
    }

    @Test
    public void canSpendFunds() {
        testCustomer.setDefaultMethod(PaymentType.CREDIT_CARD);
        testCustomer.receiveFunds(100);
        testCustomer.spendFunds(25);
        assertEquals( 75, testCustomer.getFunds() );
    }

    @Test
    public void canGetTotalFunds() {
        testCustomer.receiveFunds(PaymentType.CREDIT_CARD, 100);
        testCustomer.receiveFunds(PaymentType.DEBIT_CARD, 100);
        assertEquals(200, testCustomer.getTotalFunds());
    }

}
