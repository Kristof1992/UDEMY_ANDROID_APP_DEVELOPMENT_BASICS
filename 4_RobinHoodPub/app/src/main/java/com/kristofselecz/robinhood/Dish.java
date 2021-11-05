package com.kristofselecz.robinhood;

public class Dish {
    private String title;
    private String description;
    private int price;

    public Dish(String title, String description, int price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title;
    }
}
