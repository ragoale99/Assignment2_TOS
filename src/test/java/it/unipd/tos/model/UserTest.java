package it.unipd.tos.model;

import it.unipd.tos.model.User;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class UserTest{
	private User u, u1, u2;
	
	@Before 
	public void setup() {
         u = new User(0000,"","",true);
	     u1 = new User(0001,"Nome", "Cognome", false);
	     u2 = new User(0002,"Alessandro", "Rago", true);
	}
	
    @Test
    public void getNomeTest(){
        assertEquals("", u.getNome());
        assertEquals("Nome", u1.getNome());
        assertEquals("Alessandro", u2.getNome());
    }

    @Test
    public void getCognomeTest(){
        assertEquals("", u.getCognome());
        assertEquals("Cognome", u1.getCognome());
        assertEquals("Rago", u2.getCognome());
    }

    @Test
    public void getIdTest(){
        assertEquals(0000, u.getId());
        assertEquals(0001, u1.getId());
        assertEquals(0002, u2.getId());
    }

    @Test
    public void isMinorenneTest_True(){
        assertEquals(true,  u.getMinorenne());
    }

    @Test
    public void isMinorenneTest_False(){
        assertEquals(false, u1.getMinorenne());
    }

}