package com.entity;

public class TradingRecord {
    private Integer id;

    private String date;

    private String sender;

    private String recepient;

    private String ammount;

    private String name;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient == null ? null : recepient.trim();
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount == null ? null : ammount.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "TradingRecord={" + "id=" + id + ", date='" + date + '\'' + ", sender=" + sender
                + ", recepient=" + recepient + ", ammount=" + ammount + ", name=" + name + ", address=" + address
                + '}';
    }
}