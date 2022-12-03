/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitor.cc;

/**
 *
 * @author robso
 */
public class Producer implements Runnable{
    static Processor pros;
    
    public Producer(Processor p){
        pros = p;
    }
    
    public void run(){
        try{
            pros.produce();
        } catch(InterruptedException e){}
    }
}
