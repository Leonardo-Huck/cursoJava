package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

       public String getHolder() {
        return holder;
    }

        public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void withdraw(Double amount) throws DomainException {
        if (amount > this.withdrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (amount > this.balance){
            throw new DomainException("Not enough balance");
        }
        this.balance -= amount;
    }
}
