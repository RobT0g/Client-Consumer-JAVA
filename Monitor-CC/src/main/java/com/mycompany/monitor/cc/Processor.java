/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitor.cc;

import java.util.Scanner;

/**
 *
 * @author robso
 */
public class Processor {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer running...");
            wait();
            System.out.println("Producer resumed");
        }
    }
    
    public void consume() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized(this){
            System.out.println("Waiting for input...");
            scan.nextLine();
            System.out.println("Got the input.");
            notify();
        }
    }
}
