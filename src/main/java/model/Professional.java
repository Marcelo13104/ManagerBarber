package model;

public class Professional {
    private int professionalId;
    private String cpf;
    private String professionalName;
    private boolean isActive;

    // Getters e setters
    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "Professional{" +
               "cpf='" + cpf + '\'' +
               ", professionalName='" + professionalName + '\'' +
               ", isActive=" + isActive +
               '}';
    }
}
