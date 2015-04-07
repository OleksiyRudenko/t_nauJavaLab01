/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_4;
import java.util.*;
import java.text.*;
/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class L04Inquiry {
    
    private String regNr;
    private Date datetime=new Date(); // http://www.tutorialspoint.com/java/java_date_time.htm
    private Date travelDatetime=new Date();
    
    private L04Passenger passenger;
    private L04Agent agent;
    
    private L04Station station[]=new L04Station[2];
    
    // protected L04TravelOptions travelOptions;
    // protected L04Invoice invoice;
    
    public L04Inquiry(L04Passenger passenger,L04Agent agent, L04Station stationFrom, L04Station stationTo, String travelDatetime) {
        // DD-MM-YYYY HH:MM
        this.passenger=passenger;
        this.agent=agent;
        station[0]=stationFrom;
        station[1]=stationTo;
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        try { 
          this.travelDatetime = sdf.parse(travelDatetime); 
        } catch (ParseException e) {
            // this.travelDatetime=System.out.println("Unparseable using " + ft); 
        }
    }
    
    public L04Station getStationFrom() { return station[0]; }
    public L04Station getStationTo() { return station[1]; }
    
    public ArrayList<L04RouteAdhoc> passToAgent() {
        ArrayList<L04RouteAdhoc> travelOptions=agent.parseInquiry(this);
        return travelOptions;
    }
    
    public String dump() {
        return String.format("Requested on %td-%<tm-%<tY %<tH:%<tM%nPassenger: %s%nAgent: %s%nTravel date: %td-%<tm-%<tY%nRoute: %s - %s", 
                datetime,
                passenger.getName(),
                agent.getName(),
                travelDatetime,
                station[0].getName(),
                station[1].getName()
        );
    }
    
}
