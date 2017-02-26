package example.codeclan.com.shophomework;

import java.util.HashMap;

/**
 * Created by user on 26/02/2017.
 */

public class Customer {

    private HashMap<PaymentType, Integer> funds;
    private PaymentType defaultMethod;

    public Customer() {
        this.funds = new HashMap<PaymentType, Integer>();
        for(PaymentType method : PaymentType.values()) {
            if( defaultMethod == null ) {
                this.defaultMethod = method;
            }
            funds.put(method, 0);
        }
    }

    public int getFunds() {
        return getFunds(defaultMethod);
    }

    public int getFunds(PaymentType method) {
        return funds.get(method);
    }

    public void receiveFunds(int amount) {
        setFunds( defaultMethod, getFunds() + amount );
    }

    public void receiveFunds(PaymentType method, int amount) {
        setFunds( method, getFunds(method) + amount );
    }

    public PaymentType getDefaultMethod() {
        return defaultMethod;
    }

    public void setDefaultMethod(PaymentType defaultMethod) {
        this.defaultMethod = defaultMethod;
    }

    public void spendFunds(int amount) {
        setFunds(defaultMethod, funds.get(defaultMethod) - amount);
    }

    public void spendFunds(PaymentType method, int amount) {
        setFunds(method, funds.get(method) - amount);
    }

    public int getTotalFunds() {
        int total = 0;
        for(PaymentType method : PaymentType.values()) {
            total += getFunds(method);
        }
        return total;
    }

    private void setFunds(PaymentType method, int amount) {
        funds.put( method, amount );
    }
}
