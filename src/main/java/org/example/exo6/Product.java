package org.example.exo6;

public class Product {


    private String type;
    private String name;
    private int sellIn;
    private int quality;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public boolean setSellIn(int sellIn) {
        this.sellIn = sellIn;
        return false;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

}
