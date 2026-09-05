package com.example.model;

public class NumberStringObject {
    private int number;
    private String text;
    private boolean displayed;

    public NumberStringObject(int number, String text) {
        this.number = number;
        this.text = text;
        this.displayed = false;
    }

    // Getters and setters
    public int getNumber() { return number; }
    public String getText() { return text; }
    public boolean isDisplayed() { return displayed; }
    public void setDisplayed(boolean displayed) { this.displayed = displayed; }
}