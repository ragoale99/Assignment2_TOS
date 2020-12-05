////////////////////////////////////////////////////////////////////
// Alessandro Rago 1187504
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.util.Random;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem.type;
import it.unipd.tos.model.Order;
import it.unipd.tos.business.exceptions.TakeAwayBillException;

public class TakeAwayBillManage implements TakeAwayBill{
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        double tot = 0.0, totBevande = 0.0, min_price = Double.MAX_VALUE;
        int i = 0;
        if(itemsOrdered.size() > 30){
            throw new TakeAwayBillException("Limite massimo di 30 ordini superato");
        }
        for(MenuItem m : itemsOrdered){
            if(m.getType() == type.Gelato) {
                i++;
                if(m.getPrice() < min_price) {
                    min_price=m.getPrice();
                }
            }
            if(m.getType()==type.Bevanda) {
                totBevande += m.getPrice();
            }
            tot+=m.getPrice();
        }
        
        if(i>=5) {
            tot -= min_price/2;
        }
        
        if(tot - totBevande > 50) {
            tot *= 0.9;
        }    
        
        if(tot < 10) {
            tot += 0.5;
        }
        
        return tot;
    }
    
    public List<Order> getFreeOrders(List<Order> orders) throws TakeAwayBillException {
        List<Order> freeOrders = new ArrayList<Order>();
        boolean exit = false;
        
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getUser().getMinorenne() && 
                    orders.get(i).getOrario().isAfter(LocalTime.of(18,00)) && 
                    orders.get(i).getOrario().isBefore(LocalTime.of(19,00))){ 
                for(int j = 0; j < freeOrders.size() && !exit; j++ ) {
                    if(orders.get(i).getUser().getId() == freeOrders.get(j).getUser().getId()) {
                        exit = true;
                    }
                }
                if(!exit) {
                    freeOrders.add(orders.get(i));
                }
            }
        }
     
        if(freeOrders.size() > 9){
            for(int i = 0; i < 10; i++) {
                int rnd = new Random().nextInt(freeOrders.size());
                if(freeOrders.get(rnd).getPrice() == 0) {
                    i--;
                }
                else {
                    freeOrders.get(rnd).setPrice(0);
                }
            }
        }
        else {
            throw new TakeAwayBillException("Non ci sono 10 ordini da regalare");
        }

        return freeOrders;
    }
}