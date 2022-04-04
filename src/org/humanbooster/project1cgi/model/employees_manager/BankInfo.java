package org.humanbooster.project1cgi.model.employees_manager;

public class BankInfo {

    private String number;
    private String bankName;

    public BankInfo(String number, String bankName) {
        this.number = number;
        this.bankName = bankName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
                "number='" + number + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }

}
