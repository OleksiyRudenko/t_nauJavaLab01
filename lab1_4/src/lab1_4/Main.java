/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_4;
// ###
import java.util.*;
// var 11

/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class Main {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        int  labcount=4, labnr;
        String stub; // just to wait for ENTER from user
        
        do {
            labnr=MyIO.getInteger(
                    "Lab #(1"
                        +((labcount>1)?"-"+labcount:"")
                        +") or 0 to quit:"
                    );
            switch (labnr) {
                case 1:
                    // Дана матрица A[N][N] вещественных значений типа float, где N = 5. Выполните
                    // циклический сдвиг заданной матрицы на m позиций вправо. Результат выведите на
                    // экран.
                    System.out.println("Lab #1. Matrix rotation");
                    Matrix mx = new Matrix(5);
                    byte m = (byte) MyIO.getInteger("Matrix rotate-right value (1-9):");
                    mx.print("Initial state:");
                    mx.ror(m);
                    mx.print("Rotated right state:");
                    break;
                case 2:
                    // Задать некоторый текст. Изменить текст следующим образом: в каждом слове
                    // текста заменить букву на k-ой позиции заданным символом. Если длина слова
                    // меньше k, то корректировку не проводить.
                    System.out.println("Lab #2. Substitute char at k-th position in every word");
                    String txt="";
                    while (txt.length()==0)
                        txt=MyIO.getString("Source text:");
                    String sub="";
                    while (sub.length()!=1)
                        sub=MyIO.getString("Single substitution char:");
                    char subchar=sub.toCharArray()[0];
                    int k=0;
                    while (k<=0)
                        k=MyIO.getInteger("k (positive >0):");
                    String arr[];
                    arr = txt.split(" ");
                    // System.out.println(txt+" @ "+k+" <= "+subchar);
                    for (int i=0;i<arr.length;i++) {
                        // System.out.print(arr[i]+" => ");
                        if (arr[i].length()>=k) {
                            StringBuilder sb=new StringBuilder(arr[i]);
                            sb.setCharAt(k-1,subchar);
                            arr[i]=sb.toString();
                        }
                        // System.out.println(arr[i]);
                    }
                    System.out.println("Replacement result: "+String.join(" ", arr));
                    // 2do improvements: split on punctuation also; remember glues for split parts
                    break;
                case 3:
                    // 1. Описывает класс согласно варианта задания (столб. 2).
                    // 2. Создает массив объектов, для которого выводит на экран информацию согласно
                    // варианта задания (столб. 3).
                    System.out.println("Lab #3. Students stats");
                    final String studentIni[][]={ 
                        // surname, name, patronimic, sex, country, studentId, studyLifetime, avgMark
                        { "MARTYNENKO", "Ihor", "Ivanovych", "m", "UA", "AB 1001", "2", "5" },
                        { "MARCHENKO", "Oksana", "Ivanivna", "f", "UA", "AB 1002", "2", "4" },
                        { "MYKYTENKO", "Oleg", "Ivanvych", "m", "UA", "AB 1003", "2", "3" },
                        { "MOTSNIY", "Erzy", "", "m", "PL", "AB 1004", "2", "5" },
                        
                        { "KARTYNENKO", "Ihor", "Andriyovych", "m", "UA", "AB 2001", "4", "5" },
                        { "KARCHENKO", "Oksana", "Andriivna", "f", "UA", "AB 2002", "4", "4" },
                        { "KYKYTENKO", "Oleg", "Andriyovych", "m", "UA", "AB 2003", "4", "3" },
                        { "KOTSNA", "Elena", "Andreevna", "f", "BY", "AB 2004", "4", "3" },

                        { "NOTOK", "Sasha", "", "f", "PL", "AB 3001", "5", "3" },
                        { "NARCHENKO", "Ulyana", "Mykolaivna", "f", "UA", "AB 3002", "5", "5" },
                        { "NOSIY", "Viktor", "Mamedovich", "m", "KZ", "AB 3003", "5", "4" },
                        { "NOTSNA", "Elena", "Mykhailivna", "f", "BY", "AB 3004", "5", "5" },
                    };
                    
                    Student student[]=new Student[studentIni.length];
                    for (int i=0;i<studentIni.length;i++)
                        student[i]=new Student(studentIni[i]);
                        
                    // 1. Список студентов-отличников 2-го курса.
                    // 2. Список студентов-иностранцев, которые учатся на "4" и"5".
                    // 3. Список студентов-женщин 5-го курса, которые учатся на "5".
                    
                    // print all
                    System.out.println("All students:");
                    for (Student s : student)
                        s.print();
                    
                    stub=MyIO.getString("Press ENTER to see 2nd year top-performers >");
                    for (Student s : student)
                        if (s.getStudyLife()==2 && s.getAvgMark()==5)
                            s.print();

                    stub=MyIO.getString("Press ENTER to see foreigners with avg marks 4 or 5 >");
                    for (Student s : student)
                        if (s.getCountry()!=Student.countries.UA && s.getAvgMark()>=4)
                            s.print();

                    stub=MyIO.getString("Press ENTER to see 5th year female top-performers >");
                    for (Student s : student)
                        if (s.getSex()=='f' && s.getAvgMark()==5 && s.getStudyLife()==5)
                            s.print();
                    break;
                case 4:
                    //Разработать систему «Железнодорожная касса». Пассажир делает заявку на
                    //станцию назначения, время и дату поездки. Система регистрирует Заявку и
                    //осуществляет поиск соответствующего Поезда. Пассажир делает выбор Поезда и
                    //получает Счет на оплату. Кассир вводит номера Поездов, промежуточные и
                    //конечные станции, цены.
                    System.out.println("Lab #4. Railroad ticket office");
                    L04Passenger passenger=new L04Passenger("Luke Passenger");
                    L04Agent agent=new L04Agent("Rick the Agent");
                    
                    String [] stationIni={"London","Hithrow","Gatwick","Luton",
                        "Birmingham", "Manchester", "Liverpool",
                        "Leeds",
                        "Glasgow","Edinburgh","Inverness" };
                    L04Station station;
                    for (String s : stationIni)
                        station=new L04Station(s);
                    // System.out.print(L04Station.dumpAll());
                    
                    String routeIni[][]={ 
                        {"London","Birmingham","Manchester","Liverpool"},
                        {"Luton","Hithrow","London","Gatwick"},
                        {"London","Birmingham", "Manchester","Liverpool","Glasgow","Edinburgh"},
                        {"Manchester","Birmingham","London","Gatwick"},
                        {"Glasgow","Leeds","Levrpool"}, // should fail
                        {"London","Edinburgh"},
                        {"London","Leeds","Glasgow","Edinburgh","Inverness"},
                        };
                    int routeIniNr[]={ 1, 101, 57, 17, 33, 5, 13 };
                    L04RouteMain route;
                    int count=0;
                    for (String[] t_route : routeIni) {
                        // System.out.print("Adding route "+String.join(" - ", t_route));
                        route=new L04RouteMain(routeIniNr[count++]);
                        boolean success=route.addStation(t_route);
                        // System.out.println(" : "+((success)?"OK":"failed!"));
                        if (!success)
                            route.remove();
                        if (!route.uniquity()) {
                            // System.out.println("Duplicate route! Removed.");
                            // route.remove();
                        }
                        
                    }
                    // System.out.print(L04RouteMain.dumpAll());
                    
                    route=new L04RouteMain(23);
                    route.addStation("Glasgow","Leeds","Manchester","Liverpool");
                    if (!route.uniquity()) {
                        // System.out.println("Duplicate route! Removed.");
                        // route.remove();
                    }
                    else {
                        // System.out.println(route.dump());
                    }
                    
                    route=new L04RouteMain(175,"Inverness","Edinburgh");
                    route.uniquity();
                    

                    // System.out.print(L04Station.dumpAll());
                    // System.out.print(L04RouteMain.dumpAll());
                    
                    // route.createReverseRoute();

                    L04RouteMain.createReverseRoutesAll();
                    stub=MyIO.getString("Press ENTER to see stations >");
                    System.out.print(L04Station.dumpAll());
                    stub=MyIO.getString("Press ENTER to see routes >");
                    System.out.print(L04RouteMain.dumpAll());
                    
                    // ========= set prices
                    stub=MyIO.getString("Press ENTER to see rates >");
                    String rateStation[][]= {
                        { "Liverpool", "Manchester" },
                        { "Manchester", "Birmingham" },
                        { "Manchester", "Leeds" },
                        { "Birmingham", "London" },
                        { "London", "Leeds" },
                        { "London", "Hithrow" },
                        { "London", "Gatwick" },
                        { "Hithrow", "Luton" },
                        { "Leeds", "Glasgow" },
                        { "Glasgow", "Edinburgh" },
                        { "Edinburgh", "Inverness" },
                        { "London", "Edinburgh"},
                        { "Liverpool", "Glasgow"},
                    };
                    int rateValue[]={ 10, 15, 12, 25, 27, 8, 8, 7, 38, 15, 12, 95, 15 };
                    
                    L04Rate rate;
                    for (int i=0;i<rateValue.length;i++) {
                        rate=new L04Rate(
                                L04Station.findByName(rateStation[i][0]),
                                L04Station.findByName(rateStation[i][1]),
                                rateValue[i]
                        );
                        System.out.println(rate.dump());
                    }

                    stub=MyIO.getString("Press ENTER to make inquiry & see travel options >");
                    L04Inquiry inquiry=passenger.makeInquiry(
                            agent,
                            L04Station.findByName("London"),
                            L04Station.findByName("Edinburgh"),
                            "15-04-2015"
                            // "15-4-2015" OK
                            // "5-4-15" => 05-04-0015
                            // "32-4-2015" => 02-05-2015
                            // "1-Apr-2015" => as it was initialized by class def
                            );
                    
                    System.out.println("Inquiry:\n" + inquiry.dump());
                    ArrayList<L04RouteAdhoc> travelOptions=inquiry.passToAgent();
                    System.out.println("Travel options:\n" + L04RouteAdhoc.dumpAll());
                    
                    stub=MyIO.getString("Press ENTER to see invoice >");
                    L04RouteAdhoc targetRoute=passenger.findCheapestAndShortest(travelOptions);
                    L04Invoice invoice=new L04Invoice(inquiry,targetRoute);
                    // System.out.printf("\u00A3%4d %s%n",targetRoute.tariff,targetRoute.dump());
                    System.out.println(invoice.dump());
                    
                    // clean up
                    L04RouteAdhoc.reset();
                    L04Rate.reset();
                    L04RouteMain.reset();
                    L04Station.reset();
                    
                    break;
            }
        } while (labnr!=0);
    }
    
    
}