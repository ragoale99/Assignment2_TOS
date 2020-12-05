////////////////////////////////////////////////////////////////////
// Alessandro Rago 1187504
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.util.List;
import java.time.LocalTime;

public class Order {
    List<MenuItem> itemsOrdered; 
    User u;
    LocalTime orarioOrdine;
    double price; 
    
    public Order(List<MenuItem> listaElementi, User u, LocalTime orarioOrdine, double price) {
        this.itemsOrdered = listaElementi; 
        this.u = u;
        this.orarioOrdine = orarioOrdine;
        this.price = price;
    }
    
    public double getPrice() {
        return price; 
    }

    public void setPrice(double p) {
        price = p;
    }

    public LocalTime getOrario() {
        return orarioOrdine;
    }

    public User getUser() {
        return u;
    }

    public List<MenuItem> getLista(){
        return itemsOrdered;
    }
    
}
