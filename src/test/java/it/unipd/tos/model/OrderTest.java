package it.unipd.tos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private MenuItem item;
    private List<MenuItem> itemsOrdered;
    private User u;
    private LocalTime time;
    private Order ordine;

    @Before
    public void setup() {
        itemsOrdered = new ArrayList<MenuItem>();
        item = new MenuItem("Gelato fragola",MenuItem.type.Gelato, 2.00);
        itemsOrdered.add(item);
        u = new User(0000,"Alessandro","Rago",false);
        time = LocalTime.of(12, 00);
        ordine = new Order(itemsOrdered, u, time, 10);
    }
    
    @Test
    public void setPriceTest() {
        ordine.setPrice(20);
        assertEquals(20,ordine.getPrice(),0.0);
    }

    @Test
    public void getPriceTest() {
        assertEquals(10,ordine.getPrice(),0.0);
    }
    
    @Test
    public void getUserTest(){
        assertEquals(ordine.getUser(), u);
    }

    @Test
    public void getOrarioTest(){
        assertEquals(ordine.getOrario(), time);
    }

    @Test
    public void getListaTest(){      
        assertEquals(ordine.getLista(), itemsOrdered);
    }    
}
