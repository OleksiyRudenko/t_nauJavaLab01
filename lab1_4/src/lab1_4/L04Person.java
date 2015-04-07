/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_4;

/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class L04Person { // base class for Agent & Passenger
    private String name;
    
    public L04Person(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
