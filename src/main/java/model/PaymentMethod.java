package model;

public class PaymentMethod {
    private String paymentName;

    public PaymentMethod(String paymentName) {
        this.paymentName = paymentName;
    }

    // Getters e Setters
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
