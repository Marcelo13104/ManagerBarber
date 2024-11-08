package dto;

//SellingDTO.java
public class SellingDTO {
 private String cpf;
 private int serviceId;
 private String paymentName;
 private double total;

 // Getters e Setters
 public String getCpf() {
     return cpf;
 }

 public void setCpf(String cpf) {
     this.cpf = cpf;
 }

 public int getServiceId() {
     return serviceId;
 }

 public void setServiceId(int serviceId) {
     this.serviceId = serviceId;
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
}
