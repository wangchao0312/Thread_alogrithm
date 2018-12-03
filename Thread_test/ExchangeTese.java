package Thread_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangeTese {

    static class Producer implements Runnable{

        //生产者、消费者交换的数据结构
        private List<String> buffer_receive;
        private List<String> buffer_send=new ArrayList<>();
        //步生产者和消费者的交换对象
        private Exchanger<List<String>> exchanger;

        Producer(List<String> buffer,Exchanger<List<String>> exchanger){
            this.buffer_receive = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for(int i = 1 ; i < 5 ; i++){
              //  System.out.println("生产者第" + i + "次提供");
                for(int j = 1 ; j <= 3 ; j++){
                  //  System.out.println("生产者装入" + i  + "--" + j);
                    buffer_send.add("生产者给消费者的数据：" + i + "--" + j);
                }

                //System.out.println("生产者装满，等待与消费者交换...");
                try {
                    buffer_receive=exchanger.exchange(buffer_send);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 1; j <= 3 ; j++) {
                    System.out.println("生产者从消费者获取的数据 : " + buffer_receive.get(0));
                    buffer_receive.remove(0);
                }
                System.out.println("生产者获取数据完成！！");
                System.out.println("");
            }
        }
    }

    static class Consumer implements Runnable {
        private List<String> buffer_send=new ArrayList<>();
        private List<String> buffer_receive;

        private final Exchanger<List<String>> exchanger;

        public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer_receive = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {

            for (int i = 1; i < 5; i++) {
                //调用exchange()与消费者进行数据交换
                for(int j = 5 ; j <= 7 ; j++){
                    //  System.out.println("生产者装入" + i  + "--" + j);
                    buffer_send.add("消费者给生产者的数据：" + i + "--" + j);
                }
                try {
                    buffer_receive = exchanger.exchange(buffer_send);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               //System.out.println("消费者第" + i + "次提取");
                for (int j = 1; j <= 3 ; j++) {
                    System.out.println("消费者从生产者得到的数据 : " + buffer_receive.get(0));
                    buffer_receive.remove(0);
                }
                System.out.println("消费者获取数据完成！！");
                System.out.println("");
            }
        }
    }

    public static void main(String[] args){
        List<String> buffer1 = new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();

        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

        Thread producerThread = new Thread(new Producer(buffer1,exchanger));
        Thread consumerThread = new Thread(new Consumer(buffer2,exchanger));

        producerThread.start();
        consumerThread.start();
    }
}