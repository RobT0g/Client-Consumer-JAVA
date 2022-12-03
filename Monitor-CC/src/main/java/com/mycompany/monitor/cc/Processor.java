/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monitor.cc;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author robso
 */
public class Processor {
    private final String[] data = {"Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit,", "sed", "do", "eiusmod", 
        "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua.", "Ut", "enim", "ad", "minim", "veniam,", "quis", 
        "nostrud", "exercitation", "ullamco", "laboris", "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat.", "Duis", "aute", 
        "irure", "dolor", "in", "reprehenderit", "in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla", "pariatur.", 
        "Excepteur", "sint", "occaecat", "cupidatat", "non", "proident,", "sunt", "in", "culpa", "qui", "officia", "deserunt", "mollit", "anim", 
        "id", "est", "laborum"};
    static javax.swing.JLabel bufferOut;
    static javax.swing.JLabel consOut;
    static javax.swing.JLabel prodOut;
    private LinkedList<String> buffer = new LinkedList<>();
    private int len;
    private int current = 0;
    
    public Processor(int size){
        this.len = size;
    }
    
    public void setOutput(javax.swing.JLabel out1, javax.swing.JLabel out2, javax.swing.JLabel out3){
        bufferOut = out1;
        consOut = out2;
        prodOut = out3;
    }
    
    public synchronized void produce() throws InterruptedException{
        while(current < 68){
            if(bufferOut != null)
                Thread.sleep(500);
            while(buffer.size() == this.len){
                this.wait();
            }
            buffer.add(this.data[this.current]);
            System.out.println("Added " + this.data[this.current]);
            if(prodOut != null)
                prodOut.setText("Added " + this.data[this.current]);
            this.current++;
            this.notify();
            if(bufferOut != null)
                bufferOut.setText(this.toString());
        }
    }
    
    public synchronized void consume() throws InterruptedException{
        while(!buffer.isEmpty() || this.current < 68){
            if(bufferOut != null)
                Thread.sleep(500);
            while(buffer.size() < this.len && this.current < 68){
                this.wait();
            }
            String val = this.buffer.removeFirst();
            System.out.println("Consumed " + val);
            if(consOut != null)
                consOut.setText("Consumed " + val);
            this.notify();
            if(bufferOut != null)
                bufferOut.setText(this.toString());
        }
    }
    
    @Override
    public String toString(){
        return "" + this.buffer;
    }
}
