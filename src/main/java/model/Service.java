package model;

public class Service {
    private boolean isActive;
    private String serviceName;
    private double price;

    public Service(boolean isActive, String serviceName, double price) {
        this.isActive = isActive;
        this.serviceName = serviceName;
        this.price = price;
    }

    // Getters e Setters
    public boolean getIsActive() {
        return isActive;
    }

    public void setServiceId(boolean isActive) {
        this.isActive = isActive;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
