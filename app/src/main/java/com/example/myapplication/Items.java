package com.example.myapplication;

public class Items {
    private int Image;
    private String Number;
    private String name;

    public Items(int image, String number, String name) {
        Image = image;
        Number = number;
        this.name = name;
    }
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
