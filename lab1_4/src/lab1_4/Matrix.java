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
public class Matrix {
    protected float mx[][]; // =new float[5][5];
    
    Matrix(int dim) {
        mx=new float[dim][dim];
        init();
    }
    
    public void init() {
        for (float[] mx1 : mx) {
            for (int j = 0; j < mx1.length; j++) {
                mx1[j] = (float)(Math.random()*100);
            }
        }
    }
    
    public void ror(byte m) { // roll right
        if (m==0)
            return;
        
        for (float[] mx1 : mx) {
            // roll vector right
            // a b c d e  =(+2)=> d e a b c
            byte shift; // per vector shifting value
            shift=(byte)(m % mx1.length); // "cut" shifting value
            if (shift<0) shift=(byte)(mx1.length+shift); // convert negative into equivalent positive
            if (shift==0) // skip if nothing to do
                continue;
            byte targetPos=shift;
            float t0, t1=mx1[0]; // hold temporary value
            for (int i=0;i<mx1.length;i++) {
                t0=mx1[targetPos];
                mx1[targetPos]=t1;
                t1=t0;
                targetPos=(byte)((targetPos+shift)%mx1.length);
            }
        }
    }
    
    public void print(String message) {
        // see https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
        System.out.printf("%s%n",message);
        for (int i=0;i<mx.length;i++) {
            for (int j=0;j<mx[i].length;j++)
                System.out.printf("%12.9f ",mx[i][j]);
            System.out.printf("%n");
        }
            
    }
}
