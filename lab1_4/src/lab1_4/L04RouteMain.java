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
public class L04RouteMain extends L04Route {
    static private HashSet<L04RouteMain> routeList=new HashSet<L04RouteMain>(); // collection of all routes
    
    public L04RouteMain(int nr) {
        super(nr);
        routeList.add(this);
    }

    public L04RouteMain(int nr, String... stationName) {
        super(nr,stationName);
        routeList.add(this);
    }

    public L04RouteMain(int nr, ArrayList<L04Station> stationName) {
        super(nr,stationName);
        routeList.add(this);
    }
    
    public void addStation(L04Station st) {
        stop.add(st);
        st.addRoute(this);
    }

    public boolean uniquity() {
        // check if this route duplicates any existing
        // if does - remove itself from routeList & return false
        int thisSize=stop.size();
        for (L04RouteMain r : routeList)
            if (r!=this && r.stop.size()==thisSize) {
                // different route & equal size - compare on per station basis
                int count=0;
                for (L04Station s : stop)
                    if (r.stop.contains(s))
                        count ++;
                if (count==thisSize) {
                    // remove self
                    remove();
                    return false;
                }
            }
        return true;
    }
    
    // public void removeStationsAll() {
    // }
    
    public void createReverseRoute() {
        // make list of stations
        ArrayList<L04Station> sa=new ArrayList<L04Station>(stop);
        Collections.reverse(sa);
        L04RouteMain r=new L04RouteMain(nr+1,sa);
    }
    
    public static void createReverseRoutesAll() {
        HashSet<L04RouteMain> routeList=new HashSet<L04RouteMain>(L04RouteMain.routeList);
        for (Iterator<L04RouteMain> it = routeList.iterator(); it.hasNext();) {
            L04RouteMain r = it.next();
            r.createReverseRoute();
        }
    }
        
    public static String dumpAll() {
        ArrayList<String> list = new ArrayList<String>();
        for (L04RouteMain r : routeList) {
            list.add(String.format("%s%n",r.dump()));
        }
        return String.join("",list);
    }
    
    public void remove() {
        // remove this from routeList
        routeList.remove(this);
        // also remove from stations
        for (L04Station s : L04Station.stationList)
            if (s.routeList.contains(this))
                s.routeList.remove(this);
    }
    
    public static void reset() {
        routeList.clear();
    }

}
