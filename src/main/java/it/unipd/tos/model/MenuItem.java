////////////////////////////////////////////////////////////////////
// Alessandro Rago 1187504
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum type { Gelato, Budino, Bevanda }
    private String name;
    private type itemType;
    private double price;

    public MenuItem(String n, type t, double p){
        name = n;
        itemType = t;
        price = p;
    }

    public String getName(){
        return name;
    }

    public type getType(){
        return itemType;
    }

    public double getPrice(){
        return price;
    }
} 
