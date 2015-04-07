/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_4;
import java.util.*;

/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class L04Rate {
    private static HashSet<L04Rate> rateList=new HashSet<L04Rate>();
    private L04Station [] station=new L04Station[2];
    private int rate;
    
    public L04Rate(L04Station station0, L04Station station1, int rate) {
        station[0]=station0;
        station[1]=station1;
        this.rate=rate;
        rateList.add(this);
    }
    
    public int getRate() {
        return rate;
    }
    
    public String getName() {
        return station[0].name + " - " + station[1].name;
    }
    
    public String dump() {
        return String.format("%-24s",getName()) + " = \u00A3" + rate;
    }

    public L04Rate find(L04Station station0, L04Station station1) {
        return findRate(station0,station1);
    }

    public static L04Rate findRate(L04Station station0, L04Station station1) {
        for (L04Rate r : L04Rate.rateList) {
            if ( (r.station[0]==station0 && r.station[1]==station1)
                    || (r.station[1]==station0 && r.station[0]==station1) )
                return r;
        }
        return null;
    }
    
    public static void reset () {
        rateList.clear();
    }
            
}
