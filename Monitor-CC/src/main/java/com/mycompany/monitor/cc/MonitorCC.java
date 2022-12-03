/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.monitor.cc;

/**
 *
 * @author robso
 */
public class MonitorCC {

    public static void main(String[] args) throws InterruptedException {
        final Processor p = new Processor();
        
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try{
                    p.produce();
                } catch(InterruptedException e){}
            }
        });
        
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                try{
                    p.consume();
                } catch(InterruptedException e){}
            }
        });
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            
        }
    }
}
