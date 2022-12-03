/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client.consumer;
import java.util.concurrent.Semaphore;

public class Buffer {
    private final String[] data = {"Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit,", "sed", "do", "eiusmod", 
        "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua.", "Ut", "enim", "ad", "minim", "veniam,", "quis", 
        "nostrud", "exercitation", "ullamco", "laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat.", "Duis", "aute", 
        "irure", "dolor", "in", "reprehenderit", "in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla", "pariatur.", 
        "Excepteur", "sint", "occaecat", "cupidatat", "non", "proident,", "sunt", "in", "culpa", "qui", "officia", "deserunt", "mollit", "anim", 
        "id", "est", "laborum"};
    private int step = 0;
    private int size = 10;
    static javax.swing.JLabel output;
    public String[] queue = new String[10];
    static Semaphore prod = new Semaphore(0); 
    static Semaphore cons = new Semaphore(1); 
    
    public Buffer(){}
    
    public Buffer(int size, javax.swing.JLabel out){
        this.size = size;
        this.queue = new String[this.size];
        output = out;
    }
    
    private boolean push(String item){
        int i;
        for(i = 0; i < this.size; i++){
            if(this.queue[i] == null)
                break;
        }
        if(i == 10){
            System.out.println("Buffer is full!");
            return false;
        }
        this.queue[i] = item;
        if(output != null)
            output.setText(this.toString());
        return true;
    }
    
    private String free(){
        if(this.queue[0] == null){
            System.out.println("Buffer is empty!");
            return null;
        }
        String first = this.queue[0];
        int i;
        for(i = 0; i < this.size-1; i++){
            this.queue[i] = this.queue[i+1];
            if(this.queue[i] == null)
                break;
        }
        this.queue[i+1] = null;
        if(output != null)
            output.setText(this.toString());
        return first;
    }
    
    public String toString(){
        if(this.queue[0] == null){
            return "Empty queue";
        }
        String txt = "" + this.queue[0];
        for(int i = 1; i < this.size-1; i++){
            if(this.queue[i] == null)
                break;
            txt += ", " + this.queue[i];
        }
        return txt;
    }
    
    public String consume(){
        try{
            cons.acquire();
            if(output != null)
                Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("InterruptedException caught");
            return "ERROR";
        }
        String consumed = this.free();
        prod.release();
        if(consumed != null){
            System.out.println("Consumer got this " + consumed + " item;");
            return "Consumer consumed " + consumed;
        }
        return "Empty buffer";
    }
    
    public String produce(){
        try{
            prod.acquire();
            if(output != null)
                Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("InterruptedException caught");
            return "ERROR";
        }
        if(this.step < 69){
            String toPush = this.data[this.step];
            boolean pushed = this.push(toPush);
            cons.release();
            if(pushed){
                System.out.println("Producer generated " + toPush);
                this.step++;
                return "Producer generated " + toPush;
            }
            return "Buffer full";
        } else {
            System.out.println("Data fully produced");
            return "Data fully produced";
        }
    }
}
