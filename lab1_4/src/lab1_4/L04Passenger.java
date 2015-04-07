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
public class L04Passenger extends L04Person {

    private L04Inquiry [] inquiry;
            
    public L04Passenger(String name) {
        super(name);
    }
    
    public L04Inquiry makeInquiry(
            L04Agent agent,
            L04Station stationFrom, 
            L04Station stationTo, 
            String travelDatetime) {
        L04Inquiry inquiry=new L04Inquiry(this,agent,stationFrom,stationTo,travelDatetime);
        return inquiry;
    }
    
    public L04RouteAdhoc findCheapestAndShortest(ArrayList<L04RouteAdhoc> travelOptions) {
        L04RouteAdhoc target=null;
        for (L04RouteAdhoc r : travelOptions) {
            if (target==null || r.tariff < target.tariff) 
                target=r;
            else
                if (r.tariff == target.tariff && r.stop.size() < target.stop.size())
                    target=r;
        }
        return target;
    }
}
