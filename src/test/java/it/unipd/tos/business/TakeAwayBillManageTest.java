package it.unipd.tos.business;

import it.unipd.tos.business.TakeAwayBillManage;
import it.unipd.tos.business.exceptions.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TakeAwayBillManageTest{
    private List<MenuItem> itemsOrdered;
    private TakeAwayBillManage testPrice; 
    private User u;
	
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
    @Before
    public void setup() {
        itemsOrdered = new ArrayList<MenuItem>();
        testPrice = new TakeAwayBillManage();
        u = new User(00000,"Alessandro","Rago",true);
    }
    
	@Test
    public void CalcoloDelTotaleTest_True(){

        itemsOrdered.add(new MenuItem("Gelato fragola", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 2.00));
        itemsOrdered.add(new MenuItem("Budino pinguino", MenuItem.type.Budino, 4.00));
        itemsOrdered.add(new MenuItem("Budino pinguino maxi", MenuItem.type.Budino, 8.00));

        try{
            assertEquals(16.50, testPrice.getOrderPrice(itemsOrdered, u),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    } 
	
    @Test
    public void TotaleMenoScontoDel50Test_True() {

        itemsOrdered.add(new MenuItem("Gelato 2 palline", MenuItem.type.Gelato, 3.50));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 2.00));
        itemsOrdered.add(new MenuItem("Gelato 3 palline", MenuItem.type.Gelato, 4.50));
        itemsOrdered.add(new MenuItem("Gelato cioccolato", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Gelato fragola", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Gelato baby", MenuItem.type.Gelato, 1.00));
        
        try{
            assertEquals(15.50, testPrice.getOrderPrice(itemsOrdered, u),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    } 
    
    @Test
    public void TotaleMenoScontoDel50Test_False() {

        itemsOrdered.add(new MenuItem("Gelato 2 palline", MenuItem.type.Gelato, 3.50));
        itemsOrdered.add(new MenuItem("Coca cola", MenuItem.type.Bevanda, 2.00));
        itemsOrdered.add(new MenuItem("Gelato cioccolato", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Gelato fragola", MenuItem.type.Gelato, 2.50));
        itemsOrdered.add(new MenuItem("Gelato baby", MenuItem.type.Gelato, 1.00));
        
        try{
            assertEquals(11.50, testPrice.getOrderPrice(itemsOrdered, u),0.0);
        } 
        catch (TakeAwayBillException exc){
            exc.getMessage();
        }
    } 
}