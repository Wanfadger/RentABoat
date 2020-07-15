package com.wanfadger.rentaboat;

import java.util.Arrays;
import java.util.List;

public class Boat {
    private int id;
    private String name;
    private String description;
    private String price;

    public Boat() {

    }

    public static List<Boat> getBoats() {
      return   Arrays.asList(
                new Boat("Boat one" , "This is boat one" , "200 Shs") ,
                new Boat("Boat two" , "This is boat two" , "500 Shs") ,
                new Boat("Boat three" , "This is boat Three" , "10000 Shs") ,
                new Boat("Boat four" , "This is boat Four" , "700 Shs"),
                new Boat("Boat five" , "This is boat five" , "3500 Shs")
        );
    }

    public Boat(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



}
