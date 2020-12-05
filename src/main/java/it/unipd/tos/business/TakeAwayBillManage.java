////////////////////////////////////////////////////////////////////
// Alessandro Rago 1187504
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem.type;
import it.unipd.tos.business.exceptions.TakeAwayBillException;

public class TakeAwayBillManage implements TakeAwayBill{
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        double tot = 0.0, min_price = Double.MAX_VALUE, totBevande = 0.0;
        int i = 0;
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
        
        return tot;
    }
}