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
public class L04Station {
    protected static HashSet<L04Station> stationList = new HashSet<L04Station>(); // which routes this Station is a stop for
    
    protected String name;
    protected HashSet<L04RouteMain> routeList = new HashSet<L04RouteMain>(); // which routes this Station is a stop for
    // protected L04Station [] neighbour; // neighbour Stations
    
    public L04Station(String name) {
        if (findByName(name)==null) {
            setName(name);
            stationList.add(this);
        }
    }

    public static L04Station findByName(String name) {
        for (L04Station s : stationList)
            if (s.name.equals(name))
                return s;
        return null;
    }
    
    public static String dumpAll() {
        StringBuilder str=new StringBuilder();
        for (L04Station s : stationList)
            str.append(s.dump());
        return str.toString();
    }
            
    public String dump() {
        ArrayList<String> list=new ArrayList<String>();
        for (L04RouteMain r : routeList)
            list.add(r.getName());
        return String.format("Station %-12s is a stop at routes (%2d): ",name,list.size())
                + ((list.size()>0) ? String.join(", ",list) : "none!" )
                + String.format("%n");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet getRoute() {
        return routeList;
    }

    public void setRoute(L04RouteMain[] routeArray) {
        for (L04RouteMain r : routeArray)
            routeList.add(r);
    }
    
    public void addRoute(L04RouteMain route) {
        routeList.add(route);
    }
    
    public static void reset() {
        stationList.clear();
    }

            
}
