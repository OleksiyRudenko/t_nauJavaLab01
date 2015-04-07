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
public class Student {
    //    Класс Студент:
    //    Фамилия, Имя, Отчество, Студенческий
    //    билет, Курс, Страна, Пол, Успеваемость;
    //    Конструктор;
    //    Методы: установка значений атрибутов,
    //    получение значений атрибутов, вывод
    //    информации
    static public enum countries { UA, KZ, BY, PL };

    protected String surname="", name="", patronimic="", studentId="";
    protected int   studyLife=1, // study life time, years
                    avgMark=0; // 0-5
    protected char sex='m'; // m|f
    protected countries country=countries.UA;
    
    public Student() {}
    
    public Student(String surname, String name, String patronimic, char sex, countries country, 
            String studentId, int studyLife, int avgMark
            ) {
        setSurname(surname);
        setName(name);
        setPatronimic(patronimic);
        setSex(sex);
        setCountry(country);
        setStudentId(studentId);
        setStudyLife(studyLife);
        setAvgMark(avgMark);
    }
    
    public Student(String[] d) {
        setSurname(d[0]);
        setName(d[1]);
        setPatronimic(d[2]);
        setSex(d[3].toCharArray()[0]);
        setCountry(countries.valueOf(d[4]));
        setStudentId(d[5]);
        setStudyLife(Integer.parseUnsignedInt(d[6]));
        setAvgMark(Integer.parseUnsignedInt(d[7]));
    }
            

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPatronimic() {
        return patronimic;
    }
    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getStudyLife() {
        return studyLife;
    }
    public void setStudyLife(int studyLife) {
        this.studyLife = (studyLife<1)?1
                :((studyLife>5)?5:studyLife);
    }

    public int getAvgMark() {
        return avgMark;
    }
    public void setAvgMark(int avgMark) {
        this.avgMark = (avgMark<0)?0:(avgMark>5)?5:avgMark;
    }

    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = (sex=='m' || sex=='f')?sex:'m';
    }

    public countries getCountry() {
        return country;
    }
    public void setCountry(countries country) {
        this.country = country;
    }
    
    public void print() {
        System.out.printf(
                "Student %s #%s - %-30s (%c) - Year of study %d - Average mark=%d%n",
                country, studentId, 
                surname+" "+name+" "+patronimic, sex,
                studyLife, avgMark
                );
    }
    // 1. Список студентов-отличников 2-го курса.
    // 2. Список студентов-иностранцев, которые учатся на "4" и"5".
    // 3. Список студентов-женщин 5-го курса, которые учатся на "5".
    
    /* public static Student[] select(
            int studylife, // year or -1 for any
            int avgmark, // 0-5 or -1 for any
            char sex, // m|f, otherwise any
            String countries // list from static enum, empty - any, -UA = excl UA
            ) {
        
    } */
    
}
