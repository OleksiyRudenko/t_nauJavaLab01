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
public class L04RouteAdhoc extends L04Route {
    static private HashSet<L04RouteAdhoc> routeList=new HashSet<L04RouteAdhoc>(); // collection of all routes
    int tariff=0;
    String terminalStations="";
    
    public L04RouteAdhoc(int nr, String terminalStations, int tariff) {
        super(nr);
        this.terminalStations=terminalStations;
        this.tariff=tariff;
        routeList.add(this);
    }

    public L04RouteAdhoc(int nr, String terminalStations, int tariff, String... stationName) {
        super(nr,stationName);
        this.terminalStations=terminalStations;
        this.tariff=tariff;
        routeList.add(this);
    }

    public L04RouteAdhoc(int nr, String terminalStations, int tariff, ArrayList<L04Station> stationName) {
        super(nr,stationName);
        this.terminalStations=terminalStations;
        this.tariff=tariff;
        routeList.add(this);
    }
    
    public String getName() {
        return terminalStations;
    }
    
    public void addStation(L04Station st) {
        stop.add(st);
    }
    
    public static String dumpAll() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Price | #   | Terminal stations    | Stops at your route\n");
        for (L04RouteAdhoc r : routeList) {
            list.add(String.format("\u00A3%4d  %s%n",r.tariff,r.dump()));
        }
        return String.join("",list);
    }
    
    public void remove() {
        // remove this from routeList
        routeList.remove(this);
    } 
    
    public static void reset() {
        routeList.clear();
    }

}