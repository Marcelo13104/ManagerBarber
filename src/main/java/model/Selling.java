package dto;

import java.time.LocalDate;

public class Selling {
    private LocalDate sellingDate;
    private String cpf;
    private String serviceName;
    private String paymentName;
    private double total;

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public LocalDate getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(LocalDate sellingDate) {
        this.sellingDate = sellingDate;
    }
}


