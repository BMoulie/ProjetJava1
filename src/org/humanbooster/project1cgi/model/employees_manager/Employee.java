package org.humanbooster.project1cgi.model.employees_manager;

public class Employee {

    private static int count = 0;

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private Company company;
    private BankInfo bankInfo;
    private Status status;

    public Employee(String firstName, String lastName, double salary, Company company, BankInfo bankInfo, Status status) {
        this.id = ++count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
        this.bankInfo = bankInfo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                ", bankInfo=" + bankInfo +
                ", status=" + status +
                '}';
    }
}
