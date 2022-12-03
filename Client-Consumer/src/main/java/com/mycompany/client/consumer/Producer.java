/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client.consumer;

/**
 *
 * @author robso
 */
public class Producer implements Runnable{
    public Buffer b;
    private int amnt = 10;
    
    public Producer(Buffer b){
        this.b = b;
    }
    
    public Producer(Buffer b, int amnt){
        this.b = b;
        this.amnt = amnt;
    }
    
    public void run(){
        for(int i = 0; i < this.amnt; i++){
            this.b.produce();
        }
    }
}
