package com.example.model;

public class DisplayObject {
    private String imagePath;
    private String string1;
    private boolean displayed;

    public DisplayObject( String imagePath, String string1 ) {
        this.imagePath = imagePath;
        this.string1 = string1;
        this.displayed = false;
    }

    // Getters and setters
    public String getImagePath() { return imagePath; }
    public String getString1() { return string1; }
    public boolean isDisplayed() { return displayed; }
    public void setDisplayed(boolean displayed) { this.displayed = displayed; }
}