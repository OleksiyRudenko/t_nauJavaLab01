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
public class L04Agent extends L04Person {
    public L04Agent(String name) {
        super(name);
    }
    
    public ArrayList<L04RouteAdhoc> parseInquiry(L04Inquiry inquiry) {
        // get refs to both stations
        L04Station
                s0=inquiry.getStationFrom(),
                s1=inquiry.getStationTo();

        // build list of connection main routes
        ArrayList<L04RouteMain> arr=new ArrayList<L04RouteMain>();
        for (L04RouteMain r : s0.routeList) {
            if ( s1.routeList.contains(r) ) {
                arr.add(r);
            }
        }
        if (arr.size()==0) return null;
        
        // create subroutes with prices
        ArrayList<L04RouteAdhoc> travelOptions=new ArrayList<L04RouteAdhoc>();
        for (L04RouteMain r : arr) {
            int tariff=0;

            // find terminal stations
            int     begin=r.stop.indexOf(s0),
                    end=r.stop.indexOf(s1);
            if (begin<end) {
                // build list of subroute stops summing up tariff
                ArrayList<L04Station> sts=new ArrayList<L04Station>();
                for (int i=begin;i<end;i++) {
                    sts.add(r.stop.get(i));
                    tariff+=L04Rate.findRate(r.stop.get(i),r.stop.get(i+1)).getRate();
                }
                // add final station
                sts.add(r.stop.get(end));
                travelOptions.add(new L04RouteAdhoc(r.getNr(),r.getName(),tariff,sts));
            }
        }
        
        return travelOptions;
    }
   
}
