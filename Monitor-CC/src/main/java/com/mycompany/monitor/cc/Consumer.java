/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitor.cc;

/**
 *
 * @author robso
 */
public class Consumer implements Runnable{
    static Processor pros;
    
    public Consumer(Processor p){
        pros = p;
    }
    
    public void run(){
        try{
            pros.consume();
        } catch(InterruptedException e){}
    }
}
