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
public abstract class L04Route {
    protected int nr;
    protected ArrayList<L04Station> stop=new ArrayList<L04Station>(); // stops on a Route; ordered
    // add prices to move from each stop to the next

    public L04Route(int nr) {
        setNr(nr);
    }

    public L04Route(int nr, String... stationName) {
        setNr(nr);
        addStation(stationName);
    }

    public L04Route(int nr, ArrayList<L04Station> stationName) {
        setNr(nr);
        addStation(stationName);
    }

    public void setNr(int nr) { this.nr=nr; }
    public int getNr() { return nr; }
    
    public String getName() {
        return "#" + String.format("%-3s ",nr) + 
                ((stop.size()>0)
                ?stop.get(0).getName()+" - "+stop.get(stop.size()-1).getName()
                :"");
    }

    public String dump() {
        ArrayList<String> list = new ArrayList<String>();
        for (L04Station st : stop)
            list.add(st.getName());
        return String.format(" %-26s",getName()) + " : " + String.join(" - ", list);
    }
    
    public boolean addStation(String... stationName) {
        L04Station st;
        for (String s : stationName)
            if (L04Station.findByName(s)==null)
                return false;

        for (String s : stationName) {
            addStation(L04Station.findByName(s));
            //st=L04Station.findByName(s);
            //            if (st==null) {
            //                removeStationsAll();
            //                return false;
            //            }
            // addStation(st);
        }
        return true;
    }
    
    public boolean addStation(ArrayList<L04Station> stationName) {
        for (L04Station s : stationName) {
            addStation(s);
        }
        return true;
    }

    public abstract void addStation(L04Station st); // add self to L04Station object
    
    public abstract void remove(); // remove self from static list

}
