package example.codeclan.com.shophomework;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/02/2017.
 */

public class ShopTest {

    private Shop testShop;

    @Before
    public void before() {
        testShop = new Shop();
    }

    @Test
    public void totalSalesStartsEmpty() {
        assertEquals(0, testShop.getTotalSales());
    }

    @Test
    public void canMakeSale() {
        testShop.makeSale(20);
        assertEquals(20, testShop.getTotalSales());
    }

    @Test
    public void canGiveRefund() {
        testShop.giveRefund(20);
        assertEquals(-20, testShop.getTotalSales());
    }
}
