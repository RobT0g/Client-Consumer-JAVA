/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client.consumer;

/**
 *
 * @author robso
 */
public class Consumer implements Runnable{
    public Buffer b;
    private int amnt = 10;
    static javax.swing.JLabel output;
    
    public Consumer(Buffer b){
        this.b = b;
    }
    
    public Consumer(Buffer b, int amnt, javax.swing.JLabel out){
        this.b = b;
        this.amnt = amnt;
        output = out;
    }
    
    public void run(){
        for(int i = 0; i < this.amnt; i++){
            String t = this.b.consume();
            if(output != null)
                output.setText(t);
        }
    }
}
