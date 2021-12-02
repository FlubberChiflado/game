package com.example.game;

public class Game {
    private String name;
    private String contactAdress;
    private int priceToken;
    private int holders;
    private String token;

    public Game(String name, String contactAdress, int priceToken, int holders, String token) {
        super();
        this.name = name;
        this.contactAdress = contactAdress;
        this.priceToken = priceToken;
        this.holders = holders;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactAdress() {
        return contactAdress;
    }

    public void setContactAdress(String contactAdress) {
        this.contactAdress = contactAdress;
    }

    public int getPriceToken() {
        return priceToken;
    }

    public void setPriceToken(int priceToken) {
        this.priceToken = priceToken;
    }

    public int getHolders() {
        return holders;
    }

    public void setHolders(int holders) {
        this.holders = holders;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
