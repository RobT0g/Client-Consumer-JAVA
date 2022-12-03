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
        //Especificações de tamanho
        int bufferSize = 10;        //Mudar isso para configurar o tamanho do buffer
        int timesRanConsumer = 30;  //Mudar isso para o número de vezes que o consumidor será executado
        int timesRanProducer = 30;  //Mudar isso para o número de vezes que o produtor será executado
        
        //Código pelo terminal
        /*Buffer b = new Buffer(bufferSize, null);
        
        Thread consumer = new Thread(new Consumer(b, timesRanConsumer, null));
        Thread producer = new Thread(new Producer(b, timesRanProducer, null));
        consumer.start();
        producer.start();
        
        try{
            consumer.join();
            producer.join();
        }catch(InterruptedException e){
            System.out.println("ERRRO");
        }
        System.out.println(b);*/
        
        //Código pela interface
        Interface.main(args, bufferSize, timesRanConsumer, timesRanProducer);
    }
}
