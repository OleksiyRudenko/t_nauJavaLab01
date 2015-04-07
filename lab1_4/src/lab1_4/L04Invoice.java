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
public class L04Invoice {
    
    private L04Inquiry inquiry;
    private L04RouteAdhoc route;

    public L04Invoice(L04Inquiry inquiry, L04RouteAdhoc route) {
        this.inquiry = inquiry;
        this.route = route;
    }
    
    public String dump() {
        return inquiry.dump()+String.format("%n\u00A3%4d %s%n",route.tariff,route.dump());
    }
    
    
    
}
