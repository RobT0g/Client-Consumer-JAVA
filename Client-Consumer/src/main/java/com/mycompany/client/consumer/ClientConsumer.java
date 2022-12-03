/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.client.consumer;

/**
 *
 * @author robso
 */
public class ClientConsumer {

    public static void main(String[] args) {
        //Interface.main(args);
        Buffer b = new Buffer();
        
        Thread consumer = new Thread(new Consumer(b));
        Thread producer = new Thread(new Producer(b));
        consumer.start();
        producer.start();
        
        try{
            consumer.join();
            producer.join();
        }catch(InterruptedException e){
            System.out.println("ERRRO");
        }
        System.out.println(b);
    }
}
