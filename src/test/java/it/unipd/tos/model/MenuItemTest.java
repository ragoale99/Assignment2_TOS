package it.unipd.tos.model;

import it.unipd.tos.model.MenuItem;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MenuItemTest{
    private MenuItem m, m1, m2;
    
    @Before
    public void setup() {
    	m = new MenuItem("Gelato fragola", MenuItem.type.Gelato, 2.50);
        m1 = new MenuItem("", MenuItem.type.Bevanda, 2.00);
        m2 = new MenuItem("Budino pinguino", MenuItem.type.Budino, 5.00);
    }

	@Test
    public void getNameTest(){
        assertEquals("Gelato fragola", m.getName());
        assertEquals("", m1.getName());
        assertEquals("Budino pinguino", m2.getName());
    }
	
	@Test
    public void getTypeTest(){
        assertEquals(MenuItem.type.Gelato, m.getType());
        assertEquals(MenuItem.type.Bevanda, m1.getType());
        assertEquals(MenuItem.type.Budino, m2.getType());
    }
	
	@Test
    public void getPriceTest(){
		assertEquals(2.50, m.getPrice(),0.0);
        assertEquals(2.00, m1.getPrice(),0.0);
        assertEquals(5.00, m2.getPrice(),0.0);
    }
	
}