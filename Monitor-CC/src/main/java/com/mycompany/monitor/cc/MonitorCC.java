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
        //Especificações de tamanho
        int bufferSize = 10;
        
        //Declaração das Threads
        final Processor p = new Processor(bufferSize);
        Thread t1 = new Thread(new Producer(p));
        Thread t2 = new Thread(new Consumer(p));
        
        //Código pelo terminal
        /*t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){}*/
        
        //Código pela interface
        Interface.main(args, p);
    }
}
